package restframeworkmethods;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import restframeworkbases.Testbase;

public class SendRequestMethods extends Testbase{
	
	String uri;
	String Path;
	
	public Response sendReqWithoutParams() {
	
		RestAssured.baseURI=uri;
		httpRequest=RestAssured.given();		
		
		resposne=httpRequest.request(Method.GET,Path);	
		return resposne;
	}
	
	public Response sendReqWithHeaders() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		httpRequest=RestAssured.given();		
		resposne=httpRequest.request(Method.GET,"/Hyderabad");	
		return resposne;
	}


	
	public Response getResponse1() throws InterruptedException, TimeoutException  {
		RestAssured.baseURI=uri;
		httpRequest=RestAssured.given();		
	    int i = 0;
	    
		while (i < 200) {
			resposne = httpRequest.request(Method.GET,Path);
	        
			 String responseBody=resposne.getBody().asString();
			
	        if (responseBody.contains("Hyderabad")) {
	            break;
	        } else {
	            TimeUnit.SECONDS.sleep(1);
	            ++i;
	            if (i == 200) {
	                throw new TimeoutException("Timed out after waiting for " + i + " seconds");
	            }
	        }
	    }
		return resposne;
		
		
	}
	


	
}
