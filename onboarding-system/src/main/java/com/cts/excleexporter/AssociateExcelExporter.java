package com.cts.excleexporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cts.entity.Associates;

public class AssociateExcelExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Associates> listAssociates;

	public AssociateExcelExporter(List<Associates> listAssociates) {
		this.listAssociates = listAssociates;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Associates");
	}

	private void writeHeaderLine() {

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		Row row = sheet.createRow(0);

        
		createCell(row, 0, "soId", style);
		createCell(row, 1, "poc", style);
		createCell(row, 2, "program_name", style);
		createCell(row, 3, "winZone_id", style);
		createCell(row, 4, "beeline_req_id", style);
		createCell(row, 5, "grade", style);
		createCell(row, 6, "sostatus", style);
		createCell(row, 7, "isCritical", style);
		createCell(row, 8, "pe_so", style);
		createCell(row, 9, "location", style);
		createCell(row, 10, "primaryskills", style);
		createCell(row, 11, "secndary_skills", style);
		createCell(row, 12, "project_id", style);
		createCell(row, 13, "project_name", style);
		createCell(row, 14, "esa_pm", style);
		createCell(row, 15, "comments", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);                 
		for (Associates associates : listAssociates) {
			Row row = sheet.createRow(rowCount++);

	
			Cell cell = row.createCell(0);
			cell.setCellValue(associates.getSoId());
		

			Cell cell1 = row.createCell(1);
			cell1.setCellValue(associates.getPoc());

			Cell cell2 = row.createCell(2);
			cell2.setCellValue(associates.getProgramName());

			Cell cell3 = row.createCell(3);
			cell3.setCellValue(associates.getWinZoneId());

			Cell cell4 = row.createCell(4);
			cell4.setCellValue(associates.getBeelineReqId());

			Cell cell5 = row.createCell(5);
			cell5.setCellValue(associates.getGrade());

			Cell cell6 = row.createCell(6);
			cell6.setCellValue(associates.getSoStatus());

			Cell cell7 = row.createCell(7);
			cell7.setCellValue(associates.getIsCritical());

			Cell cell8 = row.createCell(8);
			cell8.setCellValue(associates.getPeSo());

			Cell cell9 = row.createCell(9);
			cell9.setCellValue(associates.getLocation());

			Cell cell10 = row.createCell(10);
			cell10.setCellValue(associates.getPrimarySkills());

			Cell cell11 = row.createCell(11);
			cell11.setCellValue(associates.getSecndarySkills());

			Cell cell12 = row.createCell(12);
			cell12.setCellValue(associates.getProjectId());

			Cell cell13 = row.createCell(13);
			cell13.setCellValue(associates.getProjectName());

			Cell cell14 = row.createCell(14);
			cell14.setCellValue(associates.getEsaPm());

			Cell cell15 = row.createCell(15);
			cell15.setCellValue(associates.getComments());
          

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
