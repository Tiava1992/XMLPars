import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartDOM {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("notes.xml");
        // Список для сотрудников из XML файла
        ArrayList<Note> notes = new ArrayList<>();

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File("notes.xml"));
        // Получение списка всех элементов note внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList noteElements = document.getDocumentElement().getElementsByTagName("note");

        // Перебор всех элементов note
        for (int i = 0; i < noteElements.getLength(); i++) {
            Note note=new Note();
            Element noteElement = (Element) noteElements.item(i);

            // Получение атрибуты каждого элемента
            NamedNodeMap attributes = noteElement.getAttributes();

            // Добавление сотрудника. Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
            note.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
            note.setTo(getSingleChild(noteElement, "to").getTextContent().trim());
            note.setFrom(getSingleChild(noteElement, "from").getTextContent().trim());
            note.setHeading(getSingleChild(noteElement, "heading").getTextContent().trim());
            note.setBody(getSingleChild(noteElement, "body").getTextContent().trim());

            notes.add(note);
            System.out.println(note);
        }
    }

    private static Element getSingleChild (Element element, String childName){
        NodeList nlist= element.getElementsByTagName(childName);
        Element child=(Element) nlist.item(0);
        return child;
    }
}
