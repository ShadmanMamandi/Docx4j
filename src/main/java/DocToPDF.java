import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

public class DocToPDF extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Properties prop = new Properties();
        prop.load(getServletContext().getResourceAsStream("/WEB-INF/properties/test.properties"));
        String inputFile=prop.getProperty("inputfile");
        String outputFile=prop.getProperty("outputfile");
        FileInputStream in = new FileInputStream(inputFile);
        XWPFDocument document = new XWPFDocument(in);
        File outFile = new File(outputFile);
        OutputStream out = new FileOutputStream(outFile);
        PdfOptions pdfOptions = PdfOptions.create();
        pdfOptions.fontEncoding("UTF-8");
        PdfConverter.getInstance().convert(document, out, pdfOptions);

        File file = new File("/home/shiva/Downloads/MyProjects/docx4jTest/doc.pdf");
        byte[] fileData = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(fileData);
        response.reset();
        response.setContentType("application/pdf");
        response.setContentLength(fileData.length);
        response.setHeader("Content-Disposition", "inline;filename=example.pdf");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(fileData);
        outputStream.flush();
        outputStream.close();


    }
}






