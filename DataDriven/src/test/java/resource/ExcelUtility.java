/**
 * 
 */
package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * @author kowshic
 *
 */
public class ExcelUtility {
	
	@SuppressWarnings("deprecation")
	public ArrayList<String> readFromExcel(String testcase, String sheetName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		/* here providing the path of the excel */
		FileInputStream fis = new FileInputStream("D://TestSheeet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// getting the number of sheets in the excel
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			// Slowing traversing to the desired sheet in the excel
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify Testcases coloumn by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				// Traversing to the next cells in the rows (identifying Columns)
				int k = 0;
				int column = 0;
				Iterator<Cell> cellValue = firstRow.cellIterator();
				while (cellValue.hasNext()) {
					Cell value = cellValue.next();
					// checking with the desired column
					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) { // Testcase is one of the column in excel sheet
						column = k;
					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					// once desired column is found, grabing the datas in the corresponding row
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell cellval = cv.next();
							if (cellval.getCellTypeEnum() == CellType.STRING) {
								a.add(cellval.getStringCellValue()); 
							} else {
								a.add(NumberToTextConverter.toText(cellval.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return a;
	}
}
