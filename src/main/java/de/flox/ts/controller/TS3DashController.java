package de.flox.ts.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.theholywaffle.teamspeak3.api.ChannelProperty;

import de.flox.ts.api.TSAPI;
import de.flox.ts.utils.BotValues;
import de.flox.ts.utils.ChannelValues;
import de.flox.ts.utils.SupportValues;
import de.flox.ts.utils.WelcomeValues;

@Controller
public class TS3DashController {
	
    @GetMapping("/ts3dash")
    public String greetingForm(Model model) {
        model.addAttribute("bot", new BotValues());
        return "ts3dash";
    }

    @PostMapping("/ts3dash")
    public String greetingSubmit(@ModelAttribute("bot") BotValues botValues) {
    	System.out.println("Nickname: "+botValues.getNickname() + " Port: "+botValues.getPort() + " Username: "+botValues.getUsername() + " Password: "+botValues.getPassword());
        botValues.writeFile();
    	return "welcome";
    }
    @PostMapping("/ts3startbot")
    public String startBot(@ModelAttribute("startbot") BotValues botValues) {
    	String username = botValues.getCFGUsername();
    	String nickname = botValues.getCFGNickname();
    	String pw = botValues.getCFGPassword();
    	String host = botValues.getCFGHost();
    	int port = botValues.getCFGPort();
    	System.out.print("Port: "+port);
    	TSAPI api = new TSAPI();
    	api.connectServer(host, nickname, username, pw, port);
    	return "welcome";
    }
    @PostMapping("/ts3stopbot")
    public String stopBot(@ModelAttribute("stopbot") BotValues botValues) {
    	TSAPI api = new TSAPI();
    	api.disconnectBot();
    	return "welcome";
    }
    
    //Support Nachricht 
    @GetMapping("/ts3support")
    public String getSupport(Model model) {
        model.addAttribute("support", new SupportValues());
        return "ts3dash";
    }
    @PostMapping("/ts3support")
    public String setSupport(@ModelAttribute("support") SupportValues sup) {
    	System.out.println("Message: "+sup.getMessage() + " ID's: "+sup.getID());
        sup.writeFile();
    	return "ts3dash";
    }
    @GetMapping("/ts3Channel")
    public String setChannel(Model model) {
        model.addAttribute("channel", new ChannelValues());
        return "ts3dash";
    }
    @PostMapping("/ts3Channel")
    public String createChannel(@ModelAttribute("channel") ChannelValues values) {
    	System.out.println(values.getName());
    	TSAPI api = new TSAPI();
    	final Map<ChannelProperty, String> properties = new HashMap<>();
		properties.put(ChannelProperty.CHANNEL_FLAG_PERMANENT, "1");
		int defaultChannelId = api.ts3api.whoAmI().getChannelId();
		properties.put(ChannelProperty.CPID, String.valueOf(defaultChannelId));
		
    	api.ts3api.createChannel(values.getName(), properties);
    	
    	return "ts3dash";
    }
    @GetMapping("/ts3Welcome")
    public String getWelcomemessage(Model model) {
        model.addAttribute("welcome", new WelcomeValues());
        return "ts3dash";
    }
    @PostMapping("/ts3Welcome")
    public String createWelcomemessage(@ModelAttribute("welcome") WelcomeValues welcome) {
    	welcome.writeFile();
    	return "ts3dash";
    }

}
