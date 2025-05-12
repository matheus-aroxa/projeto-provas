package models;

public class Alternativa {
	private int id;
	private String texto;
	
	public Alternativa(int id, String texto) {
		this.id = id;
		this.texto = texto;
	}
	
	public Alternativa() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
