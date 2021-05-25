package models.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Nota {
	@JsonProperty("NOTA")
	private double nota;
	@JsonProperty("FALTAS")
	private int faltas;

	@JsonCreator
	public Nota(@JsonProperty("NOTA") double nota, 
				@JsonProperty("FALTAS") int faltas) {
		setNota(nota);
		setFaltas(faltas);
	}
	
	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
}
