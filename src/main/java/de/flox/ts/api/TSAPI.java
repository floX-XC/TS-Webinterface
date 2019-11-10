package de.flox.ts.api;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

import de.flox.ts.utils.ChatLog;
import de.flox.ts.utils.WelcomeValues;

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
		
		ts3api.addTS3Listeners(new TS3Listener() {
			
			@Override
			public void onTextMessage(TextMessageEvent e) {
				
				ChatLog log = new ChatLog();
				try {
					log.chatLog(e.getMessage(), e.getInvokerName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void onServerEdit(ServerEditedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientMoved(ClientMovedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientLeave(ClientLeaveEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientJoin(ClientJoinEvent e) {
				
				int id = e.getClientId();
				ts3api.sendChannelMessage("gejoint");
				WelcomeValues welcome = new WelcomeValues();
				
				if(welcome.isFileAvaible()) {
					ts3api.sendPrivateMessage(id, welcome.getCFGMessage());
				}else {
					return;
				}
				
			}
			
			@Override
			public void onChannelPasswordChanged(ChannelPasswordChangedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelMoved(ChannelMovedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelEdit(ChannelEditedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelDeleted(ChannelDeletedEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelCreate(ChannelCreateEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
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
