/**
 * 
 */
package resources;

import java.util.ArrayList;

import pojo.Addplace;
import pojo.Location;

/**
 * @author kowshic
 *
 */
public class PayLoad {

	public Addplace addplacePayLoad(String name, String language, String address) {
		Addplace place = new Addplace();
		Location lp = new Location();
		lp.setLat(-38.383494);
		lp.setLng(33.427362);
		place.setLocation(lp);
		place.setAccuracy(50);
		place.setName(name);
		place.setPhone_number("(+91) 983 893 3937");
		place.setAddress(address);
		ArrayList<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		place.setTypes(mylist);
		place.setWebsite("http://google.com");
		place.setLanguage(language);
		return place;
	}
	
	public String deletePayLoad(String placeID) {
		return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}";
	}

}
