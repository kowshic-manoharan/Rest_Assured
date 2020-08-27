Feature: Validating Place API's


@AddPlace
Scenario Outline: Verify if the place is being successfully added using AddPlace API


Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "addPlaceAPI" with "Post" http request
Then the API call got success with the status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id create that maps to "<name>" using "getPlaceAPI"

Examples:
	|name    | language | address                        |
	|Kowshic | Tamil    | No 67.Malar Avanue, Coimbatore |
#	|Kowsan  | English  | Chennai                        |
	
@DeletePlace
Scenario: Verify if the place which is added is getting deleted using DeletePlaceAPI

Given deleteAPI payload
When user calls "deletePlaceAPI" with "Post" http request
Then the API call got success with the status code 200