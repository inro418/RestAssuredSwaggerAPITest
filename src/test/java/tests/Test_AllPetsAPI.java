	package tests;
	
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	import io.restassured.response.Response;
	
	import static io.restassured.RestAssured.given;
	
	import java.util.HashMap;
	
	public class Test_AllPetsAPI {
	
		@Test(priority = 1)
		public void test01_findByStatus_GET() {
	
			given()
	
					.when()
	
					.get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
	
					.then()
	
					.statusCode(200);
		}
	
		@Test(priority = 2)
		public void test02_findByTags_GET() {
			Response res =
	
					given()
	
							.when()
	
							.get("https://petstore3.swagger.io/api/v3/pet/findByTags")
	
							.then()
	
							.statusCode(400)
	
							.log().body()
	
							.extract().response();
		}
	
		@Test(priority = 3)
		public void test03_PetId_GET() {
	
			Response res =
	
					given()
	
							.when()
	
							.get("https://petstore3.swagger.io/api/v3/pet/10")
	
							.then()
	
							.statusCode(200)
	
							.log().body()
	
							.extract().response();
	
			String jsonString = res.asString();
	
			Assert.assertEquals(jsonString.contains("Successful operation"), false);
		}
	
		@Test(priority = 4)
		public void test_04_AddNewPet_Store_POST() {
			HashMap data = new HashMap();
	
			data.put("id", "10");
			data.put("name", "doggie");
			data.put("category", "na");
			data.put("id", "1");
			data.put("name", "Dogs");
			data.put("photoUrls", "na");
			data.put("tags", "na");
			data.put("id", "0");
			data.put("name", "String");
			data.put("Status", "available");
	
			Response res = given().contentType("application/json").body(data).when()
					.post("https://petstore3.swagger.io/api/v3/pet").then().statusCode(400).log().body().extract()
					.response();
			String jsonString = res.asString();
			Assert.assertEquals(jsonString.contains("Successful operation"), false);
		}
	
		@Test(priority = 5)
		public void test_05_UpdatePets_Store_P0ST() {
			HashMap data = new HashMap();
	
			data.put("id", "10");
			data.put("name", "Dogs");
			data.put("category", "na");
			data.put("id", "1");
			data.put("name", "dogs");
			data.put("photoUrls", "na");
			data.put("tags", "na");
			data.put("id", "0");
			data.put("name", "String");
			data.put("Status", "available");
	
			Response res = given().contentType("application/json").body(data).when()
					.post("https://petstore3.swagger.io/api/v3/pet/10?name=dog&status=available").then().statusCode(400)
					.log().body().extract().response();
			String jsonString = res.asString();
			Assert.assertEquals(jsonString.contains("Successful operation"), false);
		}
	
		@Test(priority = 6)
		public void test_06_UploadImage_P0ST() {
			HashMap data = new HashMap();
	
			data.put("code", "0");
			data.put("type", "string");
			data.put("message", "string");
	
			Response res = given().contentType("application/json").body(data).when()
					.post("https://petstore3.swagger.io/api/v3/pet/10/uploadImage").then().statusCode(415).log().body()
					.extract().response();
			String jsonString = res.asString();
			Assert.assertEquals(jsonString.contains("Successful operation"), false);
		}
	
		@Test(priority = 7)
		public void test_07_UpdatePet_PUT() {
			HashMap data = new HashMap();
	
			data.put("id", "10");
			data.put("name", "doggie");
			data.put("category", "na");
			data.put("id", "1");
			data.put("name", "Dogs");
			data.put("photoUrls", "na");
			data.put("tags", "na");
			data.put("id", "0");
			data.put("name", "String");
			data.put("Status", "available");
	
			Response res = given().contentType("application/json").body(data).when()
					.put("https://petstore3.swagger.io/api/v3/pet").then().statusCode(400).log().body().extract()
					.response();
			String jsonString = res.asString();
			Assert.assertEquals(jsonString.contains("Successful operation"), false);
	
		}
	
		@Test(priority = 8)
		public void test08_DeletePet_DELETE() {
			Response res =
	
					given()
	
							.when()
	
							.delete("https://petstore3.swagger.io/api/v3/pet/10")
	
							.then()
	
							.statusCode(200)
	
							.log().body()
	
							.extract().response();
	
			String jsonString = res.asString();
	
			Assert.assertEquals(jsonString.contains("Successful operation"), false);
	
		}
	}