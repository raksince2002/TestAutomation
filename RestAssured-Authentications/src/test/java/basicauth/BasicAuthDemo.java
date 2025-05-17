package basicauth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuthDemo {
	
	public void code_200_OK_Get() {
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").get("https://reqres.in/api/users/2");
		
		System.out.println(res.then().assertThat().statusCode(200));
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
			
	}
	
	public void code_201_created() {
		
		String requestbody = "{\"name\":\"morphesus1\",\"job\":\"leader56\"}";
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").body(requestbody).post("https://reqres.in/api/users");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_400_badRequest() {
		
		String requestbody = "{\"name\":\"morphesus1\",\"job\":\"leader56\"";
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").body(requestbody).post("https://reqres.in/api/users");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_404_NotFound() {

		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").get("https://reqres.in/api/users/23");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_200_OK_Put() {
		
		String requestbody = "{\"name\":\"morphesus2\",\"job\":\"leader55\"}";
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").body(requestbody).put("https://reqres.in/api/users/2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	
	}
	
	public void code_200_OK_Patch() {
		
		String requestbody = "{\"name\":\"morphesus2\",\"job\":\"leader56\"}";
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").body(requestbody).patch("https://reqres.in/api/users/2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_204_delete() {
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-key","reqres-free-v1").delete("https://reqres.in/api/users/2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_401_unauthorized() {
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).header("x-api-ke","reqres-free-v1").delete("https://reqres.in/api/users/2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_200_OK() {
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).get("https://automationexercise.com/api/productsList");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}
	
	public void code_405_requestNotSupported() {
		
		String requestbody = "{\"email\":\"morphesus1@gmail.com\",\"password\":\"leader56\"}";
		
		Response res = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(requestbody).post("https://automationexercise.com/api/productsList");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		System.out.println(res.getSessionId());
		
	}

}
