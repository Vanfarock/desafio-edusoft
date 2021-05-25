package models.services.alunos;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import models.entities.Aluno;

public class GetAlunosResponse {
	@JsonProperty("resultado")
	private String resultado;
	@JsonProperty("alunos")
	private ArrayList<Aluno> alunos;

	@JsonCreator
	public GetAlunosResponse(@JsonProperty("resultado") String resultado, 
						  @JsonProperty("alunos") ArrayList<Aluno> alunos) {
		setResultado(resultado);
		setAlunos(alunos);
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

}
