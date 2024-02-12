package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndpoints;

import api.payload.Pet;

import io.restassured.response.Response;

public class PetTest {

	Faker faker;
	Pet petpayload;
	

	
	@BeforeClass
	public void setupPetData() {
		faker = new Faker();
		petpayload = new Pet();
		petpayload.setId(faker.idNumber().hashCode());
		petpayload.setName(faker.name().fullName());
		
	}
	
	@Test(priority =1)
	public void testPostPet() {
		
		Response response = PetEndpoints.CreatePet(petpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("test post method");
	}
	@Test(priority =2)
	public void testGetPet() {
		Response response = PetEndpoints.readPet(this.petpayload.getId());
		response.then().log().all();
		System.out.println("test get method");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority =3)
	public void testputPet() {
		petpayload.setId(faker.idNumber().hashCode());
		petpayload.setName(faker.name().fullName());
		Response response  = PetEndpoints.UpdatePet(this.petpayload.getId(),petpayload);
		response.then().log().all();
		System.out.println("test put method");
		
	//	Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	@Test(priority =3)
	public void testdelete() {
		Response response = PetEndpoints.delete(this.petpayload.getId());
		response.then().log().all();
		System.out.println("testdelete Method");
//		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
}
