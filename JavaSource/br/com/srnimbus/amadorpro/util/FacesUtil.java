/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.srnimbus.amadorpro.util;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FacesUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	public static String getParam(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}

	public static Map<String, String> getAllParams() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	}

	public static Flash getFlash() {
		return FacesContext.getCurrentInstance().getExternalContext().getFlash();
	}

	public static HttpSession getSession(boolean create) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(create);
		return session;
	}

	public static void setSessionAttribute(String name, Object attribute) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute(name,attribute);		
	}
	
	public static Object getSessionAttribute(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		return session.getAttribute(name);		
	}
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	public static String getResource(String key, String lang) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ResourceBundle bundle = ctx.getApplication().getResourceBundle(ctx, "i18n");
		return bundle.getString(key);
	}
	
}
