package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class listaNodosCatalogo {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("catalogo.xml");
        document.getDocumentElement().normalize();

        NodeList listaProductos = document.getElementsByTagName("producto");

        for(int i = 0; i < listaProductos.getLength(); i++){
            Element producto = (Element) listaProductos.item(i);
            System.out.println("Codigo: "+producto.getAttribute("codigo"));
            System.out.println(
                    "Nombre: "+producto.getElementsByTagName("nombre").item(0).getTextContent()+"\n" +
                    "Precio: "+producto.getElementsByTagName("precio").item(0).getTextContent()+"\n" +
                    "Disponibilidad: "+producto.getElementsByTagName("disponibilidad").item(0).getTextContent()
            );
        }

    }
}
