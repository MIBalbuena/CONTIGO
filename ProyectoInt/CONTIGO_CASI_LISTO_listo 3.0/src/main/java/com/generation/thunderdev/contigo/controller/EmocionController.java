package com.generation.thunderdev.contigo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

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
import org.springframework.web.servlet.ModelAndView;

import com.generation.thunderdev.contigo.service.EmocionService;
import com.generation.thunderdev.contigo.service.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class EmocionController {

	@Autowired
	EmocionService emocionService;
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/calendario")
	public String index() {
		return "redirect:/calendar";
	}
	
	
	@RequestMapping("/MiEmocion")
	public ModelAndView  miEmocion() {
		 ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("registrodelaemocion");
		    return modelAndView;
	 
	}
	
	
	 
	
	
	@RequestMapping(value = "/current_emotion", method = RequestMethod.GET, produces = "application/json")
	public String getCurrentEmocion() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName =  auth.getName();
	 
		
		LocalDate currentDate = LocalDate.now();
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = currentDate.atStartOfDay(systemTimeZone);
		Date utilDate = Date.from(zonedDateTime.toInstant());
		
	 
		
		Gson gson = new Gson();
		JsonElement je = gson.toJsonTree(emocionService.getCurrentEmotion(userName,utilDate.toString()));
		JsonObject jo = new JsonObject();
		jo.add("emociones", je);

		return jo.toString();
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
	public ModelAndView registroEmocion(@RequestBody String idEmocion) {
		
		
		int idEmo = Integer.parseInt( idEmocion.split("=")[1] );
		
		LocalDate currentDate = LocalDate.now();
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = currentDate.atStartOfDay(systemTimeZone);
		Date utilDate = Date.from(zonedDateTime.toInstant());
		
		
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName =  auth.getName();
		int idUsr = usuarioService.getIdUsuarioByUserName(userName);
		emocionService.inserEmocion(idEmo,idUsr,utilDate);
		
		 ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("calendar");
		    return modelAndView;
		
		
		
	}

}
