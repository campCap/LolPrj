package com.lol.webapp.entity;

import org.json.JSONObject;

public class Info {
	String name = "";
	String key = "RGAPI-c489a450-db49-4935-a218-58740cd8f9dc";
	String url = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key=" + key;
	JSONObject obj = new JSONObject();
}
