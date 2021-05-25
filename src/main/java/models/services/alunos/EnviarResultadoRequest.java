package models.services.alunos;

import com.fasterxml.jackson.annotation.JsonProperty;

import models.entities.SituacaoAluno;

public class EnviarResultadoRequest {
	@JsonProperty("MEDIA")
	private double media;
	@JsonProperty("RESULTADO")
	private SituacaoAluno resultado;
	@JsonProperty("COD_ALUNO")
	private String codigoAluno;
	@JsonProperty("SEU_NOME")
	private final String meuNome = "Vinícius Manuel Martins";

	public EnviarResultadoRequest(double media, SituacaoAluno resultado, String codigo) {
		setMedia(media);
		setResultado(resultado);
		setCodigoAluno(codigo);
	}
	
	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public SituacaoAluno getResultado() {
		return resultado;
	}

	public void setResultado(SituacaoAluno resultado) {
		this.resultado = resultado;
	}

	public String getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(String codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public String getMeuNome() {
		return meuNome;
	}

}
