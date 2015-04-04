import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Principal {
	public static void main(String[] args) throws IOException{
		ArrayList <Aluno>alunos = new ArrayList();
		char gabarito[] = new char[20];
		File file = new File("ordenadoNota.txt");
		File file2 = new File("ordenadoNome.txt");
		
		BufferedReader in = null;
		BufferedWriter out = null;
		
		try{                                                    				//Lê e grava o gabarito correto no array.
			in = new BufferedReader(new FileReader("gabarito.txt"));
			
			int i = 0;
			String read = null;
			while((read = in.readLine()) != null){
				for(char ch : read.toCharArray()){
					gabarito[i] = ch;
					i++;
				}
			}
		}catch (IOException e){
		    System.out.println("Ocorreu um problema em: " + e);
		    e.printStackTrace();
		}
		finally{
			if(in != null){
				in.close();
			}
		}
		
		
		try {
		    in = new BufferedReader(new FileReader("listaAlunos.txt"));
		    String read = null;
		    while ((read = in.readLine()) != null) {
		    	int i = 0;
		        String[] splited = read.split("\t");							//Dividindo a linha lida em duas strings, a primeira [0] referente ao gabarito e a segunda [1] referente ao nome.
		        Aluno a = new Aluno(splited[1]);								//Criando o objeto Aluno com a string [1]
		        for(char ch : splited[0].toCharArray()){						//Separando a primeira string de gabarito em vários caracteres e registrando no vetor dentro do objeto.
		        	a.setGabarito(i, ch);
		        	i++;
		        }
		        alunos.add(a);   
		    }
		} catch (IOException e) {
		    System.out.println("Ocorreu um problema em: " + e);
		    e.printStackTrace();
		} finally {
			if(in != null){
				in.close();
			}
		}
		
		for(Aluno a : alunos){													//Verificando e instanciando gabaritos de todos os alunos registrados.
			double count = 0.0;
			if(a != null){
				for(int i = 0; i < 20; i++){
					if(gabarito[i] == a.getGabarito(i)){
						count += 0.5;
					}
				}
				a.setNota(count);
			}
		}
		
		if(file.exists()){														//Verifica se existe o arquivo criado, pois para não dar append de novo ele recria o file.
			file.delete();
		}
		double nota = 10.0;
		do{
			for(int i = 0; i < alunos.size(); i++){
				if(nota == alunos.get(i).getNota()){
					try{
						out = new BufferedWriter(new FileWriter("ordenadoNota.txt", true));
						out.write(alunos.get(i).getNota()+"\t-------------------------------------->\t"+alunos.get(i).getNome());
						out.newLine();
					} catch (IOException e){
					    System.out.println("Ocorreu um problema em: " + e);
					    e.printStackTrace();
					} finally{
						if(out != null){
							out.close();
						}
					}
				}
			}
			nota -= 0.5;
		}while(nota >= 0.0);
		
		
		if(file2.exists()){
			file2.delete();
		}
		
		String strings[] = new String[alunos.size()];								//Ordenado alfabeticamente.
		for(int i = 0; i < alunos.size(); i++){
			strings[i] = alunos.get(i).getNome();
		}
		
		Arrays.sort(strings);
		
		for(int i = 0; i < alunos.size(); i++){
			for(int j = 0; j < alunos.size(); j++){
				if(strings[i].equals(alunos.get(j).getNome())){
					try{
						out = new BufferedWriter(new FileWriter("ordenadoNome.txt", true));
						out.write(alunos.get(j).getNome()+"-------------------------------------->"+alunos.get(j).getNota());
						out.newLine();
					} catch(IOException e){
					    System.out.println("Ocorreu um problema em: " + e);
					    e.printStackTrace();
					} finally {
						if(out != null){
							out.close();
						}
					}
				}
			}
		}
	}
}
