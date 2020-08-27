/**
 * 
 */

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourses;
import pojo.WebAutomation;

/**
 * @author kowshic
 *
 */

public class AuthorizationGrant {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F3QEUbbeH9Vnz1uj-59CG4B5vpL8GHGWMhL8BInYqjXkKSrFzqmviPyikt2hCaZ-liotyaY0n9BEQMoW12bm6nz4&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
		String partialCode = url.split("code=")[1];
		String code = partialCode.split("&scope")[0];

		System.out.println(code);

		String accessCode = given().urlEncodingEnabled(false).queryParams("code", code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath jsonPath = new JsonPath(accessCode);
		String accessToken =  jsonPath.getString("access_token");

		GetCourses gc = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);

		List<Api> apiCourses = gc.getCourses().getApi();
		
		for(int i=0; i<apiCourses.size();i++) {
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java")) {
				apiCourses.get(i).getPrice();
			}
		}
		
		List<WebAutomation> webCourses = gc.getCourses().getWebAutomation();
		
		for(int i=0; i<webCourses.size();i++) {
			System.out.println(webCourses.get(i).getCourseTitle());
			}
		
	}

}
