package br.com.santander.msg.email.service;

import java.util.List;

import javax.mail.MessagingException;

import br.com.santander.msg.email.service.impl.ChaveValor;

public interface EmailService {

	void sendSimpleMessage(String to, String subject, String text, List<ChaveValor> params);

	void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment, List<ChaveValor> params) throws MessagingException;

	void sendMessageWithImage(String to, String subject, String text, String pathToAttachment, List<ChaveValor> params) throws MessagingException;

}
