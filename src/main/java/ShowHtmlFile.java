import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ShowHtmlFile extends HttpServlet {




        public void doGet(HttpServletRequest request , HttpServletResponse response)
                throws IOException, ServletException {
          /*  FileInputStream in = new FileInputStream(new File("/home/shiva/Downloads/MyProjects/docx4jTest/binding-simple.docx"));
            XWPFDocument document = new XWPFDocument(in);


            XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

            OutputStream out = new ByteArrayOutputStream();


            XHTMLConverter.getInstance().convert(document, out, options);
            String html = out.toString();
         // System.out.println(html);

        RequestDispatcher view = request.getRequestDispatcher(html);

            view.forward(request, response);*/

            RequestDispatcher view = request.getRequestDispatcher("farshid.docx.html");

            view.forward(request, response);
        }

        }
