/**
 * 
 */

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.Location;
/**
 * @author kowshic
 *
 */


public class SpecBuilders {
	
	public static void main(String[] args) throws InterruptedException {
	
	
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
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	RequestSpecification reqspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	
	ResponseSpecification resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
	
	RequestSpecification req = given().spec(reqspec).body(place);
	
	Response res = req.when().post("/maps/api/place/add/json")
	
	.then().spec(resspec).extract().response();
	
	String responseString = res.asString();
	
	System.out.println(responseString);
	}

}
