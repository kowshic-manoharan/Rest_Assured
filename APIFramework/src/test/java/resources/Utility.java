/**
 * 
 */
package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author kowshic
 *
 */
public class Utility {

	public static RequestSpecification reqspec;
	

	public RequestSpecification requestSpecification() throws IOException {
		if (reqspec == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
			reqspec = new RequestSpecBuilder().setBaseUri(getGlaobalProperty("baseURI"))
					.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return reqspec;
		}
		return reqspec;
	}

	public static String getGlaobalProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Rest_Assured\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response res,String key) {
		String resp = res.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
