package de.flox.ts.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatLog {
	
	public File f = new File("chatlog.txt");
	
	public void chatLog(String message, String username) throws Exception{
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		writer.write(dtf.format(now)+"-Username: "+username+"-Message: "+message);
		writer.close();
	}

}
