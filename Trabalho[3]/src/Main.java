import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r;
		do{
			System.out.println("O que você deseja?");
			System.out.println("1.Cadastrar um novo currículo.");
			System.out.println("2.Editar currículo.");
			System.out.println("-.Mostrar relatórios:");
			System.out.println("3.---Pessoas que estudaram na instituição (...)");
			System.out.println("4.---Mulheres que fizeram/estão fazendo mestrado no Brasil.");
			System.out.println("5.---Homens que fizeram doutorado no exterior.");
			System.out.println("6.Salvar seu currículo.");
			System.out.println("7.Sair.");
			r = sc.nextInt();
			switch(r){
				case 1:
					cadastraCurriculo();
					break;
				case 2:
					String op2;
					System.out.println("Digite uma id.");
					op2 = sc.next();
					editarCurriculo(op2);
					break;
				case 3:
					String ies;
					System.out.print("Digite o nome de uma ies.");
					ies = sc.next().toUpperCase();
					showRelatorio(ies);
					break;
				case 4:
					showRelatorio("Feminino","Brasil");
					break;
				case 5:
					showRelatorio("Masculino","Brasil", "doutorado");
					break;
				case 6:
					String op;
					System.out.println("Digite seu id.");
					op = sc.next();
					imprimirRelatorio(op);
					break;
				case 7:
					System.out.println("Fim do programa.");
					break;
				default:
					System.out.println("Você digitou uma opção inválida.");
					
			}
		}while(r != 7);
	}

	private static void cadastraCurriculo() {
		Scanner sc = new Scanner(System.in);
		String index, age, name, sex,Ini[] = new String[3], Fim[] = new String[3], iesGrad[] = new String[3], 
				pais[] = new String[3], course[] = new String[3], tipo[] = {"graduação","mestrado","doutorado"};

		System.out.print("Digite seu nome:");
			name = sc.nextLine();
		System.out.print("Digite sua idade:");
			age = sc.nextLine();
		
		do{
			System.out.print("Digite seu sexo(Masculino ou Feminino):");
				sex = sc.nextLine();
		}while(!(sex.equals("Masculino") || sex.equals("Feminino")));
		
		for(int i = 0; i < 3; i++){
			System.out.print("Nome da IES que fez "+tipo[i]+":");
				iesGrad[i] = sc.nextLine().toUpperCase();
			System.out.print("País localizado:");
				pais[i] = sc.nextLine();
			System.out.print("Nome do curso:");
				course[i] = sc.nextLine();
			System.out.print("Ano de entrada:");
				Ini[i] = sc.nextLine();
			System.out.print("Ano de saída:");
				Fim[i] = sc.nextLine();
		}
		
		File file = new File("curriculo.xml");
		Element root = null, pessoa = null;
		Document newDocument = null;
		
		if(!file.exists()){
			root = new Element("cv");
			
			newDocument = new Document(root);
			
			index = "1";
		}else{
			SAXBuilder builder = new SAXBuilder();
			
			try {
				newDocument = builder.build(file);
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			root = newDocument.getRootElement();
			int aux = root.getChildren().size()+1;
			index = String.valueOf(aux);
		}
		
		pessoa = new Element("pessoa");
		Attribute id = new Attribute("id", index);
		pessoa.setAttribute(id);
		
		
		Element dadosPessoais = new Element("dadosPessoais");
		
		Element nome = new Element("nome");
		nome.setText(name);
		
		Element sexo = new Element("sexo");
		sexo.setText(sex);
		
		Element idade = new Element("idade");
		idade.setText(age);
		
		dadosPessoais.addContent(nome);
		dadosPessoais.addContent(sexo);
		dadosPessoais.addContent(idade);
		
		Element formação = new Element("formação");
		
		Element instituição[] = new Element[3];
		Attribute iesName, iesCountry;
		for(int i = 0; i < 3; i++){
			if ((i == 1) && (iesGrad[0].equals(iesGrad[1]))){
				continue;
			}else{
				if ((i == 2) && (iesGrad[0].equals(iesGrad[2]) || iesGrad[1].equals(iesGrad[2]))){
					continue;
				}
			}
			instituição[i] = new Element("instituição");
			iesName = new Attribute("nome", iesGrad[i]);
			iesCountry = new Attribute("país", pais[i]);
			instituição[i].setAttribute(iesName);
			instituição[i].setAttribute(iesCountry);
		}
		
		Element curso;
		Attribute anoIni, anoFim, nivel;
		for(int i = 0; i < 3; i++){
			curso = new Element("curso");
			nivel = new Attribute("nível", tipo[i]);
			anoIni = new Attribute("anoIni", Ini[i]);
			anoFim = new Attribute("anoFim", Fim[i]);
			curso.setAttribute(anoIni);
			curso.setAttribute(anoFim);
			curso.setAttribute(nivel);
			curso.setText(course[i]);
			for(int j = 0; j < 3; j++){
				if(instituição[j] != null){
					if(instituição[j].getAttributeValue("nome").equals(iesGrad[i])){
						instituição[j].addContent(curso);
					}
				}
			}
		}
		
		for(int i = 0; i < 3; i++){
			if(instituição[i] != null){
				formação.addContent(instituição[i]);
			}
		}
		
		pessoa.addContent(dadosPessoais);
		pessoa.addContent(formação);
		
		root.addContent(pessoa);
		
		XMLOutputter xout = new XMLOutputter();
		try{
			FileWriter arquivo = new FileWriter(new File("curriculo.xml"));
			xout.output(newDocument, arquivo);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void editarCurriculo(String id){
		int option = 0;
		
		File file = new File("curriculo.xml");
		
		SAXBuilder builder = new SAXBuilder();
		
		Document newDocument = null;
		
		try {
			newDocument = builder.build(file);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root = newDocument.getRootElement();
		
		
		do{
			List<Element> listPessoas = root.getChildren();
			for(Element a : listPessoas){
				if(a.getAttributeValue("id").equals(id)){
					Scanner sc = new Scanner(System.in);
					System.out.println("O que deseja fazer?");
					System.out.println("<1> Adicionar nova formação.");
					System.out.println("<2> Adicionar novo curso à uma formação existente.");
					System.out.println("<3> Sair.");
					option = sc.nextInt();
					switch(option){
						case 1:
							
							break;
						case 2:
							break;
						case 3:
							System.out.println("Saindo.");
							break;
						default:
							System.out.println("Comando não cadastrado.");
					}	
				}
			}
		}while(option != 3);
	}
	
	private static void showRelatorio(String ies){
		String nome, sexo, curso;
		boolean noPerson = true;
		
		File file = new File("curriculo.xml");
	
		Document newDocument = null;
		
		SAXBuilder builder = new SAXBuilder();
		
		try {
			newDocument = builder.build(file);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element root = newDocument.getRootElement();
		
		List<Element> listPessoas = root.getChildren();
		for(Element e : listPessoas){
			List<Element> listInstituição = e.getChild("formação").getChildren();
			for(Element a : listInstituição){
				if(a.getAttributeValue("nome").equals(ies)){
					noPerson = false;
					nome = a.getParentElement().getParentElement().getChild("dadosPessoais").getChild("nome").getText();
					sexo = a.getParentElement().getParentElement().getChild("dadosPessoais").getChild("sexo").getText();
					
					System.out.println("A Pessoa chamada "+nome+" do sexo "+sexo+" estudou o(s) curso(s) de:");
					
					List<Element> listCurso = a.getChildren();
					for(Element b : listCurso){
						curso = b.getText();
						System.out.println("-"+curso);
					}
					System.out.println("na "+ies+"\n");
				}
			}
		}
		
		if(noPerson){
			System.out.println("Ninguém cursou esta faculdade!\n");
		}
		
	}
	
	private static void showRelatorio(String sexo, String pais){
		boolean noPerson = true;
		File file = new File("curriculo.xml");
		
		SAXBuilder builder = new SAXBuilder();
		
		Document newDocument = null;
		
		try {
			newDocument = builder.build(file);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root = newDocument.getRootElement();
		List<Element> listPessoas = root.getChildren();	
		for(Element a : listPessoas){	
			if(a.getChild("dadosPessoais").getChild("sexo").getText().equals(sexo)){
				List<Element> listInstituição = a.getChild("formação").getChildren();
				for(Element b : listInstituição){
					List<Element> listCurso = b.getChildren();
					for(Element c : listCurso){
						if(c.getAttributeValue("nível").equals("mestrado") && b.getAttributeValue("país").equals(pais)){
							noPerson = false;
							System.out.println("A "+a.getChild("dadosPessoais").getChild("nome").getText()+" fez seu mestrado em "+c.getText()+" na faculdade "+b.getAttributeValue("nome")+" no Brasil.\n");
						}
					}
				}
			}
		}
		
		if(noPerson){
			System.out.println("Ninguém cadastrado possui as características procuradas.\n");
		}
	}
	
	private static void showRelatorio(String sexo, String pais, String nivel){
		String nome, idade, ies, curso, fim;
		boolean noPerson = true;
		
		File file = new File("curriculo.xml");
		
		SAXBuilder builder = new SAXBuilder();
		
		Document newDocument = null;
		
		try {
			newDocument = builder.build(file);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root = newDocument.getRootElement();
		
		List<Element> listPessoas = root.getChildren();
		for(Element a : listPessoas){
			if(a.getChild("dadosPessoais").getChild("sexo").getText().equals(sexo)){
				List<Element> listInstituição = a.getChild("formação").getChildren();
				for(Element b : listInstituição){
					List<Element> listCurso = b.getChildren();
					for(Element c : listCurso){
						if(c.getAttributeValue("nível").equals(nivel) && !b.getAttributeValue("país").equals(pais)){
							nome = a.getChild("dadosPessoais").getChild("nome").getText();
							idade = a.getChild("dadosPessoais").getChild("idade").getText();
							ies = b.getAttributeValue("nome");
							fim = c.getAttributeValue("anoFim");
							curso = c.getText();
							noPerson = false;
							System.out.println("A pessoa chamada "+nome+" de "+idade+" anos estudou na "+ies+", concluiu o curso de "+curso+" no ano de "+fim+" no exterior.\n");
						}
					}
				}
			}
		}
		
		if(noPerson){
			System.out.println("Ninguém cadastrado possui essas caracteristicas.");
		}
	}
	
	private static void imprimirRelatorio(String option){
		String nome = null, sexo = null, idade = null, curso[] = new String[3], ini[] = new String[3], fim[] = new String[3],
				ies[] = new String[3], pais[] = new String[3], nivel[] = new String[3];
		
		File file = new File("curriculo.xml");
		
		Document newDocument = null;
		
		SAXBuilder builder = new SAXBuilder();
		
		try {
			newDocument = builder.build(file);
		} catch (JDOMException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element root = newDocument.getRootElement();
		
		List<Element> list = root.getChildren();
		for(Element e : list){
			if(e.getAttributeValue("id").equals(option)){
				nome = e.getChild("dadosPessoais").getChild("nome").getText();
				sexo = e.getChild("dadosPessoais").getChild("sexo").getText();
				idade = e.getChild("dadosPessoais").getChild("idade").getText();
				
				int k = 0;
				do{
					List<Element> listInstituição = e.getChild("formação").getChildren();
					for(Element a : listInstituição){
						List<Element> listCurso = a.getChildren();
						for(Element b : listCurso){
							ies[k] = b.getParentElement().getAttributeValue("nome");
							pais[k] = b.getParentElement().getAttributeValue("país");
							ini[k] = b.getAttributeValue("anoIni");
							fim[k] = b.getAttributeValue("anoFim");
							nivel[k] = b.getAttributeValue("nível");
							curso[k] = b.getText();
							k++;
						}
					}
				}while(k < 2);
			}
		}
		
		BufferedWriter out = null;
		
		String s =  "Nome: "+nome+"\n"+
					"Sexo: "+sexo+"\n"+
					"Idade: "+idade+"\n\n"+
					"Graduação: "+ies[0]+"("+pais[0]+")\n"+
					"Curso: "+curso[0]+"\n"+
					"Início: "+ini[0]+"\n"+
					"Fim: "+fim[0]+"\n\n"+
					"Mestrado: "+ies[1]+"("+pais[1]+")\n"+
					"Curso: "+curso[1]+"\n"+
					"Início: "+ini[1]+"\n"+
					"Fim: "+fim[1]+"\n\n"+
					"Doutorado: "+ies[2]+"("+pais[2]+")\n"+
					"Curso: "+curso[2]+"\n"+
					"Início: "+ini[2]+"\n"+
					"Fim: "+fim[2];
		
		try {
			out = new BufferedWriter(new FileWriter("cv_"+option+".txt"));
			out.write(s);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("Currículo salvo como cv_"+option+".txt\n");
		}
		
	}
}