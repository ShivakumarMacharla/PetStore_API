package api.endpoints;

/*
 * Swager URL : ---> "https://petstore.swagger.io"
 * 
 * USER MODULE:----
 * Create user(post) URL :--->"https://petstore.swagger.io/v2/user"
 * Get user(Get) URL :------> "https://petstore.swagger.io/v2/user/{username}"
 * update user (put) URL :---->"https://petstore.swagger.io/v2/user/{username}"
 * delete user (delete) URL :---->"https://petstore.swagger.io/v2/user/{username}"
 * 
 * PET MODULE:----
 * Create per(post) URL:-->"https://petstore.swagger.io/v2/pet"
 * Get pet(Get)URL:--> "https://petstore.swagger.io/v2/pet/{petId}"
 * update pet(put) URL:--->"https://petstore.swagger.io/v2/pet/{petId}"
 * delete pet(delete) URL:--->"https://petstore.swagger.io/v2/pet/{petId}"
 * 
 */

public class Routes {
	//User Module 
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
    public static String delete_url = base_url+"/user/{username}";

    //Pet Module
    public static String postpet_url = base_url+"/pet";
    public static String getpet_url = base_url+"/pet/{petId}";
    public static String putpet_url = base_url+"/pet/{petId}";
    public static String deletepet_url = base_url+"/pet/{petId}";

}
