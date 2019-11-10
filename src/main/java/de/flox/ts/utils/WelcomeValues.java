package de.flox.ts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WelcomeValues {
	
	private String message;
    public File f = new File("welcome.txt");
    public Properties p = new Properties();
    
    public void setMessage(String message) {
    	this.message = message;
    }
    public String getMessage() {
    	return message;
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
	    		
	    		p.store(new FileOutputStream(f), "config.txt");
	    		
	    		System.out.println("Wilkommensnachricht gespeichert!"); 
	    		 
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

}
