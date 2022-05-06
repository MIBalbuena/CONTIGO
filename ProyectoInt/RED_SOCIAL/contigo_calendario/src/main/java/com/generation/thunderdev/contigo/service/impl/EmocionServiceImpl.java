package com.generation.thunderdev.contigo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.thunderdev.contigo.dao.EmocionDAO;
import com.generation.thunderdev.contigo.model.Emocion;
import com.generation.thunderdev.contigo.model.UsuarioEmocion;
import com.generation.thunderdev.contigo.service.EmocionService;

@Service
public class EmocionServiceImpl implements EmocionService{
	
	@Autowired
	EmocionDAO emocionDao;

	@Override
	public List<Emocion> getAllEmotion(String userName) {
	
		return emocionDao.getAllEmotion(userName);
	}

	@Override
	public void inserEmocion(int idEmocion, int idUsuario, Date fecha) {
		emocionDao.insertEmocion(idEmocion, idUsuario, fecha);
		
	}

}
