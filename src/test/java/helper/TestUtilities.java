package helper;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtilities {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	String c1_1;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	int rowcount=ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowcount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	int cellcount=row.getLastCellNum();
	wb.close();
	fi.close();
	return cellcount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(colnum);
	String data;
	try {
		
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
	}
	catch (Exception e) {
	data ="";
	}
	wb.close();
	fi.close();
	return data;
	}
	
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	}
	
	public static String getTestCaseID(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String tcid=row.getCell(0).getStringCellValue();

	wb.close();
	fi.close();
	return tcid;
	
	    }

	public static String getEndPoint(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String endPoint=row.getCell(1).getStringCellValue();

	wb.close();
	fi.close();
	return endPoint;
	
	    }
	public static String getURI(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String uri=row.getCell(2).getStringCellValue();

	wb.close();
	fi.close();
	return uri;
	
	    }
	
	public static String getMethodType(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String methodtype=row.getCell(3).getStringCellValue();

	wb.close();
	fi.close();
	return methodtype;
	
	    }
	public static String getAuthType(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String authtype=row.getCell(4).getStringCellValue();

	wb.close();
	fi.close();
	return authtype;
	
	    }
	
	public static String getAuthID(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String authid=row.getCell(5).getStringCellValue();

	wb.close();
	fi.close();
	return authid;
	
	    }
	
	public static String getAuthPWD(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String authpwd=row.getCell(6).getStringCellValue();

	wb.close();
	fi.close();
	return authpwd;
	
	    }
	
	public static String getBodyParams(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodyparams=row.getCell(7).getStringCellValue();

	wb.close();
	fi.close();
	return bodyparams;
	
	    }
	
	public static String getBodyKey1(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodykey1=row.getCell(8).getStringCellValue();

	wb.close();
	fi.close();
	return bodykey1;
	
	    }
	
	public static String getBodyKey1Value(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodykey1value=row.getCell(9).getStringCellValue();

	wb.close();
	fi.close();
	return bodykey1value;
	
	    }
	
	public static String getBodyKey2(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodykey2=row.getCell(10).getStringCellValue();

	wb.close();
	fi.close();
	return bodykey2;
	
	    }
	
	public static String getBodyKey2Value(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodykey2value=row.getCell(11).getStringCellValue();

	wb.close();
	fi.close();
	return bodykey2value;
	
	    }
	
	public static String getBodyKey3(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodykey3=row.getCell(12).getStringCellValue();

	wb.close();
	fi.close();
	return bodykey3;
	
	    }
	
	public static String getBodyKey3Value(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	String bodykey3value=row.getCell(13).getStringCellValue();

	wb.close();
	fi.close();
	return bodykey3value;
	
	    }
	
	
}
