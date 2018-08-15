package com.lalco.call.app.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lalco.call.app.entity.Entity;

public class DataConvertorImp implements DataConvertor {
	private static String[] columns = {
			"Call List No", 
			"No", 
			"Main Contact No",
			"Secondary Contact No",
			"First Name (English)", 
			"Last Name (English)", 
			"First Name (Lao)", 
			"Last Name (Lao)",
			"Address 1 (English)",
			"Address 2 (English)",
			"Sex (M or F)",
			"Maker",
			"Model",
			"Year",
			"Estimated Loan Amount",
			"Rank"
	};
	@Override
	public void exportExcel(List<Entity> list, String fileName) throws IOException {
		
		
		Workbook workbook = new XSSFWorkbook();
		
        // Create a Sheet
        Sheet sheet = workbook.createSheet("ABCD");

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        
        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(int i=0;i<list.size();i++){
        	Entity entity = list.get(i);
        	
        	System.out.print(" Writing data to excel file ");
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entity.getListNo());
            System.out.print(" [ List No ] : "+entity.getListNo());
            row.createCell(1).setCellValue(entity.getNo());
            System.out.print(" [ No ] : "+entity.getNo());
            row.createCell(2).setCellValue(entity.getMainContact());
            System.out.print(" [ Main Contact ] : "+entity.getMainContact());
            row.createCell(3).setCellValue(entity.getScndContact());
            System.out.print(" [ Second Contact ] : "+entity.getScndContact());
            row.createCell(4).setCellValue(entity.getFirstNameEn());
            System.out.print(" [ Frist name en ] : "+entity.getFirstNameEn());
            row.createCell(5).setCellValue(entity.getLastNameEn());
            System.out.print(" [ Last Name en ] : "+entity.getLastNameEn());
            row.createCell(6).setCellValue(entity.getFirstNameLa());
            System.out.print(" [ First Name la ] : "+entity.getFirstNameLa());
            row.createCell(7).setCellValue(entity.getLastNameLa());
            System.out.print(" [ Last Name la ] : "+entity.getLastNameLa());
            row.createCell(8).setCellValue(entity.getAddress1());
            System.out.print(" [ Address 1 ] : "+entity.getAddress1());
            row.createCell(9).setCellValue(entity.getAddress2());;
            System.out.print(" [ Address 2 ] : "+entity.getAddress2());
            row.createCell(10).setCellValue(entity.getGender());
            System.out.print(" [ Gender ] : "+entity.getGender());
            row.createCell(11).setCellValue(entity.getMaker());
            System.out.print(" [ Maker ] : "+entity.getMaker());
            row.createCell(12).setCellValue(entity.getModel());
            System.out.print(" [ Model ] : "+entity.getModel());
            row.createCell(13).setCellValue(entity.getYear());
            System.out.print(" [ Year ] : "+entity.getYear());
            row.createCell(14).setCellValue(entity.getEstimate());
            System.out.print(" [ Estimate ] : "+entity.getEstimate());
            row.createCell(15).setCellValue(entity.getRank());
            System.out.println(" [ Rank ] : "+entity.getRank());
            list.remove(i);
        }
        
		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
	}

}
