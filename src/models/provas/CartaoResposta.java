package models.provas;

public class CartaoResposta {
	private int id;
	private int idALuno;
	private int idProva;
	private int[] resposta;
	
	public CartaoResposta(int id, int[] resposta,int idALuno, int idProva) {
		this.id = id;
		this.resposta = resposta;
		this.idALuno = idALuno;
		this.idProva = idProva;
	}
	
	public CartaoResposta() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getResposta() {
		return resposta;
	}

	public void setResposta(int[] resposta) {
		this.resposta = resposta;
	}
}
