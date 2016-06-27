package it.zeze.fanta.service.bean;

import java.io.Serializable;

public class MessageResponse implements Serializable {

	private static final long serialVersionUID = 7715796763765945420L;
	
	private MessageSeverity severity;
	private String message;
	
	public MessageSeverity getSeverity() {
		return severity;
	}
	public void setSeverity(MessageSeverity severity) {
		this.severity = severity;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}