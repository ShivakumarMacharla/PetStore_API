package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	
	
	@BeforeClass
	public void setupData() {
	
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}

	@Test(priority = 1) 
	public void testPostUser() {
		
		Response response =  UserEndpoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority =2)
	public void testGetUserByName() {
		Response response = UserEndpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority = 3)
	public void testUpdateUserByName() {
		
		//update data using playload
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndpoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		
		//checking data after update
		Response responseAfterUpdate = UserEndpoints.readUser(this.userpayload.getUsername());
		responseAfterUpdate.then().log().all();
		
		}
	
	@Test(priority =4)
	public void testDeleteUserByName() {
		
		Response response = UserEndpoints.deleteUser(this.userpayload.getUsername());
		//response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
