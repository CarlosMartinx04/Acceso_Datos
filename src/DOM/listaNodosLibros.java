package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class listaNodosLibros {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //cargar el archivo XML
        Document document = builder.parse("libros.xml");
        document.getDocumentElement().normalize();

        //obtener todos los nodos de "libro"
        NodeList listaLibros = document.getElementsByTagName("libro");

        //Recorrer la lista de libros
        for(int i = 0; i< listaLibros.getLength(); i++){
            //Creamos un elemento para acceder a sus atributos
            Element libro = (Element) listaLibros.item(i);
            System.out.println("ID: "+libro.getAttribute("id"));
            System.out.println("Titulo: "+libro.getElementsByTagName("titulo").item(0).getTextContent());
            System.out.println("Autor: "+libro.getElementsByTagName("autor").item(0).getTextContent());

        }
    }
}
