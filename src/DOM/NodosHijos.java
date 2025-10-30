package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class NodosHijos {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Cargar el archivo XML
        Document document = builder.parse("libros.xml");
        document.getDocumentElement().normalize();

        //Obtener todos los nodos de "libro"
        NodeList listaLibros = document.getElementsByTagName("libro");

        //Recorrer la lista de libros
        for (int i=0;i< listaLibros.getLength();i++){
            Element libro =  (Element) listaLibros.item(i);
            System.out.println("ID: "+ libro.getAttribute("id"));

            //Recorrer los hijos del elemento <libro>
            NodeList hijos = libro.getChildNodes();

            for (int j =0; j< hijos.getLength();j++){
                Node nodoHijo =hijos.item(j);

                if(nodoHijo.getNodeType() ==Node.ELEMENT_NODE){
                    String nombre = nodoHijo.getNodeName();
                    String valor = nodoHijo.getTextContent();
                    System.out.println(nombre+" : "+ valor);
                }
            }

            System.out.println("---");
        }
    }
}