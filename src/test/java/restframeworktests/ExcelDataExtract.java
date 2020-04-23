package restframeworktests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.functors.AndPredicate;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.TestUtilities;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restframeworkbases.Testbase;


public class ExcelDataExtract extends Testbase{
	


public static RequestSpecification httpRequest;
public static Response resposne;
//public static String endpoint = "http://restapi.demoqa.com/utilities/weather/city";
//public static String uri="/Hyderabad";
//private static String method="GET";
private static String authenticationToken;


	@Test(dataProvider = "empdataprovider")
public static void postRegistrationProcess(String tcid,String endpoint,String uri,String method) 
{
	
		if (method.equals("GET")) {
		    RestAssured.baseURI=endpoint;
		    RequestSpecification httpRequest=RestAssured.given();
		    resposne=httpRequest.request(Method.GET,uri);
			String responseBody=resposne.getBody().asString();	
			System.out.println("Response body is " +responseBody);
		} else if (method.equals("POST")) {
			resposne=httpRequest.request(Method.POST,uri);
			 System.out.println(resposne);
		} else if (method.equals("PUT")){
			resposne=httpRequest.request(Method.PUT,uri);
			 System.out.println(resposne);
		} else if (method.equals("DELETE")) {
			resposne=httpRequest.request(Method.DELETE,uri);
			 System.out.println(resposne);
		}
		
}
   
   @DataProvider(name="empdataprovider")
  	String [][] getEmpdata() throws IOException
   {
   
	String xpath=System.getProperty("user.dir")+"/src/test/java/TestCases.xlsx";
	
	int rownumber=TestUtilities.getRowCount(xpath, "BaseData");
	int colcount=TestUtilities.getCellCount(xpath, "BaseData", 1);
	
	String testdata[][]=new String[rownumber][colcount];
	
	for (int i = 1; i <= rownumber; i++) {
		for (int j= 0 ; j < colcount; j++ )	{
			testdata[i-1][j]=TestUtilities.getCellData(xpath, "BaseData", i, j);
			
		//	System.out.println(testdata[i-1][j]);
		}
	
	}
	
	return (testdata);
	
}
   
    

}
