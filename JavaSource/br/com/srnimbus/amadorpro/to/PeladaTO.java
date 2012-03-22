package br.com.srnimbus.amadorpro.to;

import java.sql.Date;

public class PeladaTO {

	private int id;
	private LocalPeladaTO local; // MUDAR PARA O TO
	private String descricao;
	private Date data;
	private double valor;
	private String horaInicial;
	private String horaFinal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalPeladaTO getLocal() {
		return local;
	}

	public void setLocal(LocalPeladaTO local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

}
