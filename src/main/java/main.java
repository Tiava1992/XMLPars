import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        HandlerTwo handler = new HandlerTwo();
        SAXParser parser = null;
        File file = new File("notes.xml");

        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            System.out.println("Open SAXParser ERROR!");
        }

        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("ERRRROOOOOORRRRR");



        }
    }
}
