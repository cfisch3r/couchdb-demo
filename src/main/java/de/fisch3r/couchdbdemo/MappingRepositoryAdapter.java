package de.fisch3r.couchdbdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MappingRepositoryAdapter {
	private String documentUrl = "";
	
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public Map<String, String> fetchMap() {
		RestTemplate template = createRestTemplateWithJSONMapper();
		
		SimpleMap mapDocument = template.getForObject(documentUrl, SimpleMap.class);
		return mapDocument.getListe();
	}

	private RestTemplate createRestTemplateWithJSONMapper() {
		RestTemplate template = new RestTemplate();
		
		MappingJacksonHttpMessageConverter mapper = new MappingJacksonHttpMessageConverter();
		List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
		list.add(mapper);
		template.setMessageConverters(list);
		return template;
	}
}
