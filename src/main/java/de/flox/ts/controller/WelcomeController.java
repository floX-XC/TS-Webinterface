package de.flox.ts.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.flox.ts.api.TSAPI;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	@GetMapping("/welcome")
	public ModelAndView getSpace() {	
		
		File file = new File("/");
		long total = file.getTotalSpace() / (1024 * 1024);
		long free = file.getFreeSpace() / (1024 * 1024);
		
		
		ModelAndView model = new ModelAndView("/welcome");
		
		model.addObject("totalspace", total);
		model.addObject("fresspace", free);
		String totalSpace = String.valueOf(total);
		model.addObject("totalString", totalSpace);
		
		System.out.print("Ganzer Speicher: "+total);
		
		//model.addObject("clientsonline", TSAPI.getClients());
		//<li th:text="'Clients online: ' + ${clientsonline} + '"></li>
		model.addObject("clientsonline", 0);
		
		
		return model;
	}
}
