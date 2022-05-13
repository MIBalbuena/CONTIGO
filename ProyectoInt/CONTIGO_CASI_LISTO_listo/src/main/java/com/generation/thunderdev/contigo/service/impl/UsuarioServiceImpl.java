package com.generation.thunderdev.contigo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.thunderdev.contigo.dao.UsuarioDAO;
import com.generation.thunderdev.contigo.model.Usuario;
import com.generation.thunderdev.contigo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDao;


	@Override
	public int getIdUsuarioByUserName(String userName) {
		
		List<Usuario> usrLst = usuarioDao.getIdUsuarioByUserName(userName);
		return usrLst.get(0).getIdusuario();
	}

}
