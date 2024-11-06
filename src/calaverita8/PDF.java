package calaverita8;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.BaseColor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF {

    public void crearPDF() {
        try {
            Document documento = new Document();
            String destino = "Calaverita.pdf"; 
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(destino));
            documento.open();

            PdfContentByte fondos = writer.getDirectContentUnder();
            Rectangle pagina1 = new Rectangle(documento.getPageSize());
            pagina1.setBackgroundColor(new BaseColor(240, 218, 195)); 
            fondos.rectangle(pagina1);

            Font tituloFuente = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.BOLD, new BaseColor(17,112,78));
            Paragraph titulo = new Paragraph("Calaverita Literaria", tituloFuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Image imagen = Image.getInstance(getClass().getResource("/imagen/calaverita.jpg"));
            imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(imagen);

            Font textFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);
            Paragraph finalText = new Paragraph("Dania Ximena Lozano Nájera", textFont);
            finalText.setAlignment(Element.ALIGN_CENTER);
            documento.add(finalText);

            documento.newPage();

            pagina1.setBackgroundColor(new BaseColor(234, 230, 192)); 
            fondos.rectangle(pagina1);

            Paragraph secondPageTitle = new Paragraph("Calaverita", tituloFuente);
            secondPageTitle.setAlignment(Element.ALIGN_CENTER);
            documento.add(secondPageTitle);
            
            Image imagen2 = Image.getInstance(getClass().getResource("/imagen/ilustracion.jpg")); 
            imagen2.setAlignment(Element.ALIGN_CENTER);
            documento.add(imagen2);
            
            Paragraph texto = new Paragraph("""
                            Diego en su patineta,
                            veloz iba a rodar,
                            esquivando a la calaca
                            que lo queria llevar.
                          
                            Diego, deja ya de deslizar,
                            que este viaje es sin regreso!
                            Ven conmigo a descansar!.
                          
                            Pero Diego, muy tranquilo,
                            con una sonrisa y gran valor,
                            le dijo: No tengas prisa,
                            yo de aqui no me voy.
                          
                            Asi siguio su dia,
                            entre clases y el patinar,
                            y la Catrina, frustrada,
                            no lo pudo atrapar.""", textFont);
            texto.setAlignment(Element.ALIGN_CENTER);
            documento.add(texto);

            documento.close();
            
            File abrir = new File(destino);
            if (abrir.exists()) {
                Desktop.getDesktop().open(abrir);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        PDF pdf = new PDF();
        pdf.crearPDF();
    }
}
