import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class HandlerTwo extends DefaultHandler {
    private List<Note> noteList=new ArrayList<>();
    private Note note;
    private String currentTagName;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начался парсинг");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Закончился парсинг");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName= qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentTagName=null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
     //   System.out.println("Characters "+ new String(ch, start, length));
        if(currentTagName.equals("note")){
            note=new Note();
          //  note.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }
}
