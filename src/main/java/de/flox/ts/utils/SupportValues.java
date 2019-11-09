package de.flox.ts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SupportValues {
	
	private String message, id;
    public File f = new File("support.txt");
    public Properties p = new Properties();
    
    public String getMessage() {
    	return message;
    }
    public String getID() {
    	return id;
    }
    public void setMessage(String message) {
    	this.message = message;
    }
    public void setID(String id) {
    	this.id = id;
    }
public boolean isFileAvaible() {
    	
    	if(f.exists()) {
    		return true;
    	}else {
    		System.out.println("Config nicht vorhanden. Erstelle neue config");
    		return false;
    	}
    }
    public void writeFile() {
    	
    	if(!isFileAvaible()) {
    		try {
				f.createNewFile();
				
	    		p.load(new FileInputStream(f));
	    		
	    		p.setProperty("message", getMessage());
	    		p.setProperty("groupid", getID());
	    		
	    		p.store(new FileOutputStream(f), "support.txt");
	    		
	    		System.out.println("Support erfolgreich gespeichert"); 
	    		 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}else {
    		System.out.println("Config vorhanden. Lösche Config um neuen Bot zu erstellen"); 
    	}
    	
    }
    public String getCFGMessage() {
    	try {
			p.load(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String user = p.getProperty("message");
    	return user;
    }
    public String getCFGID() {
    	try {
			p.load(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String nick = p.getProperty("groupid");
    	return nick;
    }

}
