package com.generation.thunderdev.contigo.model;
// Generated 2 may. 2022 21:13:49 by Hibernate Tools 5.6.7.Final

/**
 * UsuarioEmocion generated by hbm2java
 */
public class UsuarioEmocion implements java.io.Serializable {

	private UsuarioEmocionId emocion;

	public UsuarioEmocion() {
	}

	public UsuarioEmocion(UsuarioEmocionId id) {
		this.emocion = id;
	}

	public UsuarioEmocionId getId() {
		return this.emocion;
	}

	public void setId(UsuarioEmocionId id) {
		this.emocion = id;
	}

}
