package loll;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class write {

	// any exceptions need to be caught
	public static void main(String[] args) throws IOException
	{
		// workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet
			= workbook.createSheet(" Student Data ");

		// creating a row object
		XSSFRow row;

		// This data needs to be written (Object[])
		Map<String, Object[]> studentData
			= new TreeMap<String, Object[]>();

		studentData.put(
			"1",
			new Object[] {"Installment No.","Stage Number","Installment Due Date","Installment Amount","Interest Rate",
					"Component 1 (Principal)","Component 2 (Interest)",	"Component 3 (Fees)","Component 4 (Insurance Premium)","Opening Balance","Closing Balance" });

		studentData.put("2", new Object[] { "1", "10-Jul-22","4,754.42","12.00%","3,758.26","996.16","0.00","0.00","1,01,000.00","97,241.74"});
//		for (Map.Entry<String, Object[]> entry :  studentData.entrySet()) {
////		    System.out.println(Double.toString(Math.round(Double.parseDouble(Arrays.toString(entry.getValue())))));
//			
////		    Arrays.toString(myArray);
//		}

		Set<String> keyid = studentData.keySet();

		int rowid = 0;

		// writing the data into the sheets...

		for (String key : keyid) {

			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = studentData.get(key);
			
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				
				cell.setCellValue((String)obj);
			}
		}

		
		FileOutputStream out = new FileOutputStream(
			new File("final.xlsx"));

		workbook.write(out);
		out.close();
	}
}
