package br.com.srnimbus.amadorpro.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOG_LOGIN")
@SequenceGenerator(name = "TB_LOG_LOGIN_ID_LOG_LOGIN_seq", sequenceName = "TB_LOG_LOGIN_ID_LOG_LOGIN_seq", allocationSize = 1)
public class LogLogin {

	// TB_LOG_LOGIN.ID_LOG_LOGIN
	// TB_LOG_LOGIN.ID_LOGIN
	// TB_LOG_LOGIN.DATA_HORA
	// TB_LOG_LOGIN.INFO

	private int id;
	private int idLogin;
	private Date dataHoraLogin;
	private String info;

	@Id
	@Column(name = "ID_LOG_LOGIN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_LOG_LOGIN_ID_LOG_LOGIN_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ID_LOGIN")
	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	@Column(name = "DATA_HORA")
	public Date getDataHoraLogin() {
		return dataHoraLogin;
	}

	public void setDataHoraLogin(Date dataHoraLogin) {
		this.dataHoraLogin = dataHoraLogin;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
