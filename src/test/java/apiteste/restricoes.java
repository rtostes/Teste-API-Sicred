package apiteste;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class restricoes {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8080";
	}
	
	
	
	@Test
	public void consultaRestricoesCPF19626829001() {
		RestAssured.given()
			.log().all()
		.when()
			.get("/api/v1/restricoes/19626829001")
		.then()
		.statusCode(200)
			.log().all()
		;
		
	}
	
	@Test
	public void consultaRestricoesCPF60094146012() {
		RestAssured.given()
			.log().all()
		.when()
			.get("/api/v1/restricoes/60094146012")
		.then()
		.statusCode(200)
			.log().all()
		;
		
	}
	
	@Test
	public void consultaRestricoesCPF84809766080() {
		RestAssured.given()
			.log().all()
		.when()
			.get("/api/v1/restricoes/84809766080")
		.then()
		.statusCode(200)
			.log().all()
		;
		
	}
}
