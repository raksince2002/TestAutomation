package Cura_Libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
	String filepath = "./TestData/CuraHealthData.xlsx";
	
	FileInputStream f;
	FileOutputStream fout;
	Workbook wb;
	Sheet sh;
	public ReadData() throws IOException {
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
	}
	
	public int total_rows(int sheetindex) {
		sh = wb.getSheetAt(sheetindex);
		return sh.getLastRowNum()+1;
	}
	
	public int total_columns(int sheetindex) {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(0);
		return r.getLastCellNum();
	}
	
	public String read_cell(int row, int cell, int sheetindex) {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		return c.getStringCellValue();
	}
	
	public void set_cell(int row,int cell,String actual, int sheetindex) throws IOException {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(actual);
		fout = new FileOutputStream(filepath);
		wb.write(fout);
	}
	
	public void file_close() throws IOException {
		wb.close();
		f.close();
		fout.close();
	}

}
