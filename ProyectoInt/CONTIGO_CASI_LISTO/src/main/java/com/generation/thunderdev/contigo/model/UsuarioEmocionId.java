package com.generation.thunderdev.contigo.model;
// Generated 2 may. 2022 21:13:49 by Hibernate Tools 5.6.7.Final

import java.util.Date;

/**
 * UsuarioEmocionId generated by hbm2java
 */
public class UsuarioEmocionId implements java.io.Serializable {

	private int idusuario;
	private int idemocionCat;
	private Date fechaRegistro;

	public UsuarioEmocionId() {
	}

	public UsuarioEmocionId(int idusuario, int idemocionCat, Date fechaRegistro) {
		this.idusuario = idusuario;
		this.idemocionCat = idemocionCat;
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdemocionCat() {
		return this.idemocionCat;
	}

	public void setIdemocionCat(int idemocionCat) {
		this.idemocionCat = idemocionCat;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsuarioEmocionId))
			return false;
		UsuarioEmocionId castOther = (UsuarioEmocionId) other;

		return (this.getIdusuario() == castOther.getIdusuario())
				&& (this.getIdemocionCat() == castOther.getIdemocionCat())
				&& ((this.getFechaRegistro() == castOther.getFechaRegistro())
						|| (this.getFechaRegistro() != null && castOther.getFechaRegistro() != null
								&& this.getFechaRegistro().equals(castOther.getFechaRegistro())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdusuario();
		result = 37 * result + this.getIdemocionCat();
		result = 37 * result + (getFechaRegistro() == null ? 0 : this.getFechaRegistro().hashCode());
		return result;
	}

}