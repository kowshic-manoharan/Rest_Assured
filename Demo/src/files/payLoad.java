/**
 * while running the basic_add_value_to_the_server it calls to this method
 */
package files;

/**
 * @author kowshic
 * this method was called to replace the body data
 */
public class payLoad {

	/**
	 * @param args
	 * @return string
	 */
	public static String AddPlaceToServer() {
	return "{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
			"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"shoe park\",\r\n" + 
			"    \"shop\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
			"  \"language\": \"French-IN\"\r\n" + 
			"}\r\n" + 
			"";

	}
	
	public static String Course() {
		return "{\r\n" + 
				"\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}";
	}
	
	public static String addBooks(String isbn, String aisle) {
		String book ="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
		return book;
	}
}
