package br.com.srnimbus.amadorpro.to;


public class TelefoneTO extends AbstractTO{

	private boolean principal;
	private String telefone;

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
