package models.services.alunos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.entities.Aluno;
import models.services.AuthService;
import models.services.enums.Resultado;
import models.services.exceptions.RequestException;
import okhttp3.*;

public class AlunosService {
	private final String URL_BASE = "http://desenvolvimento.edusoft.com.br/desenvolvimentoMentorWebG5/rest/servicoexterno/execute";  
	
	public ArrayList<Aluno> getAlunos() throws RequestException {
		final String endpoint = "/recuperaAlunos";
		
		try {
			String token = new AuthService().getToken(endpoint);
			
			OkHttpClient client = new OkHttpClient();
	  
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create("", mediaType);
			Request requestAlunos = new Request.Builder()
				.url(URL_BASE + endpoint)
				.post(body)
				.addHeader("content-type", "application/json")
				.addHeader("token", token)
				.build();
  
			Response response = client.newCall(requestAlunos).execute();
			
			ObjectMapper mapper = new ObjectMapper();
			GetAlunosResponse[] alunosResponse = mapper.readValue(response.body().string(), GetAlunosResponse[].class);
			if (alunosResponse.length > 0) {
				if (alunosResponse[0].getResultado().equals(Resultado.Sucesso.toString())) {
					return alunosResponse[0].getAlunos();					
				}
			}
		} catch (Exception e) {
			throw new RequestException("Ocorreu algum erro ao buscar os alunos. Erro: " + e.getMessage());
		}
		return new ArrayList<Aluno>();
	}

	public String enviarResultado(ArrayList<EnviarResultadoRequest> resultados) throws RequestException {
		final String endpoint = "/gravaResultado";
		
		try {
			String token = new AuthService().getToken(endpoint);
			
			OkHttpClient client = new OkHttpClient();
	  
			MediaType mediaType = MediaType.parse("application/json");
			
			String bodyString = montarBodyEnviarResultado(resultados);
	
			RequestBody body = RequestBody.create(bodyString, mediaType);
			Request requestAlunos = new Request.Builder()
				.url(URL_BASE + endpoint)
				.post(body)
				.addHeader("content-type", "application/json")
				.addHeader("token", token)
				.build();
  
			Response response = client.newCall(requestAlunos).execute();
			ObjectMapper mapper = new ObjectMapper();
			EnviarResultadoResponse envioResponse = mapper.readValue(response.body().string(), EnviarResultadoResponse.class);

			return envioResponse.getResultado();

		} catch (Exception e) {
			throw new RequestException("Ocorreu algum erro ao buscar os alunos. Erro: " + e.getMessage());
		}
	}
	
	private String montarBodyEnviarResultado(ArrayList<EnviarResultadoRequest> resultados) {
		String bodyString = "[";
		for (EnviarResultadoRequest resultado : resultados) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("MEDIA", String.valueOf(resultado.getMedia()));
			map.put("RESULTADO", resultado.getResultado().toString());
			map.put("COD_ALUNO", resultado.getCodigoAluno());
			map.put("SEU_NOME", resultado.getMeuNome());
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult;
			try {
				jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
				bodyString += jsonResult + ",";
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		bodyString += "]";
		
		return bodyString;
	}
}
