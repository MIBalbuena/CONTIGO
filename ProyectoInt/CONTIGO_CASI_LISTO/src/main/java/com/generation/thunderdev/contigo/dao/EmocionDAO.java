package com.generation.thunderdev.contigo.dao;

import java.util.Date;
import java.util.List;

import com.generation.thunderdev.contigo.model.Emocion;

public interface EmocionDAO {
	
	
	public List<Emocion> getAllEmotion(String userName);
	public Emocion getCurrentEmotion(String userName, String currentDate );
	public void insertEmocion(int idEmocion, int idUsuario, Date fecha);

}
