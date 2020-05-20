package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOutgoingVoice;

public class OutgoingVoice extends AbstractNotification implements IOutgoingVoice {

	private static final long serialVersionUID = 6192727903980944149L;
	
	public OutgoingVoice() {
	}

	public OutgoingVoice(String domainKey, String notificationId) {
		super(domainKey, notificationId);
	}

}
