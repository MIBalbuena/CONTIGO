package com.generation.thunderdev.contigo.service;

import java.util.Date;
import java.util.List;

import com.generation.thunderdev.contigo.model.Emocion;

public interface EmocionService {
	
	public List<Emocion> getAllEmotion(String userName);
	public Emocion getCurrentEmotion(String userName, String date);
	public void inserEmocion(int idEmocion, int idUsuario, Date fecha);
}
