package br.com.srnimbus.amadorpro.exception;

public class AmadorProException extends Exception {
	private static final long serialVersionUID = 1L;

	public AmadorProException(String string) {
		super(string);
	}

	public AmadorProException(Exception expt) {
		super(expt);
	}

}
