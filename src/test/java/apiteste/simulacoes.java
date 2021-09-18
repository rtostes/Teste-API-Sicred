package apiteste;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class simulacoes {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8080";
	}
	
	
	
	@Test
	public void consultaSimulacoes() {
		RestAssured.given()
			.log().all()
		.when()
			.get("/api/v1/simulacoes")
		.then()
		.statusCode(200)
			.log().all()
		;
		
	}
		@Test
		public void inserirSimulacao() {
			RestAssured.given()
				.body("{\r\n"
						+ "  \"nome\": \"RodrigoTeste\",\r\n"
						+ "  \"cpf\": 98785445646,\r\n"
						+ "  \"email\": \"rodrigo@teste.com\",\r\n"
						+ "  \"valor\": 1500,\r\n"
						+ "  \"parcelas\": 3,\r\n"
						+ "  \"seguro\": true\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
				.post("/api/v1/simulacoes")
			.then()
			.statusCode(201)
				.log().all()
			;
	}
		
		@Test
		public void inserirSimulacaoComSeguroInvalido() {
			RestAssured.given()
				.body("{\r\n"
						+ "  \"nome\": \"RodrigoTeste\",\r\n"
						+ "  \"cpf\": 98785445646,\r\n"
						+ "  \"email\": \"rodrigo@teste.com\",\r\n"
						+ "  \"valor\": 1500,\r\n"
						+ "  \"parcelas\": 3,\r\n"
						+ "  \"seguro\": invalido\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
				.post("/api/v1/simulacoes")
			.then()
			.statusCode(400)
				.log().all()
			;
			
		}
		
		@Test
		public void deletarSimulacao() {
			RestAssured.given()
			.when()
				.delete("/api/v1/simulacoes/13")
			.then()
			.statusCode(200)
				.log().all()
			;
			
		}
		
		@Test
		public void alterarSimulacao() {
			RestAssured.given()
				.body("{\r\n"
						+ "        \"id\": 11,\r\n"
						+ "        \"nome\": \"Fulano\",\r\n"
						+ "        \"cpf\": \"66414919004\",\r\n"
						+ "        \"email\": \"fulano_tostes@gmail.com\",\r\n"
						+ "        \"valor\": 15000.00,\r\n"
						+ "        \"parcelas\": 6,\r\n"
						+ "        \"seguro\": false\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
				.put("/api/v1/simulacoes/66414919004")
			.then()
			.statusCode(200)
				.log().all()
			;
	}
		
		@Test
		public void consultaSimulacaoComFiltro() {
			RestAssured.given()
				.log().all()
			.when()
				.get("/api/v1/simulacoes/66414919004")
			.then()
			.statusCode(200)
				.log().all()
			;
			
		}
		
		@Test
		public void consultaSimulacoesCPFInexistente() {
			RestAssured.given()
				.log().all()
			.when()
				.get("/api/v1/simulacoes/99887733322")
			.then()
			.statusCode(404)
				.log().all()
			;
			
		}
		
}
