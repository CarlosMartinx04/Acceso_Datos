package SAX;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SAX2 {
    public static void main(String[] args) throws Exception {
        //Crear instancia SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        //Definir el manejador de eventos (Handler)
        DefaultHandler handler = new DefaultHandler(){
            boolean esTitulo = false;
            boolean esAutor = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                if (qName.equalsIgnoreCase("libro")){
                    String id = attributes.getValue("id");
                    System.out.println("id: "+ id);
                }

                if (qName.equalsIgnoreCase("titulo")){
                    esTitulo = true;
                }
                if (qName.equalsIgnoreCase("autor")){
                    esAutor =true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equalsIgnoreCase("titulo")){
                    esTitulo = false;
                }
                if (qName.equalsIgnoreCase("autor")){
                    esAutor = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (esTitulo){
                    System.out.println("Título: "+ new String(ch,start,length) );
                }
                if (esAutor){
                    System.out.println("Autor: "+ new String(ch,start,length));
                }
            }
        };

        saxParser.parse("libros.xml", handler);

    }
}