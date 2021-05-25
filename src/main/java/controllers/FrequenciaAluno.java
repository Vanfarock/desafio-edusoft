package controllers;

import models.entities.Aluno;

public class FrequenciaAluno {
	private Aluno aluno;

	public FrequenciaAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public double calcularFrequencia() {
		double totalAulas = aluno.getTotalAulas();
		if (totalAulas > 0) {
			return 100 - ((100 * aluno.getTotalFaltas()) / totalAulas);			
		}
		return 0;
	}
}
