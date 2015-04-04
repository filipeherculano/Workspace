package xml.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Test3 {

	public static void main(String[] args) {
        File f = new File("exemplo.xml");
        
		SAXBuilder builder = new SAXBuilder();
		     
		Document doc;
		try {
			doc = builder.build(f);
			Element root = (Element) doc.getRootElement();
	        
			Scanner sc = new Scanner(System.in);  
			System.out.print("Digite sexo da pessoa: " );
        	String vSexo = sc.next();
        	
        	System.out.print("Digite o nome da pessoa: " );
        	String vNome = sc.next();
        	
        	System.out.print("Digite o sobrenome da pessoa: " );
        	String vSobrenome = sc.next();
        	
        	System.out.print("Digite a nota teste 1: " );
        	String vNota1 = sc.next();
        	
        	System.out.print("Digite a nota teste 2: " );
        	String vNota2 = sc.next();
        	
        	System.out.print("Digite a nota prova: " );
        	String vNota3 = sc.next();
        	
			Element pessoa = new Element("pessoa");
			Attribute sexo = new Attribute("sexo",vSexo);
			pessoa.setAttribute(sexo);
			         
			Element nome = new Element("nome");
			nome.setText(vNome);
			pessoa.addContent(nome);
			         
			Element sobrenome = new Element("sobrenome");
			sobrenome.setText(vSobrenome);
			pessoa.addContent(sobrenome);
			         
			Element notas = new Element("notas");
			pessoa.addContent(notas);
			         
			Element teste1 = new Element("teste1");
			teste1.setText(vNota1);
			Element teste2 = new Element("teste2");
			teste2.setText(vNota2);
			Element prova = new Element("prova");
			prova.setText(vNota3);
			         
			notas.addContent(teste1);
			notas.addContent(teste2);
			notas.addContent(prova);
			root.addContent(pessoa);
			
			XMLOutputter xout = new XMLOutputter();
			OutputStream out = new FileOutputStream( new File("exemplo.xml")); 
			xout.output(doc , out);
			System.out.println("Documento alterado com sucesso!");
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
