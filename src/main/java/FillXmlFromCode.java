import org.apache.xpath.operations.String;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FillXmlFromCode {

    public static void main(String[] args) throws IOException {

        Element root=new Element("root");
        Document doc=new Document();
        Element child1=new Element("POLICY_NO");
        child1.addContent("shiva-test");
        Element child2=new Element("ISSUE_DATE");
        child2.addContent("1390/02/01");
        Element child3=new Element("AGN_TITLE");
        child3.addContent("Bimeh");
        Element child4=new Element("POLICY_END_DATE");
        child4.addContent("1399");
        Element child5=new Element("POLICY_DURATION");
        child5.addContent("shiva2");
        Element child6=new Element("INSURED_NAME");
        child6.addContent("shiva3");


        root.addContent(child1);
        root.addContent(child2);
        root.addContent(child3);
        root.addContent(child4);
        root.addContent(child5);
        root.addContent(child6);
        doc.setRootElement(root);

        XMLOutputter outter=new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        outter.output(doc, new FileWriter(new File("myxml.xml")));


    }
}
