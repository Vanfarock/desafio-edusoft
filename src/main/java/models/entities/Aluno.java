package models.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Aluno {
	@JsonProperty("COD")
	private String codigo;
	@JsonProperty("NOME")
	private String nome;
	@JsonProperty("TOAL_AULAS")
	private int totalAulas;
	@JsonProperty("nota")
	private ArrayList<Nota> notas;

	@JsonIgnore
	private double media;
	@JsonIgnore
	private double frequencia;

	public Aluno() {
		notas = new ArrayList<Nota>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalAulas() {
		return totalAulas;
	}

	public void setTotalAulas(int totalAulas) {
		this.totalAulas = totalAulas;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(double frequencia) {
		this.frequencia = frequencia;
	}
	
	public int getTotalFaltas() {
		int totalFaltas = 0;
		
		for (Nota nota : getNotas()) {
			totalFaltas += nota.getFaltas();
		}
		return totalFaltas;
	}
	
	public String mostrarNotas() {
		StringBuilder notasString = new StringBuilder();
		
		ArrayList<Nota> notas = getNotas();
		for (int i = 0; i < notas.size(); i++) {
			notasString.append(notas.get(i).getNota());				
			if (i != notas.size() - 1) {
				notasString.append(", ");
			}
		}
		return notasString.toString();
	}

	public SituacaoAluno getSituacao() {
		if (frequencia < 70 || media < 7)  {
			return SituacaoAluno.Reprovado;			
		}
		return SituacaoAluno.Aprovado;
	}
}
