package br.com.srnimbus.amadorpro.exception;

public class AmadorProDAOException extends AmadorProException {
	private static final long serialVersionUID = 1L;

	public AmadorProDAOException(String string) {
		super(string);
	}

	public AmadorProDAOException(Exception expt) {
		super(expt);
	}

}
