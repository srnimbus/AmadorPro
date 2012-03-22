package br.com.srnimbus.amadorpro.dominio;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PELADA")
@SequenceGenerator(name = "TB_PELADA_ID_PELADA_seq", sequenceName = "TB_PELADA_ID_PELADA_seq", allocationSize = 1)
public class Pelada {

	// "TB_PELADA","ID_PELADA"
	// "TB_PELADA","ID_LOCAL_PELADA"
	// "TB_PELADA","DESC_PELADA"
	// "TB_PELADA","DATA"
	// "TB_PELADA","VALOR"
	// "TB_PELADA","HORA_FINAL"
	// "TB_PELADA","HORA_INICIAL"

	private int id;
	private LocalPelada local;
	private String descricao;
	private Date data;
	private double valor;
	private String horaInicial;
	private String horaFinal;

	@Id
	@Column(name = "ID_PELADA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_PELADA_ID_PELADA_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// @Column(name = "ID_LOCAL_PELADA")
	@JoinColumn(name = "ID_LOCAL_PELADA", referencedColumnName = "ID_LOCAL_PELADA", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	public LocalPelada getLocal() {
		return local;
	}

	public void setLocal(LocalPelada local) {
		this.local = local;
	}

	@Column(name = "DESC_PELADA")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "DATA")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "VALOR")
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Column(name = "HORA_INICIAL")
	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	@Column(name = "HORA_FINAL")
	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

}
