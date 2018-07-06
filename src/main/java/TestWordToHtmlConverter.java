
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;



public class TestWordToHtmlConverter {




  /* private File docFile;
    private File file;

    public TestWordToHtmlConverter(File docFile) {
        this.docFile = docFile;
    }

    public void convert(File file) {
        this.file = file;

        try {
            FileInputStream finStream=new FileInputStream(docFile.getAbsolutePath());
          // XSSFWorkbook doc = new XSSFWorkbook(finStream);
           // HWPFDocument doc=new HWPFDocument(finStream);
            XWPFDocument doc=new XWPFDocument(finStream);
           // XSSFWorkbook doc = new XSSFWorkbook(new File("file.docx"));
        //    WordExtractor wordExtract=new WordExtractor(doc);
            XWPFWordExtractor wordExtract=new XWPFWordExtractor(doc);
            Document newDocument = DocumentBuilderFactory.newInstance() .newDocumentBuilder().newDocument();
           WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(newDocument) ;
            wordToHtmlConverter.processDocument(doc);


            StringWriter stringWriter = new StringWriter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.transform(new DOMSource( wordToHtmlConverter.getDocument()), new StreamResult( stringWriter ) );

            String html = stringWriter.toString();
            FileOutputStream fos=new FileOutputStream(new File("sample.html"));


            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
                out.write(html);
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

           /*JEditorPane editorPane = new JEditorPane();
           editorPane.setContentType("text/html");
           editorPane.setEditable(false);

           editorPane.setPage(file.toURI().toURL());

           JScrollPane scrollPane = new JScrollPane(editorPane);
           JFrame f = new JFrame("Display Html File");
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           f.getContentPane().add(scrollPane);
           f.setSize(512, 342);
           f.setVisible(true);*/

      /*  } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        TestWordToHtmlConverter TTC=new TestWordToHtmlConverter(new File("code.docx"));
        TTC.convert(TTC.docFile);
    }*/

    public static void main(String[] args) {
       // String docPath = "xxx.doc";
        String docxPath = "code.docx";

     //   convertDoc(docPath);

        convertDocx(docxPath);
    }


    static void convertDocx(String path) {
     /*   try {
            //convert .docx to HTML string
            InputStream in = new FileInputStream(new File(path));
            XWPFDocument document = new XWPFDocument(in);

            XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

            OutputStream out = new ByteArrayOutputStream();

            XHTMLConverter.getInstance().convert(document, out, options);
            String html = out.toString();
            System.out.println(html);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try
        {
            //convert .docx to HTML string
            InputStream in= new FileInputStream(new File(path));
            XWPFDocument document = new XWPFDocument(in);


            XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

            OutputStream out = new ByteArrayOutputStream();


            XHTMLConverter.getInstance().convert(document, out, options);
            String html=out.toString();
            System.out.println(html);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    }


