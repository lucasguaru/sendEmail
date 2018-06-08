package br.com.santander.msg.email.service.impl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import br.com.santander.msg.email.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	public TemplateUtils templateUtils;
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text, List<ChaveValor> params) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("lucasguaru@yahoo.com.br");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment, List<ChaveValor> params) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("lucasguaru@yahoo.com.br");
		helper.setTo(to);
		helper.setSubject(subject);
		
		//True para indicar que o texto é html
		helper.setText(templateUtils.generateTemplate("TMPMSG001", params), true);

		File f1 = new File(pathToAttachment);
		FileSystemResource file = new FileSystemResource(f1);
		helper.addAttachment(f1.getName(), file);

		emailSender.send(message);
	}

	public void sendMessageWithImage(String to, String subject, String text, String pathToAttachment, List<ChaveValor> params) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("lucasguaru@yahoo.com.br");
		helper.setTo(to);
		helper.setSubject(subject);
		
		//True para indicar que o texto é html
		helper.setText(templateUtils.generateTemplate("TMPMSG001", params), true);

		File f1 = new File(pathToAttachment);
		FileSystemResource file = new FileSystemResource(f1);
		helper.addAttachment(f1.getName(), file);

		// let's include the infamous windows Sample file (this time copied to c:/)
		FileSystemResource res = new FileSystemResource(new File("C:\\Users\\lcruzfab\\Downloads\\email\\Email\\img1.jpg"));
		helper.addInline("header1", res);

		emailSender.send(message);
	}

}