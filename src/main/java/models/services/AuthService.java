package models.services;

import java.io.IOException;

import models.services.exceptions.RequestException;
import okhttp3.*;

public class AuthService {
	private final String URL_BASE = "http://desenvolvimento.edusoft.com.br/desenvolvimentoMentorWebG5/rest/servicoexterno/token";
	private final String USUARIO = "mentor";
	private final String SENHA = "123456";
	
	public String getToken(String service) throws RequestException {
		OkHttpClient client = new OkHttpClient();
		 
       Request request = new Request.Builder()
         .url(URL_BASE + service)
         .get()
         .addHeader("usuario", USUARIO)
         .addHeader("senha", SENHA)
         .build();

       String token = "";
       try {
			Response response = client.newCall(request)
									  .execute();
			token = response.body().string();
		} catch (IOException e) {
			throw new RequestException("Erro ao buscar o token do serviço '" + service + "'. Erro: " + e.getMessage());
		}
		
		return token;
	}
}
