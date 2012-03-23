package br.com.srnimbus.amadorpro.exception;

public class AmadorProBusinessException extends AmadorProException {
	private static final long serialVersionUID = 1L;

	public AmadorProBusinessException(String string) {
		super(string);
	}

	public AmadorProBusinessException(Exception expt) {
		super(expt);
	}

}
