package br.com.santander.msg.email.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.msg.email.service.EmailService;
import br.com.santander.msg.email.service.impl.ChaveValor;

@RestController
public class EmailEndpoint {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send")
	public void sendEmail() throws MessagingException {
		

		List<ChaveValor> params = new ArrayList<>();
		params.add(new ChaveValor("titulo documento", "Nota de LIQUIDACAO ANTECIPADA"));
		params.add(new ChaveValor("cliente", "HPB MONTAGENS LTDA"));
		
//		emailService.sendSimpleMessage("lucasguaruja@gmail.com", "teste smtp", "ola Lucas", params);
//		emailService.sendMessageWithAttachment("lucasguaruja@gmail.com", "teste smtp anexo", "ola Lucas", "C:\\Users\\lcruzfab\\Pictures\\remedy grupo msg.png", params);
		emailService.sendMessageWithImage("lucasguaru@yahoo.com.br", "teste smtp anexo", "ola Lucas", "C:\\Users\\lcruzfab\\Pictures\\remedy grupo msg.png", params);
		
	}

}
