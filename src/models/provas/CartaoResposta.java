package models.provas;

public class CartaoResposta {
	private int id;
	private int idAluno;
	private int idProva;
	private int[] resposta;
	
	public CartaoResposta(int id, int[] resposta, int idAluno, int idProva) {
		this.id = id;
		this.resposta = resposta;
		this.idAluno = idAluno;
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
	
	public int getIdAluno() {
		return idAluno;
	}
	
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	
	public int getIdProva() {
		return idProva;
	}
	
	public void setIdProva(int idProva) {
		this.idProva = idProva;
	}
}
