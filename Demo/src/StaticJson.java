import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * 
 */

/**
 * @author kowshic
 *
 */
public class StaticJson {
	
	@Test()
	public static void addBook() throws IOException {
		RestAssured.baseURI="http://216.10.245.166";
		String jsonFilePath = System.getProperty("user.dir") + "/src/files/AddbookDetails.json" ;
		String responseBody = given().log().all().header("Content-Type", "application/json")
		.body(getingResourseFromExternalFile(jsonFilePath))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(responseBody);
		String id = js.getString("ID");
		System.out.println(id);
	}
	
	public static String getingResourseFromExternalFile(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
