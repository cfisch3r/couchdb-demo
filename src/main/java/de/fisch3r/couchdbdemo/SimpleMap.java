package de.fisch3r.couchdbdemo;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SimpleMap {
	private Map<String,String> liste;

	public Map<String, String> getListe() {
		return liste;
	}

	public void setListe(Map<String, String> liste) {
		this.liste = liste;
	}

}
