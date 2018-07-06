import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ConvertDocToPDF {

   public static void main(String[] args) {

        try {

            String inputFile = "shi3.docx";
            String outputFile = "shi3.pdf";
            if (args != null && args.length == 2) {
                inputFile = args[0];
                outputFile = args[1];
            }

            System.out.println("inputFile:" + inputFile + ",outputFile:" + outputFile);
            FileInputStream in = new FileInputStream(inputFile);
            XWPFDocument document = new XWPFDocument(in);
            File outFile = new File(outputFile);
            OutputStream out = new FileOutputStream(outFile);
            PdfOptions pdfOptions = PdfOptions.create();
            pdfOptions.fontEncoding("UTF-8");
            PdfConverter.getInstance().convert(document, out, pdfOptions);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
