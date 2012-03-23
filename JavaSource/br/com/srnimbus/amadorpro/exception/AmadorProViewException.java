package br.com.srnimbus.amadorpro.exception;

public class AmadorProViewException extends AmadorProException {
	private static final long serialVersionUID = 1L;

	public AmadorProViewException(String string) {
		super(string);
	}

	public AmadorProViewException(Exception expt) {
		super(expt);
	}

}
