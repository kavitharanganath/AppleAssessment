package applestoreAPI;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.*;
import java.util.Map;
import java.util.Set;

public class appleAssessment {
	
	@Test(enabled=false)
	public void getStatus() {
		
		given()
		.when()
		.get("https://istheapplestoredown.com/api/v1/status/worldwide")
		.then()
		.statusCode(200)
		.extract().response().body().prettyPrint();
	}
				
		@Test(enabled=true)
		public void checkResponse() throws IOException {
		
			SoftAssert softAssert=new SoftAssert();
			String expectedStatus="y";
			String actualStatus="n";
			
			String s = given()
			.when()
			.get("https://istheapplestoredown.com/api/v1/status/worldwide")
			.then()
			.extract().response().asString();
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();
			
			JsonNode jnode = mapper.readTree(s);
			JsonPath jpath=new JsonPath(s);
			Map<String,String> map = jpath.getMap("$");
			Set<String> mapSet = map.keySet();
			
			for(String str:mapSet){
			node.set(str, jnode.get(str).get("status"));
			if(jnode.get(str).get("status").asText().contains("n")){
				softAssert.assertEquals(actualStatus, expectedStatus);
			System.out.println("Name of the Country with 'status':'y' is");
			System.out.println(jnode.get(str).get("name"));
		    }
			softAssert.assertAll();       
	  }
			
    }

}
