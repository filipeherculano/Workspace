package xml.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class Test2 {

	public static void main(String[] args) {
		File f = new File("exemplo.xml");
        
		SAXBuilder builder = new SAXBuilder();
		     
		Document doc;
		try {
			doc = builder.build(f);
			Element root = (Element) doc.getRootElement();
	         
			List<Element> pessoas = root.getChildren();
			             
			for (int i=0;i<pessoas.size();i++){	             
			        Element pessoa = pessoas.get(i);
			        System.out.println("Nome: " + pessoa.getChildText("nome"));
			        System.out.println("Sobrenome: " + pessoa.getChildText("sobrenome"));
			        System.out.println("Sexo: " + pessoa.getAttributeValue("sexo"));
			        System.out.println("Nota (teste1): "+pessoa.getChild("notas").getChildText("teste1"));
			        System.out.println("Nota (teste2): "+pessoa.getChild("notas").getChildText("teste2"));
			        System.out.println("Nota (prova): "+pessoa.getChild("notas").getChildText("prova"));
			        System.out.println();
			}
		


		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		             
	}

}
