package controllers;

import java.util.ArrayList;

import models.entities.Aluno;
import models.entities.Nota;

public class MediaAluno {
	private Aluno aluno;
	
	public MediaAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public double calcularMedia(CalculadorMedia calculador) {
		ArrayList<Double> notas = new ArrayList<Double>();
		for (Nota nota : aluno.getNotas()) {
			notas.add(nota.getNota());
		}
		
		return calculador.calcularMedia(notas); 
	}
}
