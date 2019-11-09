package de.flox.ts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class BotValues {
	
	private String nickname, username, password, host;
    private int port;
    public File f = new File("config.txt");
    public Properties p = new Properties();
    
    public String getNickname() {
    	return nickname;
    }
    public String getUsername() {
    	return username;
    }
    public String getPassword() {
    	return password;
    }
    public int getPort() {
    	return port;
    }
    public String getHost() {
    	return host;
    }
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }
    public void setHost(String host) {
    	this.host = host;
    }
    public void setUsername(String username) {
    	this.username = username;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setPort(int port) {
    	this.port = port;
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
	    		
	    		p.setProperty("botname", getNickname());
	    		p.setProperty("username", getUsername());
	    		p.setProperty("password", getPassword());
	    		p.setProperty("host", getHost());
	    		p.setProperty("port", String.valueOf(getPort()));
	    		
	    		p.store(new FileOutputStream(f), "config.txt");
	    		
	    		System.out.println("Bot erfolgreich gespeichert"); 
	    		 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}else {
    		System.out.println("Config vorhanden. Lösche Config um neuen Bot zu erstellen"); 
    	}
    	
    }
    public String getCFGUsername() {
    	try {
			p.load(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String user = p.getProperty("username");
    	return user;
    }
    public String getCFGNickname() {
    	try {
			p.load(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String nick = p.getProperty("botname");
    	return nick;
    }
    public String getCFGHost() {
    	try {
			p.load(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String nick = p.getProperty("host");
    	return nick;
    }
    public String getCFGPassword() {
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
    public int getCFGPort() {
    	try {
			p.load(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int port1 = Integer.parseInt(p.getProperty("port"));
    	return port1;
    }

}
