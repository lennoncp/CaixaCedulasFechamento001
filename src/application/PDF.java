package application;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

public class PDF {
	
	public static String arquivo = "src/files/fechamento.pdf";
	
	public static void criarPDF() {
		  PdfDocument pdfDoc;
		try {
			pdfDoc = new PdfDocument(new PdfWriter(arquivo));
			
			  Document doc = new Document(pdfDoc);
			  
			  Table tableCab = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
			  
			  Cell cColuna = new Cell();
			  cColuna.setBorder(Border.NO_BORDER);
			  cColuna.add(new Paragraph("Colunas").setTextAlignment(TextAlignment.LEFT));
			  tableCab.addCell(cColuna);
			  
			  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			  Date date = new Date();
			    
			  Cell chora = new Cell();
			  chora.setBorder(Border.NO_BORDER);
			  chora.add(new Paragraph(dateFormat.format(date)).setTextAlignment(TextAlignment.RIGHT));
			  tableCab.addCell(chora);
			  
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
		        
		        int i = 0;
		        for(Cedula c: SL.cedulas) {
		        	
		        	for(int j = 0; j < 3; j++) {    	
		        		switch (i) {
						case 0:
							cell = new Cell();
			                cell.setBorder(Border.NO_BORDER);
			                cell.add(new Paragraph(c.getCedula()));
			                table.addCell(cell);
			                i = 1;
							break;
						case 1:
							cell = new Cell();
			                cell.setBorder(Border.NO_BORDER);
			                cell.add(new Paragraph(c.getQuantidade()+""));
			                table.addCell(cell);
			                i = 2;
							break;
						case 2:
							cell = new Cell();
			                cell.setBorder(Border.NO_BORDER);
			                cell.add(new Paragraph(c.getValorTotal()+""));
			                table.addCell(cell);
			                i = 0;
							break;

						default:
							break;
						}
		        	}
		        	
		        	
		        	
		        }
		        
		        doc.add(table);
		 
		        doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}      

}