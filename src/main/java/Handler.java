import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Handler extends DefaultHandler {
     private List<Note> noteList=new ArrayList<>();
     private Note note;
     private StringBuilder text;

    public List<Note> getNoteList() {
        return noteList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начался парсинг");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("note")){
            note=new Note();
             note.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text=new StringBuilder();
         text.append(ch, start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    TagName tagName= TagName.valueOf(qName.toUpperCase());
    switch (tagName){
        case TO:
            note.setTo(text.toString());
            break;
        case FROM:
            note.setFrom(text.toString());
            break;
        case HEADING:
            note.setHeading(text.toString());
            break;
        case BODY:
            note.setBody(text.toString());
            break;
        case NOTE:
            noteList.add(note);
            note=null;
            break;
    }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Закончился парсинг");
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("WARNING!! LINE "+e.getLineNumber()+" : "+ e.getMessage() );
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("EROR! LINE "+e.getLineNumber()+" : "+ e.getMessage() );    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("FATAL ERROR! LINE "+e.getLineNumber()+" : "+ e.getMessage() );     }

}
