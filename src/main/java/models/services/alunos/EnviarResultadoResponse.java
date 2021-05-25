package models.services.alunos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnviarResultadoResponse {
	@JsonProperty("resultado")
	private String resultado;
	@JsonProperty("linhasAfetadas")
	private int linhasAfetadas;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getLinhasAfetadas() {
		return linhasAfetadas;
	}

	public void setLinhasAfetadas(int linhasAfetadas) {
		this.linhasAfetadas = linhasAfetadas;
	}

}
