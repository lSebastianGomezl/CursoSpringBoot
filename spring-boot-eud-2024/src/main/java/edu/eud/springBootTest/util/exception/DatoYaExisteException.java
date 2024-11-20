package edu.eud.springBootTest.util.exception;

public class DatoYaExisteException extends RuntimeException{

	private static final long serialVersionUID = 418894760012470218L;

	public DatoYaExisteException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatoYaExisteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DatoYaExisteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DatoYaExisteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
