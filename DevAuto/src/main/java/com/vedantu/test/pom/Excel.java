package com.vedantu.test.pom;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel

{

	public static int getRowCount(String xlPath, String Sheet)

	{
		int rc = -1;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			rc = wb.getSheet(Sheet).getLastRowNum();
		} catch (Exception e) {

		}

		return rc;

	}

	public static String getCellValue(String xlPath, String Sheet, int row, int cell) {
		String Value = "";
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Cell valueCell = wb.getSheet(Sheet).getRow(row).getCell(cell);
			if (valueCell != null) {
				switch (valueCell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					break;
				case Cell.CELL_TYPE_NUMERIC:
					valueCell.setCellType(Cell.CELL_TYPE_STRING);
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					valueCell.setCellType(Cell.CELL_TYPE_STRING);
					break;
				case Cell.CELL_TYPE_BLANK:
					valueCell.setCellType(Cell.CELL_TYPE_STRING);
					break;
				case Cell.CELL_TYPE_FORMULA:
					valueCell.setCellType(Cell.CELL_TYPE_STRING);
					break;
				}
				Value = valueCell.getStringCellValue();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Value;
	}
}