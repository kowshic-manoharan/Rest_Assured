/**
 * 
 */

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import io.restassured.RestAssured;
import pojo.Addplace;
import pojo.Location;
/**
 * @author kowshic
 *
 */


public class Serialization {
	
	public static void main(String[] args) throws InterruptedException {
	
	RestAssured.baseURI ="https://rahulshettyacademy.com";
	
	
	Addplace place = new Addplace();
	
	Location lp = new Location();
	lp.setLat(-38.383494);
	lp.setLng(33.427362);
	place.setLocation(lp);
	
	place.setAccuracy(50);
	place.setName("Frontline house");
	place.setPhone_number("(+91) 983 893 3937");
	place.setAddress("29, side layout, cohen 09");
	ArrayList<String> mylist = new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	place.setTypes(mylist);
	
	place.setWebsite("http://google.com");
	place.setLanguage("French-IN");
	
	String response = given().log().all().queryParam("key", "qaclick123")
	.body(place)
	.when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(response);
	
	}

}
