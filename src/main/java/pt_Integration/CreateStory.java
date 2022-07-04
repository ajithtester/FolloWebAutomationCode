package pt_Integration;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.follo.baseclass.Baseclass;


public class CreateStory extends Baseclass {
	@Test
	
		public static void  post_Story(String Storydescription , String IssueSummary ) throws Throwable {
			
			
			RequestSpecification request=RestAssured.given();

			//Passsing Header values
			request.header("Content-Type","application/json");

			request.header("X-TrackerToken","b8ab9922b1ac32fc326553f4fadc4e18"); // Mention your own Pivotal Tracker API Token

			//Creating object for JSONObject class
			JSONObject json=new JSONObject();
			
			//Passing the Body content using json object
			json.put("name", Storydescription); //storydesc
			json.put("current_state", "Unstarted");
			json.put("story_type", "Bug");
			json.put("description", IssueSummary); //issuesumm

			//Creating object for JSONArray class
			JSONArray ja = new JSONArray(); 
			
			//Now passing Body content inside label using Hashmap
	        Map m = new LinkedHashMap(1); 
			m.put("name", "AutomationDemolabel");
			ja.add(m); 

			Map m1 = new LinkedHashMap(1); 
			m1.put("name", "severity-low");
			ja.add(m1); 

			json.put("labels", ja); 

			Print("The labels are"+ja);

			Wait(3000);
			json.put("owned_by_id", 3368449 ); // Assign to user id   3368449 3350664


			//Converting JSON content to String format
			request.body(json.toJSONString());

			//Mentioning the type of post and url
			Response response = request.post("https://www.pivotaltracker.com/services/v5/projects/2459957/stories");

			int code = response.getStatusCode();

			Print("Status Code is"+code);

			//Converting the JSON values in to String
			String data=response.asString();

			Print("Data is "+data);

			Print("Response time"+response.getTime());

			Assert.assertEquals(code,200);

			Wait(3000);

		}

	}
