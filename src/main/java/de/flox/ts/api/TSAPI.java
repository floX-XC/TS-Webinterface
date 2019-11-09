package de.flox.ts.api;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

public class TSAPI {
	
	public  final TS3Config ts3config = new TS3Config();
	public  final TS3Query ts3query = new TS3Query(ts3config);
	public  final TS3Api ts3api = ts3query.getApi();
	
	public void connectServer(String host, String nickname, String username, String pw, int port) {
		
		ts3config.setHost(host);
		ts3config.setQueryPort(port);
		
		ts3query.connect();
		
		ts3api.login(username, pw);
		ts3api.selectVirtualServerById(1);
		ts3api.setNickname(nickname);
		ts3api.sendChannelMessage("Test");
		
		
	}
	public int getClients() {
		
		int clients = ts3api.getClients().size();
		return clients;
	}
	public void disconnectBot() {
		if(isConnected()) {
			ts3query.exit();
		}else {
			System.out.println("Kein Bot aktiv");
		}
		
	}
	public boolean isConnected() {
		
		if(ts3query.isConnected()) {
			return true;
		}
		return false;
	}

}
