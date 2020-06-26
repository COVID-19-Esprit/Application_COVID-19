/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.services;
import application_covid.utils.DBConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author kacem chammeli 
 */
public class PDFGenerator {
       public static void main(String[] args) {
        String FILE_NAME = "C:\\Users\\A\\Desktop\\pdftest\\SuiviMalade.pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            Paragraph p = new Paragraph();
            p.add("Welcome to our Java application Covid-19");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            Paragraph p2 = new Paragraph();
            p2.add("Below information about your state of health"); //no alignment
            document.add(p2);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);
            document.add(new Paragraph("This is my paragraph 3", f));
            document.add(Image.getInstance("C:\\Users\\A\\Desktop\\pdftest\\ImageCovid.jpg"));
            DBConnection obj_DBConnection = new DBConnection();
            Connection conn = obj_DBConnection.getConnection();
            String query = "select * from suivimalade";
            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
            while (rs.next()) {
                p3 = new Paragraph();
                p3.add(rs.getString("suivimalade"));
                document.add(p3);
            }
            document.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
