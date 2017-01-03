package com.ceriarte.central.web.controller;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedProperty;

import org.springframework.security.core.context.SecurityContextHolder;

import com.ceriarte.central.dominio.dto.UsuarioDTO;
import com.ceriarte.central.servicios.ServicioUsuarios;

public abstract class AbstractController {

	@ManagedProperty("#{msg}")
	protected ResourceBundle msg;
	
	@ManagedProperty(value ="#{servicioUsuarios}")
	protected ServicioUsuarios servicioUsuarios;

    private UsuarioDTO usuarioLogged;
    
    public UsuarioDTO getUsuarioLogged(){
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(usuarioLogged == null){
    		usuarioLogged = servicioUsuarios.doFindByLogin(username);
    	}
    	return usuarioLogged;
    }
    
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	public void setServicioUsuarios(ServicioUsuarios servicioUsuarios) {
		this.servicioUsuarios = servicioUsuarios;
	}
}
