package models.entities;

public enum SituacaoAluno {
	Aprovado("AP"),
	Reprovado("RM"),
	;
	
	private final String situacao;
	
	SituacaoAluno(String situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return situacao;
	}
}
