package com.generation.thunderdev.contigo.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.generation.thunderdev.contigo.dao.EmocionDAO;
import com.generation.thunderdev.contigo.model.Emocion;

@Repository
public class EmocionDAOImpl  implements  EmocionDAO {

	 
	@Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    
    
    
    @Override
	public void insertEmocion(int idEmocion, int idUsuario, java.util.Date fecha) { 
    	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();  
    	 
		
    	String sql = "INSERT INTO usuario_emocion " + "(idusuario, idemocion_cat, fecha_registro) VALUES ( :idUsuario, :idEmocion, :fecha)";
    	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    	namedParameters.addValue("idEmocion", idEmocion);
    	namedParameters.addValue("idUsuario", idUsuario);
    	namedParameters.addValue("fecha", dtf.format(now));
    	jdbcTemplate.update(sql, namedParameters);
    	
    	 
	}

	/**
	 * Método simple
	 * 
	 */
	@Override
	public List<Emocion> getAllEmotion(String userName) {
		String sql = "select usremo.fecha_registro, emocat.color, emocat.emocion from contigo.usuario_emocion as usremo inner join contigo.emocion_cat as emocat "
				+ "inner join contigo.usuario as usr "
				+ "where usremo.idemocion_cat = emocat.idemocion_cat and usr.idusuario = usremo.idusuario "
				+ "and usr.nombreUsuario = :nombreUsuario ";
		 
		
		List<Emocion> emocionesLst = jdbcTemplate.query(sql,new MapSqlParameterSource("nombreUsuario", "BK"), (resultSet, i) -> {
            return toPerson(resultSet);
        });
		
		
		 
		 
		return emocionesLst;
	}
	
	@Override
	public Emocion getCurrentEmotion(String userName, String currentDate ) {
		String sql = "select usremo.fecha_registro, emocat.color, emocat.emocion from contigo.usuario_emocion as usremo inner join contigo.emocion_cat as emocat "
				+ "inner join contigo.usuario as usr "
				+ "where usremo.idemocion_cat = emocat.idemocion_cat and usr.idusuario = usremo.idusuario "
				+ "and usr.nombreUsuario = :nombreUsuario order by usremo.fecha_registro desc";
		 
		
		List<Emocion> emocionesLst = jdbcTemplate.query(sql,new MapSqlParameterSource("nombreUsuario", userName), (resultSet, i) -> {
            return toPerson(resultSet);
        });
		
		if(emocionesLst.isEmpty())
		{
			return new Emocion();
		}
		
		return emocionesLst.get(0);
		
		 
	}
	
	private Emocion toPerson(ResultSet resultSet) throws SQLException {
		Emocion emocion = new Emocion();
		emocion.setColorEmocion(resultSet.getString("color").toLowerCase());
		Date date = resultSet.getDate("fecha_registro");
		LocalDate localDate = date.toLocalDate();
	
		emocion.setDia(localDate.getDayOfMonth());
		emocion.setMes(localDate.getMonthValue());
		emocion.setAnio(localDate.getYear());
		
		emocion.setDescripcion(resultSet.getString("emocion").toLowerCase());
		
		emocion.setFechaRegistroEmocion(resultSet.getDate("fecha_registro"));
        return emocion;
    }

	 


}
