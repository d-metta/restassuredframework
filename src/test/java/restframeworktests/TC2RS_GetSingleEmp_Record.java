package restframeworktests;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import restframeworkbases.Testbase;

public class TC2RS_GetSingleEmp_Record extends Testbase {
	
	String uri="http://dummy.restapiexample.com/api/v1";
	String path="/employee/";
	String empid="24";
	
	@BeforeClass
	public void getSingleEmpRecord() {
		
        logger.info("*****STARTED TC-TC1_Get_Weather_Details****");
		RestAssured.baseURI=uri;
		httpRequest=RestAssured.given();		
		resposne=httpRequest.request(Method.GET,path+empid);	
		
		System.out.println(resposne);
	}
	
	@Test
	public void checkResponseBody() {
		
        logger.info("*****Checking Response Body****");
     	
        String respBody=resposne.getBody().asString();
     	logger.info("Response Body==>"+respBody);
     	
		Assert.assertEquals(respBody.contains(empid), true); 
		
		System.out.println("empid is");
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*****Finished Checking TC-TC1 STARTED****");
	}
	

	@Test
	public void checkResponseStatusCode() {
		
        logger.info("*****Checking Response Status Code****");
   		int statuscode=resposne.statusCode();

        logger.info("Status Code is==>"+ statuscode);
		Assert.assertEquals(statuscode, 200);		 
	}
	
	@Test
	public void checkResponseTime() {
		
        logger.info("*****Checking Response Time****");
   		long resposneTime=resposne.getTime();
        logger.info("Response Time is==>"+ resposneTime);
		
        if(resposneTime>2000)
            logger.warn("Response Time is grater then 2000");

		Assert.assertTrue(resposneTime<2000);	
	}
	
	
	@Test
	public void checkStatusLine() {
		
        logger.info("*****Checking Status Line****");
        
   		String statuLine=resposne.getStatusLine();
        logger.info("Status Line is==>"+ statuLine);
		
        Assert.assertEquals(statuLine, "HTTP/1.1 200 OK");
	}
	
	
	@Test
	public void checkContentType() {
		
        logger.info("*****Checking Response Headers - Content Type****");
        
   		String contenTtype=resposne.header("Content-Type");
        logger.info("Content Type is==>"+ contenTtype);
		
        Assert.assertEquals(contenTtype, "application/json;charset=utf-8");
	}
	
	@Test
	public void checkServerType() {
		
        logger.info("*****Checking Response Headers - Server Type****");
        
   		String serverType=resposne.header("server");
        logger.info("Server Type is==>"+ serverType);
		
        Assert.assertEquals(serverType, "nginx/1.16.0");
	}
	
	@Test
	public void checkContentEncoding() {
		
        logger.info("*****Checking Response Headers content Encoding****");
        
   		String contentEncoding=resposne.header("Content-Encoding");
        logger.info("Content Encoding is==>"+ contentEncoding);
		
        Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test
	public void checkContentLength() {
		
        logger.info("*****Checking Response Headers content length****");
        
   		String contentLength=resposne.header("Content-Length");
        logger.info("Content Length is==>"+ contentLength);
        
        if(Integer.parseInt(contentLength)<100)
            logger.warn("Content Length is ledd then 100");

		Assert.assertTrue(Integer.parseInt(contentLength)>100);	
	}
	
	@Test
	public void checkCookies() {
		
        logger.info("*****Checking Cookies****");
        
   		String cookie=resposne.getCookie("PHPSESSID");
    
	}
}
