package de.flox.ts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FallbackController {
	
	@RequestMapping("/")
	public String home() {
		return "home.html";
	}
	@RequestMapping("/login")
	public String login() {
		return "login.html";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome.html";
	}
	@RequestMapping("/ts3dash")
	public String ts3dash() {
		return "ts3dash.html";
	}
	@RequestMapping("/addBot")
	public String addBot() {
		return "addBot.html";
	}
	@RequestMapping("/tsinstall")
	public String ts3install() {
		return "tsinstall.html";
	}
}
