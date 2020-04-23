package helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;




public class TestBodyParamsUtils {


static String xlfile=System.getProperty("user.dir")+"/src/test/java/TestCases.xlsx";
static String xlsheet="ReqBodyParams";

static String[] anArray;	

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	@Test
	public static void getTestCaseID() throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(1);
	int cellcount=row.getLastCellNum();
	
	System.out.println(cellcount);
	
	
	System.out.println(row.getCell(1).getStringCellValue());
	
	
	
	String empdata[][]=new String[1][cellcount];
	
	for (int i = 1; i <= 1; i++) {
		for (int j= 0 ; j <cellcount; j++ )	{
			empdata[i-1][j]=row.getCell(j).getStringCellValue();
		}
	}
	System.out.println(empdata);

	
	wb.close();
	fi.close();
	//return tcid;
	
	    }
}
