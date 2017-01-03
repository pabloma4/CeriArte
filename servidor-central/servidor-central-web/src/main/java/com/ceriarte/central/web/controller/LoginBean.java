package com.ceriarte.central.web.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {  

	private static final long serialVersionUID = 4251897157025542728L;
	private final Logger logger = LoggerFactory.getLogger(LoginBean.class);

	private String username = null; 
    private String password = null;

    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    public String login() {
        FacesMessage msg = null;
        String result;
      
        try {
        	logger.debug("Iniciando la autenticación para {} ...", this.getUsername());
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUsername(), password);
            Authentication auth = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(auth);
            logger.debug("Autenticación exitosa");
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Autenticación exitosa", this.getUsername());
            result = "success";
        } catch (AuthenticationException e) {
            logger.warn("No se pudo autenticar al usuario", e);
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Autenticación fallida", e.getMessage());
            result = "failure";
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);  
        return result;
    }

    public String cancel() {
        return null;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}  
 
