package br.com.srnimbus.amadorpro.to;

import java.util.Date;

public class LogLoginTO extends AbstractTO {

	private int idLogin;
	private Date dataHoraLogin;
	private String info;
	boolean autenticado;

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public Date getDataHoraLogin() {
		return dataHoraLogin;
	}

	public void setDataHoraLogin(Date dataHoraLogin) {
		this.dataHoraLogin = dataHoraLogin;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
