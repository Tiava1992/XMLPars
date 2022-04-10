import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParserMain {
//    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        javax.xml.parsers.SAXParser parserSax = factory.newSAXParser();
//        Handler handler = new Handler();
//        parserSax.parse(new File("notes.xml"), handler);
//
////        XMLReader reader= XMLReaderFactory.createXMLReader();
////        Handler handler=new Handler();
////        reader.setContentHandler(handler);
////        reader.parse(new InputSource("notes.xml"));
//
//        List<Note> notes = handler.getNoteList();
//
//        for(Note note:notes){
//            System.out.println(note);
//        }
//
//    }
}
