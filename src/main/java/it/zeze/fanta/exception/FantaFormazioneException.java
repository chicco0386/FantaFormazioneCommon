package it.zeze.fanta.exception;

public class FantaFormazioneException extends Exception {

	private static final long serialVersionUID = 4867597672783161470L;

	public FantaFormazioneException() {
		super();
	}
	
	public FantaFormazioneException(Exception e) {
		super(e);
	}
	
	public FantaFormazioneException(String message) {
		super(message);
	}
	
	public FantaFormazioneException(String message, Exception e) {
		super(message, e);
	}

}
