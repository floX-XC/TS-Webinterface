package de.flox.ts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.flox.ts.api.TeamSpeakInstaller;

@Controller
public class TS3DownloadController {
	
    @PostMapping("/ts3download")
    public String greetingSubmit(@ModelAttribute("download") TeamSpeakInstaller installer) {
    	try {
			installer.installTeamspeak();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "tsinstall";
    }
    @PostMapping("/ts3start")
    public String startTS(@ModelAttribute("start") TeamSpeakInstaller installer) {
    	try {
			installer.startTeamspeak();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "tsinstall";
    }
    @PostMapping("/ts3stop")
    public String stopTS(@ModelAttribute("stop") TeamSpeakInstaller installer) {
    	try {
			installer.stopTeamspeak();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "tsinstall";
    }
}
