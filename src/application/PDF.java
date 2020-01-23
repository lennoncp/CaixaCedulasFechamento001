package application;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.layout.renderer.IRenderer;
import com.sun.javafx.geom.Rectangle;

public class PDF {
	
	public static String arquivo = "src/files/fechamento.pdf";
	
	public static void criarPDF() {
		  PdfDocument pdfDoc;
		try {
			pdfDoc = new PdfDocument(new PdfWriter(arquivo));
			
			  Document doc = new Document(pdfDoc);
			  
			  Table tableCab = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();
			  
			  Cell celCap;
			  Paragraph pargCap;
			  
			  celCap = new Cell();
			  celCap.setBorder(Border.NO_BORDER);
			  pargCap = new Paragraph("COLUNAS HOME CENTER").setTextAlignment(TextAlignment.LEFT);
			  pargCap.setBold();
			  pargCap.setFontColor(ColorConstants.ORANGE);
			  celCap.add(pargCap);
			  tableCab.addCell(celCap);
			  
			  celCap = new Cell();
			  celCap.setBorder(Border.NO_BORDER);
			  pargCap = new Paragraph("FECHAMENTO DE CAIXA").setTextAlignment(TextAlignment.CENTER);
			  pargCap.setBold();
			  celCap.add(pargCap);
			  tableCab.addCell(celCap);
			  
			  celCap = new Cell();
			  celCap.setBorder(Border.NO_BORDER);
			  
			  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			  Date dAtual = new Date(System.currentTimeMillis());
			  
			  pargCap = new Paragraph(sdf.format(dAtual)).setTextAlignment(TextAlignment.RIGHT);
			  pargCap.setBold();
			  celCap.add(pargCap);
			  tableCab.addCell(celCap);
			  
			 
			  
			  doc.add(tableCab);
				 
		        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();
		        table.setBorder(Border.NO_BORDER);
		        //table.al
		       /* table.setNextRenderer(new OverlappingImageTableRenderer(table, new Table.RowRange(0, 25),
		                ImageDataFactory.create("./src/test/resources/img/hero.jpg")));*/
		        Cell cell;
		       /* for (int r = 'A'; r <= 'Z'; r++) {
		            for (int c = 1; c <= 5; c++) {
		                cell = new Cell();
		                cell.setBorder(Border.NO_BORDER);
		                cell.add(new Paragraph(String.valueOf((char) r) + String.valueOf(c)));
		                table.addCell(cell);
		            }
		        }*/
		        
		        cell = new Cell();
                //cell.setBorder(Border.NO_BORDER);
                cell.add(new Paragraph("CEDULA").setTextAlignment(TextAlignment.CENTER));
                table.addCell(cell);
                
                cell = new Cell();
                //cell.setBorder(Border.NO_BORDER);
                cell.add(new Paragraph("QUANTIDADE").setTextAlignment(TextAlignment.CENTER));
                table.addCell(cell);
                
                cell = new Cell();
                //cell.setBorder(Border.NO_BORDER);
                cell.add(new Paragraph("VALOR").setTextAlignment(TextAlignment.CENTER));
                table.addCell(cell);
		        
		        int i = 0;
		        for(Cedula c: SL.cedulas) {
		        	
		        	for(int j = 0; j < 3; j++) {    	
		        		switch (i) {
						case 0:
							cell = new Cell();
			                cell.setBorder(Border.NO_BORDER);
			                cell.setBorderLeft(new SolidBorder(1));
			                cell.add(new Paragraph(c.getCedula()).setTextAlignment(TextAlignment.CENTER));
			                table.addCell(cell);
			                i = 1;
							break;
						case 1:
							cell = new Cell();
			                cell.setBorder(Border.NO_BORDER);
			                //cell.setBorderLeft(new SolidBorder(1));
			                cell.add(new Paragraph(c.getQuantidade()+"").setTextAlignment(TextAlignment.CENTER));
			                table.addCell(cell);
			                i = 2;
							break;
						case 2:
							cell = new Cell();
			                cell.setBorder(Border.NO_BORDER);
			                cell.setBorderRight(new SolidBorder(1));
			                cell.add(new Paragraph("R$ "+c.getValorTotal()+"").setTextAlignment(TextAlignment.CENTER));
			                table.addCell(cell);
			                i = 0;
							break;

						default:
							break;
						}
		        	}
		        		
		        }
		        
		        Paragraph pTotal;
		        
		        cell = new Cell();
                cell.setBorder(Border.NO_BORDER);
                cell.setBorderLeft(new SolidBorder(1));
                cell.setBorderBottom(new SolidBorder(1));
                cell.setBorderTop(new SolidBorder(1));
                cell.add(new Paragraph(" ").setTextAlignment(TextAlignment.CENTER));
                table.addCell(cell);
                
                cell = new Cell();
                cell.setBorder(Border.NO_BORDER);
                cell.setBorderBottom(new SolidBorder(1));
                cell.setBorderTop(new SolidBorder(1));
                cell.add(new Paragraph("VALOR TOTAL: ").setTextAlignment(TextAlignment.CENTER));
                table.addCell(cell);
  
                cell = new Cell();
                //cell.setBorder(Border.NO_BORDER);
                pTotal = new Paragraph(SL.valorTotal.getText()).setTextAlignment(TextAlignment.CENTER);
                pTotal.setBold();
                pTotal.setFontColor(ColorConstants.RED);
                cell.add(pTotal);
                table.addCell(cell);
		        
		        doc.add(table);
		 
		        doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}      

}
