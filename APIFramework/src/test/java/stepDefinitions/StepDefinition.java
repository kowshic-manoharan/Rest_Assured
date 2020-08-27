/**
 * 
 */
package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.PayLoad;
import resources.Utility;

/**
 * @author kowshic
 *
 */
public class StepDefinition extends Utility {

	RequestSpecification req;
	ResponseSpecification resspec;
	Response res;
	static String placeID;
	PayLoad data = new PayLoad();

	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_with(String name, String language, String address) throws Throwable {
		req = given().spec(requestSpecification())
				.body(data.addplacePayLoad(name,language,address));
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_with_http_request(String resource, String method) throws Throwable {
		
		APIResources resourceAPI =APIResources.valueOf(resource);
		
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		if(method.equalsIgnoreCase("POST")) {
			res = req.when().post(resourceAPI.getResource());
		}else if(method.equalsIgnoreCase("GET")){
			res = req.when().get(resourceAPI.getResource());
		}
	}

	@Then("^the API call got success with the status code 200$")
	public void the_api_call_got_success_with_the_status_code_200() throws Throwable {
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String keyValue, String ExpectedValue) throws Throwable {
		Assert.assertEquals(getJsonPath(res, keyValue), ExpectedValue);
	}
	
	
	 @And("^verify place_Id create that maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	    public void verify_placeid_create_that_maps_to_something_using_something(String expectedName,String resource) throws Throwable {
		placeID = getJsonPath(res,"place_id");
		System.out.println(placeID);
		req = given().spec(requestSpecification()).queryParam("place_id", placeID);
		user_calls_with_http_request(resource,"GET");
		String name = getJsonPath(res,"name");
		Assert.assertEquals(name, expectedName);
	}
	 
	 @Given("^deleteAPI payload$")
	    public void deleteapi_payload() throws Throwable {
		 req = given().spec(requestSpecification()).body(data.deletePayLoad(placeID));
	    }
}
