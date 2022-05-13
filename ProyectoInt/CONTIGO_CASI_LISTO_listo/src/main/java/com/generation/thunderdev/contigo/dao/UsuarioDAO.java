package com.generation.thunderdev.contigo.dao;

import java.util.List;

import com.generation.thunderdev.contigo.model.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> getIdUsuarioByUserName(String userName);

}
