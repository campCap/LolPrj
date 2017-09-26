package com.lol.webapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/*")
public class HomeController {
	
	@RequestMapping("index")
	public String index(
			@RequestParam(value = "n", defaultValue = "") String name,
			Model model ) throws IOException  {
		
		String json = "";
		BufferedReader br;
		String summonerName = "Ä·ÇÁÄ¸";
		summonerName = URLEncoder.encode(summonerName, "UTF-8");
		
		String key = "RGAPI-c489a450-db49-4935-a218-58740cd8f9dc";
		String apiURL = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+ summonerName +"?api_key=" + key;
		
		URL url = new URL(apiURL); 
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type", "application/json");//<-???
		br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

		json = br.readLine();
		connection.disconnect();
		model.addAttribute("info", json);
		
		return "index";
	}
}
