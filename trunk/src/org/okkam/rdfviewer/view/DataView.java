package org.okkam.rdfviewer.view;

public class DataView {
	private String haCodiceFiscale;
	private String haNome;
	private String haCognome;
	private String haComuneNascita;
	private String haDataNascita;
	private String haLuogoResidenza;	
	
	private String subject;
	private String object;
	private String property;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	public String getHaCodiceFiscale() {
		return haCodiceFiscale;
	}
	public void setHaCodiceFiscale(String haCodiceFiscale) {
		this.haCodiceFiscale = haCodiceFiscale;
	}
	public String getHaNome() {
		return haNome;
	}
	public void setHaNome(String haNome) {
		this.haNome = haNome;
	}
	public String getHaCognome() {
		return haCognome;
	}
	public void setHaCognome(String haCognome) {
		this.haCognome = haCognome;
	}
	public String getHaComuneNascita() {
		return haComuneNascita;
	}
	public void setHaComuneNascita(String haComuneNascita) {
		this.haComuneNascita = haComuneNascita;
	}
	public String getHaDataNascita() {
		return haDataNascita;
	}
	public void setHaDataNascita(String haDataNascita) {
		this.haDataNascita = haDataNascita;
	}
	public String getHaLuogoResidenza() {
		return haLuogoResidenza;
	}
	public void setHaLuogoResidenza(String haLuogoResidenza) {
		this.haLuogoResidenza = haLuogoResidenza;
	}
	
}
