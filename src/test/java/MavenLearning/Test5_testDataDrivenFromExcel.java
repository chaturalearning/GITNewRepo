package MavenLearning;

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

public class Test5_testDataDrivenFromExcel {

	public ArrayList<String> getData(String TestCase1) throws IOException {

		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\v-chatve\\Desktop\\CHATURA\\Testexcel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator(); // this sheet is collection of rows in excel
				Row firstrow = rows.next();
				Iterator<Cell> cel = firstrow.cellIterator(); // row is collection of cells
				int k = 0;
				int column = 0;
				while (cel.hasNext()) {
					Cell value = cel.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testdata")) {

						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("login id")) {

						Iterator<Cell> celvalue = r.cellIterator();

						while (celvalue.hasNext()) {
							Cell cv = celvalue.next();

							if (cv.getCellType() == CellType.STRING) {
								a.add(cv.getStringCellValue());
							} else if (cv.getCellType() == CellType.NUMERIC) {

								System.out.println(cv.getNumericCellValue());
							} else {
								a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
							}
						}
					}

				}
			}
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		// using Apache POI & POI OOXML we used to drive test data from excel(external
		// source)

	}

}