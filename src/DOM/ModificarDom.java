package DOM;

import org.w3c.dom.DOMStringList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ModificarDom {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //cargar el archivo XML
        Document document = builder.parse("libros.xml");
        document.getDocumentElement().normalize();

        //Modificar el autor del libro con ID 2
        NodeList listaLibros = document.getElementsByTagName("libro");
        for(int i=0; i<listaLibros.getLength(); i++){
            Element libro = (Element) listaLibros.item(i);
            if(libro.getAttribute("id").equals("2")){
                //accedemos al libro y con id = 2, escogemos el elemento autor y la posicion 0 para cambiarña por Ana Garcia.
                //Solo lo cambia en la informacion interna, no lo vuelca.
                libro.getElementsByTagName("autor").item(0).setTextContent("Ana Garcia");
                System.out.println("Autor nuevo: "+libro.getElementsByTagName("autor").item(0).getTextContent());
                break;
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource domSource = new DOMSource(document);
        StreamResult result = new StreamResult(new File("librosModificados.txt"));
        transformer.transform(domSource, result);
        System.out.println("Modificados los datos en librosModificados.txt");


    }
}
