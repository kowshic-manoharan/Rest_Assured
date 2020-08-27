/**
 * 
 */
package stepDefinitions;

import cucumber.api.java.Before;

/**
 * @author kowshic
 *
 */
public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable {
		StepDefinition sob = new StepDefinition();
		if(StepDefinition.placeID==null) {
			sob.add_place_payload_with("kowsan", "kanada", "Bangalore");
			sob.user_calls_with_http_request("addPlaceAPI", "POST");
			sob.verify_placeid_create_that_maps_to_something_using_something("kowsan", "getPlaceAPI");
		}
		
	}

}
