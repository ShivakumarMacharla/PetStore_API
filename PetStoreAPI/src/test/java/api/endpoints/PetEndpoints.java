package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//PetEndPoints.java
//Create for Create,read,update,delete request the Pet API.
public class PetEndpoints {
	
	public static Response CreatePet(Pet payload){
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
			.post(Routes.postpet_url);
		return response;
	}
	public static Response readPet(int petId) {
		Response response = given()
			.pathParam("id", petId)
		.when()
			.get(Routes.getpet_url);
		return response;
	}
	public static Response UpdatePet(int petId,Pet payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .pathParam("id", petId)
		        .body(payload)
		.when()
			.put(Routes.putpet_url);
		return response;	
	}
	public static Response delete(int petId) {
		Response response = given()
			.pathParam("id", petId)
		.when()
			.delete(Routes.deletepet_url);
		return response;
			
	}

}