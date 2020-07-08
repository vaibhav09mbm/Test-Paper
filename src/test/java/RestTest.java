import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTest {

	@Test
	public void validate_response_code_test() {
		RestAssured.baseURI = "https://reqres.in/api";
		// Create new JSON Object
		given()
		.header("Content-Type","application/json" )
		 .header("Accept","application/json" )
		 .when().post("/users?page=2").then().statusCode(201);
	}

}
