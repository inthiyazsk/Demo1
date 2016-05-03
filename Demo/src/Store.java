

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Store {
        public static void main(String[] args) throws Exception {
        	
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.newDocument();
                
                /* Creating Root Element */
                Element root = document.createElement("Student");
                document.appendChild(root);
                
                /* Creating First Child */
                Element child1 = document.createElement("Name");
                child1.appendChild(document.createTextNode("Joe"));
                root.appendChild(child1);
                
                /* Creating Second Child */
                Element child2 = document.createElement("Course");
                child2.appendChild(document.createTextNode("MBA"));
                root.appendChild(child2);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                
                /* Creating an XML document student.xml */
                StreamResult result = new StreamResult("D:\\student.xml");
                transformer.transform(source, result);
                
                /* Printing XML file on the console */
                StreamResult consoleResult = new StreamResult(System.out);              
                transformer.transform(source, consoleResult);
        }
}
