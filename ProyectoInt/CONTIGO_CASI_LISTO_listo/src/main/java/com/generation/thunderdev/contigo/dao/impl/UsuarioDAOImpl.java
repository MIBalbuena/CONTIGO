package com.generation.thunderdev.contigo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.generation.thunderdev.contigo.dao.UsuarioDAO;
import com.generation.thunderdev.contigo.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private DataSource dataSource;

	private NamedParameterJdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Usuario> getIdUsuarioByUserName(String userName) {

		String sql = "select usr.idUsuario from contigo.usuario as usr  " + "where usr.nombreUsuario = :nombreUsuario";

		List<Usuario> usuarioLst = jdbcTemplate.query(sql, new MapSqlParameterSource("nombreUsuario", userName),
				(resultSet, i) -> {
					return getValue(resultSet);
				});
		
		return usuarioLst;
	}

	private Usuario getValue(ResultSet resultSet) throws SQLException {

		Usuario usr = new Usuario();
		
		int idUsuario = resultSet.getInt("idusuario");
		usr.setIdusuario(idUsuario);
		return usr;
	}

}
