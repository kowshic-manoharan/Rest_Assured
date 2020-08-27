package JiraAPI_Automation_code;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import files.payLoad;

/**
 * RestAPI works in three principles
 * Given - all input details
 * when - submit the API
 * then - validate the response
 */

/**
 * @author kowshic
 * This is the first program to learn the basics of rest assured
 */
public class basic_add_value_to_the_server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payLoad.AddPlaceToServer()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)");
	}
}
