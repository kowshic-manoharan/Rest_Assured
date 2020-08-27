package Library;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import resource.ExcelUtility;
import resource.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * @author kowshic
 * This the Liabrary API program used for learning the dynamic payLoad
 * Sending parameters to payLoad from Test
 */

public class LiabraryAPIDynamic {
	
	@Test
	public static void addBook() throws IOException {
		
		ExcelUtility getData = new ExcelUtility();
		ArrayList<String> data = getData.readFromExcel("AddBook", "RestAssured");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));
		
		RestAssured.baseURI="http://216.10.245.166";
		String responseBody = given().log().all().header("Content-Type", "application/json")
		.body(map)
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(responseBody);
		String id = js.getString("ID");
		System.out.println(id);
		
	}
}
