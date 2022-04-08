import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartDOM {
    public static void main(String[] args) {
        File file = new File("notes.xml");

        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        Document doc=null;

        try {
            doc=dbf.newDocumentBuilder().parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        Node rootNode=doc.getFirstChild();
        System.out.println(rootNode.getNodeName());
        NodeList rootChilds=rootNode.getChildNodes();


        List<Note> notes=new ArrayList<>();
        String mainName=null;
        for(int i=0; i<rootChilds.getLength(); i++){
            if(rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE){  // убираем пробелы (пустые места)
                continue;
            }
            System.out.println(rootChilds.item(i).getNodeName());
            Note note=new Note();
            Element noteElement= (Element) note.NO

        }
    }
}
