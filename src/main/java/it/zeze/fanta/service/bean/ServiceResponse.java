package it.zeze.fanta.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceResponse implements Serializable {

	private static final long serialVersionUID = 4821184636379502435L;
	
	private List<MessageResponse> messageResponse = new ArrayList<MessageResponse>();
	private Object objectResponse;
	
	public void addMessage(MessageSeverity severity, String message){
		MessageResponse messageToAdd = new MessageResponse();
		messageToAdd.setSeverity(severity);
		messageToAdd.setMessage(message);
		messageResponse.add(messageToAdd);
	}
	
	public void addMessage(MessageResponse message){
		messageResponse.add(message);
	}
	
	public List<MessageResponse> getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(List<MessageResponse> messageResponse) {
		this.messageResponse = messageResponse;
	}
	public Object getObjectResponse() {
		return objectResponse;
	}
	public void setObjectResponse(Object objectResponse) {
		this.objectResponse = objectResponse;
	}

}
