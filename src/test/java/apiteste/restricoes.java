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
	public void consultaRestricoes() {
		RestAssured.given()
			.log().all()
		.when()
			.get("/api/v1/restricoes/19626829001")
		.then()
		.statusCode(200)
			.log().all()
		;
		
	}
}
