import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import java.io.File;
import java.io.FileInputStream;

public class BindXmlToDocx {

   public static void main(String[] args) throws Exception {

        String input_DOCX = System.getProperty("user.dir") + "/binding-simple.docx";
        String input_XML = System.getProperty("user.dir") + "/myxml.xml";
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(input_DOCX));
        String OUTPUT_DOCX = System.getProperty("user.dir") + "/shi3.docx";
        FileInputStream xmlStream = new FileInputStream(new File(input_XML));
        Docx4J.bind(wordMLPackage, xmlStream, Docx4J.FLAG_BIND_INSERT_XML & Docx4J.FLAG_BIND_BIND_XML);
        Docx4J.save(wordMLPackage, new File(OUTPUT_DOCX), Docx4J.FLAG_NONE);
        System.out.println("Saved: " + OUTPUT_DOCX);
    }

}



