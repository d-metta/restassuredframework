package restframeworktests;



import java.util.Map;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.annotations.Test;

import helper.TestUtilities;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restframeworkbases.Testbase;

public class ExcelSendRequests2 extends Testbase {

public static String tcid;
public static String methodtype;
public static String endpoint;
public static String uri;
public static String authtype;
public static String authuid;
public static String authpwd;
public static String bearerToken;
public static Map<String, ?> bodyparams1;
public static Map<String, ?> bodyparams;
public static String bodykey1;
public static String bodykey1value;
public static String bodykey2;
public static String bodykey2value;
public static String bodykey3;
public static String bodykey3value;
public static RequestSpecification httpRequest=RestAssured.given();
public static Response resposne;


String xpath=System.getProperty("user.dir")+"/src/test/java/TestCases.xlsx";
String xlsheet="BaseData";


	
	@Test
	
        public void sendRequest() throws Exception {

		int rownumber=TestUtilities.getRowCount(xpath, xlsheet);
		int colcount=TestUtilities.getCellCount(xpath, xlsheet, 1);
        
		System.out.println(rownumber);
         
		int	j=0;
		for (int i = 1; i <= rownumber; i++) {
	
				    tcid=TestUtilities.getTestCaseID(xpath,xlsheet,i,j);
				    endpoint=TestUtilities.getEndPoint(xpath,xlsheet,i,j);
				    uri=TestUtilities.getURI(xpath,xlsheet,i,j);
				    methodtype=TestUtilities.getMethodType(xpath,xlsheet,i,j);
				    authtype=TestUtilities.getAuthType(xpath,xlsheet,i,j);
				   				    
				    System.out.println(tcid);
					System.out.println(endpoint);
					System.out.println(uri);
					System.out.println(methodtype);
					       
			
					/*******GET METHOD CALLS WITH AND WITHOUT AUTHENTICATION********/
				      if (TestUtilities.getMethodType(xpath,xlsheet,i,j).equals("GET") && TestUtilities.getAuthType(xpath,xlsheet,i,j).equals("NA")) 
					     {
				    	  /*******SENDING REQUEST METHOD AND STORING IN RESPONSE OBJECT********/
					        requestType();
					           
					      }	else   
					   if (TestUtilities.getMethodType(xpath,xlsheet,i,j).equals("GET") && TestUtilities.getAuthType(xpath,xlsheet,i,j).contains("Basic")) 
				        {
				        	authuid=TestUtilities.getAuthID(xpath,xlsheet,i,j);
				        	authpwd=TestUtilities.getAuthPWD(xpath,xlsheet,i,j);
				        	checkBasicAuth();
				           
				        } else 
				        if (TestUtilities.getMethodType(xpath,xlsheet,i,j).equals("GET") && TestUtilities.getAuthType(xpath,xlsheet,i,j).contains("Authorization Bearer Token")) 
					     {
					        checkAuthToken();
					           
					      }else										
					   /*******POST METHOD CALLS WITH BODY FORM PARAMS AND WITHOUT PARAMS********/
					   
				       if (TestUtilities.getMethodType(xpath,xlsheet,i,j).equals("POST") && TestUtilities.getBodyParams(xpath,xlsheet,i,j).contains("x-www-form-urlencoded")) 
					     {
							System.out.println(TestUtilities.getBodyParams(xpath,xlsheet,i,j));
				        	 bodykey1=TestUtilities.getBodyKey1(xpath,xlsheet,i,j);
				        	 bodykey1value=TestUtilities.getBodyKey1Value(xpath,xlsheet,i,j);
				        	 bodykey2=TestUtilities.getBodyKey2(xpath,xlsheet,i,j);
				        	 bodykey2value=TestUtilities.getBodyKey2Value(xpath,xlsheet,i,j);
				        	 bodykey3=TestUtilities.getBodyKey3(xpath,xlsheet,i,j);
				        	 bodykey3value=TestUtilities.getBodyKey3Value(xpath,xlsheet,i,j);
				        	 
				        	    System.out.println(bodykey1);
								System.out.println(bodykey1value);
								System.out.println(bodykey2);
								System.out.println(bodykey2value);
						        System.out.println(bodykey3);
								System.out.println(bodykey3value);
								requestwithBodyFormParams();
					           
					      }
			
		}
  
	}
	
	/*

	   public String getAuthorizationId() {
	        return CommonVariables.authBearer.get();
	    }
	   

	    private void setAuthorizationId(String authenticationToken) {
	        CommonVariables.authBearer.set(authenticationToken);
	    }
	    
	    public void mosoLoginAuthentication(String username, String password, String facilityID) {
	        String endPointKey = "facility-frd1".replace("facility", facilityID);
	        try {
	            BaseURLEnv = getMosoBaseURLEnv();
	            apiURL = BaseURLEnv + "session/start";
	            String postData = "{\"Username\":\"" + username + "\"," + "\"Password\":\"" + password + "\","
	                    + "\"EndpointKey\":\"" + endPointKey + "\"}";

	            response = given().contentType("application/json; charset=UTF-8").body(postData).when().post(apiURL);
	            authenticationToken = response.getBody().asString();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public String getAuthToken() {
	        return authenticationToken;
	    }
	    
	    */
	
	//@Test
	public static void checkAuthToken() {
		RestAssured.baseURI=endpoint;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.headers("Authorization","Bearer "+bearerToken);
		resposne=httpRequest.request(Method.GET,uri);
		String responseBody=resposne.getBody().asString();	
		System.out.println("Response body is " +responseBody);
	}
	
	/*NOT USING BASIC AUTH AS WE ARE INTEGRATING THE UNAME AND PWD IN API ITSELF DUE TO BASIC AUTH CACHING*/
	public static void checkBasicAuth() {
		 
    	PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
		authScheme.setUserName(authuid);
		authScheme.setPassword(authpwd);
		RestAssured.authentication=authScheme;      
		RestAssured.baseURI=endpoint;
		RequestSpecification httpRequest=RestAssured.given();
		resposne=httpRequest.request(Method.GET,uri);
		String responseBody=resposne.getBody().asString();	
		System.out.println("Response body is " +responseBody);		
 
}
	
	public static void requestwithBodyFormParams() {
		RestAssured.baseURI=endpoint;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.formParams(bodyparams1);

		/*
		httpRequest.formParam(bodykey1, bodykey1value);
		httpRequest.formParam(bodykey2, bodykey2value);
		httpRequest.formParam(bodykey3, bodykey3value);*/
		resposne=httpRequest.request(Method.POST,uri);
	    String responseBody=resposne.getBody().asString();
		System.out.println("Response body is " + responseBody);
}
		
	//@Test
	public static void requestType()
	{
		
			if (methodtype.equals("GET")) {
			    RestAssured.baseURI=endpoint;
			    RequestSpecification httpRequest=RestAssured.given();
			    resposne=httpRequest.request(Method.GET,uri);
				String responseBody=resposne.getBody().asString();	
				System.out.println("Response body is " +responseBody);
			} else
			if (methodtype.equals("POST")) {
				    RestAssured.baseURI=endpoint;
				    RequestSpecification httpRequest=RestAssured.given();
				    resposne=httpRequest.request(Method.POST,uri);
					String responseBody=resposne.getBody().asString();	
					System.out.println("Response body is " +responseBody);
				} else
			if (methodtype.equals("PUT")){
				resposne=httpRequest.request(Method.PUT,uri);
				 System.out.println(resposne);
			} else 
			if (methodtype.equals("DELETE")) {
				resposne=httpRequest.request(Method.DELETE,uri);
				 System.out.println(resposne);
			}
			
	}


}
