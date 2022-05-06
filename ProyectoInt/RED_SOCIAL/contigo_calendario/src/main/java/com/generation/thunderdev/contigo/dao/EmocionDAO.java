package com.generation.thunderdev.contigo.dao;

import java.util.Date;
import java.util.List;

import com.generation.thunderdev.contigo.model.Emocion;
import com.generation.thunderdev.contigo.model.UsuarioEmocion;

public interface EmocionDAO {
	
	
	public List<Emocion> getAllEmotion(String userName);
	public UsuarioEmocion getCurrentEmotion(String userName);
	public void insertEmocion(int idEmocion, int idUsuario, Date fecha);

}
