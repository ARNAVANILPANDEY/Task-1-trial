package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author javacodepoint.com
 *
 */

public class write {

    public static void main(String[] args) {

        // Creating file object of existing excel file
        File xlsxFile = new File("C:\\\\Users\\\\Anshuman Oracle\\\\Documents\\\\workspace-spring-tool-suite-4-4.14.1.RELEASE\\\\loll\\\\src\\\\main\\\\java\\\\loll\\\\bok.xlsx");

        //New students records to update in excel file
        Object[][] newinfo = {
                {"Installment No.","Stage Number","Installment Due Date","Installment Amount","Interest Rate",
                        "Component 1 (Principal)","Component 2 (Interest)",	"Component 3 (Fees)","Component 4 (Insurance Premium)","Opening Balance","Closing Balance"},{}};


        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);

            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);

            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(0);

            //Getting the count of existing records
            int rowCount = sheet.getLastRowNum();

            //Iterating new students to update
            for (Object[] student : newinfo) {

                //Creating new row from the next row count
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                //Iterating student informations
                for (Object info : student) {

                    //Creating new cell and setting the value
                    Cell cell = row.createCell(columnCount++);
                    if (info instanceof String) {
                        cell.setCellValue((String) info);
                    } else if (info instanceof Integer) {
                        cell.setCellValue((Integer) info);
                    }
                }
            }
            //Close input stream
            inputStream.close();

            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            //Close the workbook and output stream
            workbook.close();
            os.close();

            System.out.println("Excel file has been updated successfully.");

        } catch (EncryptedDocumentException | IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
    }
}