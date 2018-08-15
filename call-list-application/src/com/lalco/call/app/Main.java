
package com.lalco.call.app;

import java.io.IOException;

import com.lalco.call.app.process.DataConvertor;
import com.lalco.call.app.process.DataConvertorImp;
import com.lalco.call.app.process.DataProcessor;
import com.lalco.call.app.process.DataProcessorImp;



public class Main {
	
	private static final String inputFileName = "D:\\Docs\\temp\\lalcol\\callist\\approch_list_201805-3.xlsx";
	
	private static final String outputNormalFileName = "D:\\Docs\\temp\\lalcol\\callist\\output\\list_normal_output.xlsx";
	private static final String outputErrorFileName = "D:\\Docs\\temp\\lalcol\\callist\\output\\list_error_output.xlsx";
	
	public static void main(String[] args) throws IOException {
		DataProcessor processor = new DataProcessorImp(inputFileName);
		processor.listProcessor();
		DataConvertor dataConvertor = new DataConvertorImp();
		dataConvertor.exportExcel(processor.getNormalList(), outputNormalFileName);
		dataConvertor.exportExcel(processor.getErrorList(), outputErrorFileName);
    }

}
