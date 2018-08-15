package com.lalco.call.app.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.lalco.call.app.entity.Entity;

public class DataProcessorImp implements DataProcessor {
	
	//	private static Logger logger = Logger.getLogger(Main.class);
	
	private static Workbook workbook ;
	private static Sheet datatypeSheet;
	
	private List<Entity> normalList = new ArrayList<Entity>();
	private List<Entity> errorList =  new ArrayList<Entity>();
	
	public DataProcessorImp(String fileName){
    
    	try {
    		System.out.println("Loading Excel file Loading ..............");
	    	workbook = WorkbookFactory.create(new File(fileName));
	    	System.out.println("finish Loading Excel File Loading .............");
			datatypeSheet = workbook.getSheetAt(0);
		} catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
			System.err.println("Exception occured while try to read excel file");
		}	
    
	}
	
	@Override
	public void listProcessor() throws IOException {
		
        System.out.println("..................... Loading Excel File data successful.");
		
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        Iterator<Row> rowIterator = datatypeSheet.rowIterator();
        int rowIndex = 1;
        while (rowIterator.hasNext()) {
			if (rowIndex > 1) {
				System.out.println(" Reading data Excel at row number : " + rowIndex);
				System.out.println("===========================================");
				Row row = rowIterator.next();
				// Now let's iterate over the columns of the current row
				Iterator<Cell> cellIterator = row.cellIterator();
				int colIndex = 1;
				Entity entity = new Entity();
				boolean check = false;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);

					switch (colIndex) {
					case 1:
						System.out.print(colIndex + " [ List ] : " + cellValue);
						entity.setListNo(cellValue);
						break;
					case 2:
						entity.setNo(cellValue);
						System.out.print(colIndex + " [ No ] : " + cellValue);
						break;
					case 3:
						if (cellValue.matches("[a-zA-Z\\s]+"))
							entity.setFirstNameEn(cellValue);
						else
							entity.setFirstNameLa(cellValue);

						System.out.print(colIndex + " [ Name ] :" + cellValue);
						break;
					case 4:
						entity.setMainContact(cellValue);
						System.out.print(colIndex + " [ Main Contact ] :" + cellValue);
						if(cellValue.matches("[0-9]{7,11}"))
							check = true;
						break;
					case 5:
						if(cellValue.matches("[0-9]{7,11}"))
							entity.setScndContract(cellValue);
						System.out.print(colIndex + " [  Second Contact ] : " + cellValue);
						break;
					case 6:
						entity.setMaker(cellValue);
						System.out.print(colIndex + " [ Maker ] : " + cellValue);
						break;
					case 7:
						entity.setModel(cellValue);
						System.out.print(colIndex + " [ Model ] : " + cellValue);
						break;
					case 8:
						entity.setYear(cellValue);
						System.out.print(colIndex + " [ Year ] : " + cellValue);
						break;
					case 9:
						if (cellValue.trim().length() != 0 && cellValue.matches("\\d+"))
							entity.setEstimate(Float.valueOf(cellValue));
						System.out.print(colIndex + " [ Estimate ] : " + cellValue);
						break;
					case 10:
						entity.setAddress1(cellValue);
						System.out.print(colIndex + " [ Address ] : " + cellValue);
						break;
					case 11:
						entity.setRank(cellValue);
						System.out.print(colIndex + " [ Rank ] : " + cellValue);
						break;
					}

					System.out.print("\t");
					colIndex++;
				}
				System.out.print("\n");
				boolean valid = entity.getMainContact().trim().length() > 0;
				if (valid){
					if(check)
						normalList.add(entity);
					else
						errorList.add(entity);
				}
				System.out.print("\n==========================================\n");
			}
            rowIndex++;
        }
        
        workbook.close();
        
        System.out.println("File Process successfully.!!!!!!!!!!!!!!!!!");
        System.out.println("list length : "+normalList.size());
        
	}

	@Override
	public List<Entity> getNormalList() {
		return normalList;
	}

	@Override
	public List<Entity> getErrorList() {
		return errorList;
	}
	
	

}
