package com.skynet.infrastructure;

public interface SMTPService {

	public void send(String to, String subject, String content);

}
