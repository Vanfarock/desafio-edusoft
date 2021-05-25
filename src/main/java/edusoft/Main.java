package edusoft;

import java.util.ArrayList;

import controllers.*;
import models.entities.Aluno;
import models.services.alunos.AlunosService;
import models.services.alunos.EnviarResultadoRequest;
import models.services.exceptions.RequestException;

public class Main {

	public static void main(String[] args) throws RequestException {
		AlunosService alunosService = new AlunosService();
		
		ArrayList<EnviarResultadoRequest> resultados = new ArrayList<EnviarResultadoRequest>();
		ArrayList<Aluno> alunos = alunosService.getAlunos(); 
		for (Aluno aluno : alunos) {
			MediaAluno mediaAluno = new MediaAluno(aluno);
			double media = mediaAluno.calcularMedia(new CalculadorMediaAritmetica());
			
			FrequenciaAluno frequenciaAluno = new FrequenciaAluno(aluno);
			double frequencia = frequenciaAluno.calcularFrequencia();
			
			aluno.setMedia(media);
			aluno.setFrequencia(frequencia);
			
			resultados.add(new EnviarResultadoRequest(aluno.getMedia(), aluno.getSituacao(), aluno.getCodigo()));
		}
		GeradorRelatorioAluno gerador = new GeradorRelatorioAluno();
		gerador.gerarRelatorio(alunos, "./relatorio.txt");
		
		alunosService.enviarResultado(resultados);
	}
}
