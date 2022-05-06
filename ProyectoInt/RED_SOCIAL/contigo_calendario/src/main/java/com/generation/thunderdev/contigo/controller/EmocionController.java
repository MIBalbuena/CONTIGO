package com.generation.thunderdev.contigo.controller;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.thunderdev.contigo.service.EmocionService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class EmocionController {

	@Autowired
	EmocionService emocionService;

	@RequestMapping("/calendario")
	public String index() {
		return "redirect:/calendar";
	}

	@RequestMapping(value = "/emociones", method = RequestMethod.GET, produces = "application/json")
	public String getEmployees() {
		Gson gson = new Gson();
		JsonElement je = gson.toJsonTree(emocionService.getAllEmotion(""));
		JsonObject jo = new JsonObject();
		jo.add("emociones", je);

		return jo.toString();
	}

	@PostMapping(value = "/registroEmocion", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String registroEmocion(@RequestBody String idEmocion) {
		
		LocalDate currentDate = LocalDate.now();
		 
				ZoneId systemTimeZone = ZoneId.systemDefault();
				
				// converting LocalDateTime to ZonedDateTime with the system timezone
				ZonedDateTime zonedDateTime = currentDate.atStartOfDay(systemTimeZone);
				
				// converting ZonedDateTime to Date using Date.from() and ZonedDateTime.toInstant()
				Date utilDate = Date.from(zonedDateTime.toInstant());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName =  auth.getName();
		
		emocionService.inserEmocion(1,1,utilDate);
		
		
		return "hola";
	}

}
