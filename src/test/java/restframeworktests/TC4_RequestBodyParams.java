package restframeworktests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.TestUtilities;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restframeworkbases.Testbase;



public class TC4_RequestBodyParams extends Testbase{
	

	@Test
	public static void postResitrationSucessful () {
		RestAssured.baseURI="https://test.api.amadeus.com";
		RequestSpecification httpRequest=RestAssured.given();
		
		/*
		Map<String,String> arguments = new HashMap<>();
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
		    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
		         + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		//http.setFixedLengthStreamingMode(length);
		 * System.out.println(length);
		*/
		/*
		JSONObject jsonObject = new JSONObject();
		
		 //JSONArray lineItems = jsonObject.getJSONArray("lineItems");
		 JSONArray lineItems = JSONArray.fromObject(jsonString); 
		    for (Object o : lineItems) {
		        JSONObject jsonLineItem = (JSONObject) o;
		        String key = jsonLineItem.getString("key");
		        String value = jsonLineItem.getString("value");
		        		    }
		
		*/
		httpRequest.formParams("grant_type", "client_credentials","client_id", "GjNSlUGqV9MpoQucksZ1rxJEDduflwps","client_secret", "7mb9Lc9dyRBpmY00");
		//httpRequest.formParam("grant_type", "client_credentials");
		//httpRequest.formParam("client_id", "GjNSlUGqV9MpoQucksZ1rxJEDduflwps");
		//httpRequest.formParam("client_secret", "7mb9Lc9dyRBpmY00");
		
		
		
		//httpRequest.body(requestparams.toJSONString());
		
		Response response=httpRequest.request(Method.POST,"/v1/security/oauth2/token");
		
		  
				//print response in window
				String responseBody=response.getBody().asString();	
				System.out.println("Response body is " +responseBody);
			 
				//Statuscode Verification		
				int statuscode=response.statusCode();
				Assert.assertEquals(statuscode, 200);
			
	}

}
