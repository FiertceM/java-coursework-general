package edu.javavt16.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.javavt16.model.CarBrand;
import edu.javavt16.model.CarModel;

public class PDFBuilder extends AbstractTextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        // get data model which is passed by the Spring container
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        paragraphFont.setSize(14);

        List<CarBrand> carBrands = (List<CarBrand>) model.get("carBrands");
        Paragraph brandParagraph = new Paragraph("Car brands",paragraphFont);
        brandParagraph.setAlignment(Element.ALIGN_CENTER);
        doc.add(brandParagraph);
        PdfPTable carBrandsTable = getCarBrandTable(carBrands);
        doc.add(carBrandsTable);

        List<CarModel> carModels = (List<CarModel>) model.get("carModels");
        Paragraph modelParagraph = new Paragraph("Car models",paragraphFont);
        modelParagraph.setAlignment(Element.ALIGN_CENTER);
        doc.add(modelParagraph);
        PdfPTable carModelsTable = getCarModelTable(carModels);
        doc.add(carModelsTable);
    }


    private PdfPTable getCarBrandTable(List<CarBrand> carBrands) throws Exception {

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 2.0f, 1.0f, 4.0f, 4.0f,4.0f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("#", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Game name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Founded year", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Jenre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Developer", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Platforms", font));
        table.addCell(cell);

        // write table row data
        int index = 1;
        for (CarBrand carBrand : carBrands) {
            table.addCell("" + index);
            table.addCell(carBrand.getName());
            table.addCell("" + carBrand.getFond_year());
            table.addCell(carBrand.getJenre());
            table.addCell(carBrand.getDeveloper());
            table.addCell(carBrand.getPlatforms());
            index++;
        }
        return table;
    }

    private PdfPTable getCarModelTable(List<CarModel> carModels) throws Exception {

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 1.5f, 1.5f, 2.0f, 0.7f, 0.7f, 0.7f});
        table.setSpacingBefore(5);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("#", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Game", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("OS", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Processor", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("RAM", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("HDD", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Video card", font));
        table.addCell(cell);

        int index = 1;
        // write table row data
        for (CarModel carModel : carModels) {
            table.addCell("" + index);
            table.addCell(carModel.getCarBrand().getName());
            table.addCell(carModel.getOs());
            table.addCell(carModel.getProcessor());
            table.addCell("" + carModel.getRam());
            table.addCell("" + carModel.getHdd());
            table.addCell("" + carModel.getVideo_card());
            index++;
        }
        return table;
    }
}