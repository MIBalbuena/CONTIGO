package com.generation.thunderdev.contigo.model;

import java.io.Serializable;
import java.sql.Date;

public class Emocion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fechaRegistroEmocion;
	private String colorEmocion;
	
	private int mes;
	private int dia;
	private int anio;
	
	private String descripcion;
	
	public Date getFechaRegistroEmocion() {
		return fechaRegistroEmocion;
	}
	public void setFechaRegistroEmocion(Date fechaRegistroEmocion) {
		this.fechaRegistroEmocion = fechaRegistroEmocion;
	}
	public String getColorEmocion() {
		return colorEmocion;
	}
	public void setColorEmocion(String colorEmocion) {
		this.colorEmocion = colorEmocion;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
