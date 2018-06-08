package br.com.santander.msg.email.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TemplateUtils {

	private Map<String, String> templates = new HashMap<>();

	public TemplateUtils() throws IOException {
		templates.put("TMPMSG001", readTemplateFile("C:\\Users\\lcruzfab\\Downloads\\email\\NOTA_PRAZO.html"));
	}

	private String readTemplateFile(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public String generateTemplate(String cdTemplate, List<ChaveValor> params) {
		String out = templates.get(cdTemplate);
		for (ChaveValor chaveValor : params) {
			out = out.replaceAll("\\[" + chaveValor.getKey() + "\\]", chaveValor.getValue());
		}
		return out;
	}

}
