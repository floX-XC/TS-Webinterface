package de.flox.ts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginValues {
	
	 public File f = new File("user.txt");
	 public Properties p = new Properties();
	 
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
		    		
		    	p.setProperty("username", "test");
		    	p.setProperty("password", "1234");
		    		
		    	p.store(new FileOutputStream(f), "user.txt");
		    		
		    	System.out.println("Login erfolgreich gespeichert"); 
		    		 
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
	    		
	    		
	    }else {
	    	System.out.println("Login vorhanden. Editiere Login für neue Zugangsdaten"); 
	    }
	    	
	 }
	 public String getUsername() {
	    	try {
				p.load(new FileReader(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String username = p.getProperty("username");
	    	return username;
	 }
	 public String getPassword() {
	    	try {
				p.load(new FileReader(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String pw = p.getProperty("password");
	    	return pw;
	 }
	 
}
