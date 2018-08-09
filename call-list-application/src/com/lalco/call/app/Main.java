
package com.lalco.call.app;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Main {
	
	private static final String FILE_NAME =  "D:\\Docs\\temp\\lalcol\\callist\\approach_list_20180503.xls";
	private static Logger logger = Logger.getLogger(Main.class);
	
	private static Workbook workbook ;
	private static Sheet datatypeSheet;
    
    static {
    	try {
			
	    	workbook = WorkbookFactory.create(new File(FILE_NAME));
			datatypeSheet = workbook.getSheetAt(0);
		} catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
			logger.debug("Exception occured while try to read excel file", e);
		}
    	
    }
    
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		logger.debug("file size is "+ datatypeSheet.getLastRowNum()+1);
        logger.debug("read datasuccessful");
		
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        Iterator<Row> rowIterator = datatypeSheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                
                
                logger.debug(cellValue + "\t");
            }
            logger.debug("\n");
        }
        
        workbook.close();
        
        logger.debug("File Process successfully.");
    }

	

}
