package edu.javavt16.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.javavt16.model.CarBrand;
import edu.javavt16.model.CarModel;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBuilder extends AbstractPOIExcelView {
    @Override
    protected XSSFWorkbook createWorkbook() {
        return new XSSFWorkbook();
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, XSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get data model which is passed by the Spring container
        List<CarBrand> carBrands = (List<CarBrand>) model.get("carBrands");
        List<CarModel> carModels = (List<CarModel>) model.get("carModels");

        generateBrandSheet(workbook, carBrands);
        generateModelsSheet(workbook, carModels);
    }

    private void generateBrandSheet(XSSFWorkbook workbook, List<CarBrand> carBrands){

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Brands");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,5000);
        sheet.setColumnWidth(2,3000);
        sheet.setColumnWidth(3,10000);
        sheet.setColumnWidth(4,10000);
        sheet.setColumnWidth(5,10000);

        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName("Helvetica");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.getCell(0).setCellStyle(headerStyle);

        headerRow.createCell(1).setCellValue("Game name");
        headerRow.getCell(1).setCellStyle(headerStyle);

        headerRow.createCell(2).setCellValue("Founded year");
        headerRow.getCell(2).setCellStyle(headerStyle);

        headerRow.createCell(3).setCellValue("Jenre");
        headerRow.getCell(3).setCellStyle(headerStyle);

        headerRow.createCell(4).setCellValue("Developer");
        headerRow.getCell(4).setCellStyle(headerStyle);

        headerRow.createCell(5).setCellValue("platforms");
        headerRow.getCell(5).setCellStyle(headerStyle);

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // create data rows
        int rowCount = 1;
        for (CarBrand carBrand : carBrands) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(rowCount-1);
            row.getCell(0).setCellStyle(rowCellStyle);

            row.createCell(1).setCellValue(carBrand.getName());
            row.getCell(1).setCellStyle(rowCellStyle);

            row.createCell(2).setCellValue(carBrand.getFond_year());
            row.getCell(2).setCellStyle(rowCellStyle);

            row.createCell(3).setCellValue(carBrand.getJenre());
            row.getCell(3).setCellStyle(rowCellStyle);

            row.createCell(4).setCellValue(carBrand.getDeveloper());
            row.getCell(4).setCellStyle(rowCellStyle);

            row.createCell(5).setCellValue(carBrand.getPlatforms());
            row.getCell(5).setCellStyle(rowCellStyle);
        }
    }

    private void generateModelsSheet(XSSFWorkbook workbook, List<CarModel> carModels){

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Models");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,5000);
        sheet.setColumnWidth(2,5000);
        sheet.setColumnWidth(3,7000);
        sheet.setColumnWidth(4,2500);
        sheet.setColumnWidth(5,2000);
        sheet.setColumnWidth(6,2000);

        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName("Helvetica");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.getCell(0).setCellStyle(headerStyle);

        headerRow.createCell(1).setCellValue("Brand");
        headerRow.getCell(1).setCellStyle(headerStyle);

        headerRow.createCell(2).setCellValue("Os");
        headerRow.getCell(2).setCellStyle(headerStyle);

        headerRow.createCell(3).setCellValue("Processor");
        headerRow.getCell(3).setCellStyle(headerStyle);

        headerRow.createCell(4).setCellValue("RAM");
        headerRow.getCell(4).setCellStyle(headerStyle);

        headerRow.createCell(5).setCellValue("HDD");
        headerRow.getCell(5).setCellStyle(headerStyle);

        headerRow.createCell(6).setCellValue("Video card");
        headerRow.getCell(6).setCellStyle(headerStyle);


        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // create data rows
        int rowCount = 1;
        for (CarModel carModel : carModels) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(rowCount-1);
            row.getCell(0).setCellStyle(rowCellStyle);

            row.createCell(1).setCellValue(carModel.getCarBrand().getName());
            row.getCell(1).setCellStyle(rowCellStyle);

            row.createCell(2).setCellValue(carModel.getOs());
            row.getCell(2).setCellStyle(rowCellStyle);

            row.createCell(3).setCellValue(carModel.getProcessor());
            row.getCell(3).setCellStyle(rowCellStyle);

            row.createCell(4).setCellValue(carModel.getRam());
            row.getCell(4).setCellStyle(rowCellStyle);

            row.createCell(5).setCellValue(carModel.getHdd());
            row.getCell(5).setCellStyle(rowCellStyle);

            row.createCell(6).setCellValue(carModel.getVideo_card());
            row.getCell(6).setCellStyle(rowCellStyle);

        }
    }

}