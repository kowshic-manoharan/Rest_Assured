import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * 
 */

/**
 * @author kowshic
 * Example on Parameterization of API Tests with multiple data sets
 */

public class LiabraryAPIUsingParameterizationMultipleDataSet {
	@Test(dataProvider="bookDetails")
	public static void addBook(String isbn, String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String responseBody = given().log().all().header("Content-Type", "application/json")
		.body(payLoad.addBooks(isbn, aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(responseBody);
		String id = js.getString("ID");
		System.out.println(id);
	}

	@DataProvider(name="bookDetails")
	public Object[][] booksDetail() {
		return new Object[][] {
			{"qwe", "456"},
			{"ert", "789"},
			{"ddg", "789"}
		};
	}	
}
