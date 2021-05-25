package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.entities.Aluno;

public class GeradorRelatorioAluno implements GeradorRelatorio<Aluno> {
	public void gerarRelatorio(ArrayList<Aluno> dados, String filePath) {
		StringBuilder stringBuilder = new StringBuilder("Alunos\r\n");
		for (Aluno aluno : dados) {
			stringBuilder.append("\r\nNome: " + aluno.getNome());
			stringBuilder.append("\r\nNotas: " + aluno.mostrarNotas());
			stringBuilder.append("\r\nTotal de faltas: " + aluno.getTotalFaltas());
			stringBuilder.append("\r\nMédia: " + aluno.getMedia());
			stringBuilder.append("\r\nResultado: " + aluno.getSituacao());
			stringBuilder.append("\r\n");
		}
		
		FileWriter writer;
		try {
			writer = new FileWriter(filePath);
			writer.write(stringBuilder.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
