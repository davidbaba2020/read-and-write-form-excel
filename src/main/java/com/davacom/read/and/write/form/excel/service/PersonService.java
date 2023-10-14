package com.davacom.read.and.write.form.excel.service;

import com.davacom.read.and.write.form.excel.models.Person;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private static final String filePath = "/Users/davidbaba/Downloads/read-and-write-form-excel/src/main/resources/person.xlsx";
    private static final List<Person> personList = new ArrayList<>();

    public String readExcel() {
        Person person = new Person();
        String msg = "";
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = null;
            int i =1;
            while ((row = sheet.getRow(i))!=null) {
                person.setId((int) row.getCell(0).getNumericCellValue());
                person.setName(row.getCell(1).getStringCellValue());
                person.setAge((int) row.getCell(2).getNumericCellValue());
                person.setState(row.getCell(3).getStringCellValue());
                personList.add(person);
                i ++;
                System.out.println(person);
            }
            msg = "Content read successfully";
            workbook.close();
            System.out.println(personList);
        } catch (IOException e) {
            msg = "An error occured while reading";
            throw new RuntimeException(e);
        }

//        try {
//            FileInputStream file = new FileInputStream(new File(filePath));
//            Workbook workbook = new XSSFWorkbook(file);
//
////            Sheet sheet = workbook.getSheet(SHEET);
//            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
//
//            Iterator<Row> rows = sheet.iterator();
//
//            int rowNumber = 0;
//            while (rows.hasNext()) {
//                Row currentRow = rows.next();
//
//                // skip header
//                if (rowNumber == 0) {
//                    rowNumber++;
//                    continue;
//                }
//
//                Iterator<Cell> cellsInRow = currentRow.iterator();
//
//                int cellIdx = 0;
//                while (cellsInRow.hasNext()) {
//                    Cell currentCell = cellsInRow.next();
//
//                    switch (cellIdx) {
//                        case 0:
//                            person.setId((int) currentCell.getNumericCellValue());
//                            break;
//
//                        case 1:
//                            person.setName(currentCell.getStringCellValue());
//                            break;
//
//                        case 2:
//                            person.setAge((int) currentCell.getNumericCellValue());
//                            break;
//
//                        case 3:
//                            person.setState(currentCell.getStringCellValue());
//                            break;
//
//                        default:
//                            break;
//                    }
//
//                    cellIdx++;
//                }
//                System.out.println(person);
//                personList.add(person);
//            }
//            workbook.close();
//            System.out.println(personList);
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
//        }

        return msg;
    }
}
