package request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/*
 * O objetivo deste código é enviar uma requisicao com dados de usuarios para a API: 
 * UserID, MovieID e Rating (Respectivamente, codigo de usuario, codigo de filme no imdb, nota entre 1 a 10 do filme)
 * e receber a resposta do recomendador que retornara o codigo do usuario junto com mais 5 recomendacoes e a previsao
 * de nota do usuario
 */


public class API {
	public static void main (String[] args) throws IOException, InterruptedException {
		//Corpo da requisicao (String em formato JSON com 5 objetos)
		String body = "{"+
	            "\"Inputs\": {"+
	        "\"input1\": ["+
	          "{"+
	            "\"UserId\": 1,"+
	            "\"MovieId\": 68667,"+
	            "\"Rating\": 10,"+
	            "\"Timestamp\": 1381620027"+
	          "},"+
	          "{"+
	            "\"UserId\": 1,"+
	            "\"MovieId\": 113277,"+
	            "\"Rating\": 10,"+
	            "\"Timestamp\": 1379466669"+
	          "},"+
	          "{"+
	            "\"UserId\": 2,"+
	            "\"MovieId\": 454876,"+
	            "\"Rating\": 8,"+
	            "\"Timestamp\": 1394818630"+
	          "},"+
	          "{"+
	            "\"UserId\": 2,"+
	            "\"MovieId\": 790636,"+
	            "\"Rating\": 7,"+
	            "\"Timestamp\": 1389963947"+
	          "},"+
	          "{"+
	            "\"UserId\": 2,"+
	            "\"MovieId\": 816711,"+
	            "\"Rating\": 8,"+
	            "\"Timestamp\": 1379963769"+
	          "}"+
	        "]"+
	      "},"+
	      "\"GlobalParameters\": {}"+
	    "}";
		   //Chave da API	
		   String API_KEY = "MzIjP77dI4YfaazzwL5n508MHp9voIR1";
		   HttpRequest request = HttpRequest.newBuilder()
		         .uri(URI.create("http://7f0c6a8d-e91d-4b66-91dc-15afa3fd1084.eastus.azurecontainer.io/score"))
		         .headers("Content-Type", "application/json", "Authorization", "Bearer " + API_KEY)
		         .POST(BodyPublishers.ofString(body))
		         .build();
		   HttpClient client = HttpClient.newBuilder()
				   .build();
		   HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	       System.out.println(response.body());
	       System.out.println(response.statusCode());
	       System.out.println(response.headers());
	       System.out.println(response.version());
	}
}
