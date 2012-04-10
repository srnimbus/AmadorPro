package test.classes;

public class DataBaseException extends Exception {

	public DataBaseException(String msg) {
		super(msg);
	}

	public DataBaseException(String msg, int errorCode) {
		super(msg);
	}

}
