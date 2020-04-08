import files.payLoad;
import io.restassured.path.json.JsonPath;

/**
 * 
 */

/**
 * @author kowshic
 *
 */
public class complexJsonArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(payLoad.Course());
		// Print no of courses return by the API course
		int courseCount = js.getInt("courses.size()");
		System.out.println(courseCount);
		// Print the purchase amount
		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		// Print the title of the second book
		String bookname = js.getString("courses[1].title");
		System.out.println(bookname);
		// Print all the course name with the price
		for(int i=0; i<courseCount; i++) {
			String title = js.getString("courses["+i+"].title");
			System.out.println(title);
			int rate = js.getInt("courses["+i+"].price");
			System.out.println(rate);
		}
		// Print the no of copies sold in RPA
		System.out.println(js.getInt("courses[2].copies"));
		for(int i=0; i<courseCount; i++) {
			String title = js.getString("courses["+i+"].title");
			if(title.equalsIgnoreCase("rpa"))
			{
				System.out.println(js.getInt("courses["+i+"].copies"));
				break;
			}
		}
	}
}
