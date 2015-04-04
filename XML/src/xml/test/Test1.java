package xml.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom2.*;
import org.jdom2.output.XMLOutputter;

public class Test1 {

	public static void main(String[] args) {
		Document doc = new Document();
        
		Element root = new Element("turma");
		         
		Element pessoa = new Element("pessoa");
		Attribute sexo = new Attribute("sexo","Masculino");
		pessoa.setAttribute(sexo);
		         
		Element nome = new Element("nome");
		nome.setText("Rodrigo");
		pessoa.addContent(nome);
		         
		Element sobrenome = new Element("sobrenome");
		sobrenome.setText("Cavalcante");
		pessoa.addContent(sobrenome);
		         
		Element notas = new Element("notas");
		pessoa.addContent(notas);
		         
		Element teste1 = new Element("teste1");
		teste1.setText("8.3");
		Element teste2 = new Element("teste2");
		teste2.setText("7.8");
		Element prova = new Element("prova");
		prova.setText("9.2");
		         
		notas.addContent(teste1);
		notas.addContent(teste2);
		notas.addContent(prova);
		         
		root.addContent(pessoa);
		         
		doc.setRootElement(root);
		         
		XMLOutputter xout = new XMLOutputter();
		try {
			OutputStream out = new FileOutputStream( new File("exemplo.xml")); 
			xout.output(doc , out);
			System.out.println("Documento criado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
