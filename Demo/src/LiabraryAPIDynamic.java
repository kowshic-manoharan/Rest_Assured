import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import files.ReUsableMethods;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * @author kowshic
 * This the Liabrary API program used for learning the dynamic payLoad
 * Sending parameters to payLoad from Test
 */

public class LiabraryAPIDynamic {
	
	@Test
	public static void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		String responseBody = given().log().all().header("Content-Type", "application/json")
		.body(payLoad.addBooks("kowshic", "241194"))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(responseBody);
		String id = js.getString("ID");
		System.out.println(id);
		
	}
}
