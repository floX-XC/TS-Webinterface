package de.flox.ts.api;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TeamSpeakInstaller {
	
	//TS-Link: https://files.teamspeak-services.com/releases/server/3.9.1/teamspeak3-server_linux_amd64-3.9.1.tar.bz2
	//tar -xzvf teamspeak3-server_linux*.tar.gz
	
	public static File f = new File("downloadTS.sh");
	public static File start = new File("start.sh");
	public static File stop = new File("stop.sh");
	
	public static void createStartFile() throws Exception{
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		BufferedWriter ws = new BufferedWriter(new FileWriter(start));
		BufferedWriter wp = new BufferedWriter(new FileWriter(stop));
		writer.write("wget https://files.teamspeak-services.com/releases/server/3.9.1/teamspeak3-server_linux_amd64-3.9.1.tar.bz2 && tar xfvj teamspeak3-server_linux_amd64-3.9.1.tar.bz2 && cd teamspeak3-server_linux_amd64/ && touch .ts3server_license_accepted && chmod 777 ts3server_minimal_runscript.sh && chmod 777 ts3server_startscript.sh");
		writer.close();
		ws.write("cd teamspeak3-server_linux_amd64/ && ./ts3server_startscript.sh start");
		ws.close();
		wp.write("cd teamspeak3-server_linux_amd64/ && ./ts3server_startscript.sh stop");
		wp.close();
		Runtime.getRuntime().exec("chmod 777 downloadTS.sh");
		Runtime.getRuntime().exec("chmod 777 start.sh");
		Runtime.getRuntime().exec("chmod 777 stop.sh");
	}
	public void installTeamspeak() throws Exception{
		
		Runtime.getRuntime().exec("./downloadTS.sh");	
		
    }
	public void startTeamspeak() throws Exception{
		Runtime.getRuntime().exec("./start.sh");
	}
	public void stopTeamspeak() throws Exception{
		Runtime.getRuntime().exec("./stop.sh");
	}

}
