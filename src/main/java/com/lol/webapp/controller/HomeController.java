package com.lol.webapp.controller;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(
			@RequestParam(value = "n", defaultValue = "") String name) throws MalformedURLException {
		
		String key = "RGAPI-84c7e9ef-7f1f-42f5-bcb7-c1e526f80ab6";
		String apiUrl = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/" + name + "/RiotSchmick?api_key=" + key;
		
		URL url = new URL(apiUrl); //<-???
		
		String output = String.format("n:%s", name);
		
		return output;
	}
	
}
