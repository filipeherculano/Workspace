import java.util.ArrayList;
import java.util.Collections;

public class Disciplina {
	private int codigo;
	private String nome;
	private Aluno []alunos;
	private int indice = 0;
	
	public Disciplina(int codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
		alunos = new Aluno[40];
	}
	
	public boolean matriculaAluno(Aluno a){
		if(this.indice <= 40){
			alunos[this.indice] = a;
			System.out.println("A matrícula foi feita com sucesso");
			this.indice ++;
			return true;
		}
		System.out.println("Não existe mais espaço na disciplina");
		return false;
	}
		
	public void atribuirNota(int matricula, double n1, double n2){
		for (int i = 0; i < this.indice; i++){
			if(alunos[i].getMatricula() == matricula){
				alunos[i].setNota1(n1);
				alunos[i].setNota2(n2);
			}
		}
	}
	
	public void alterarNota1(int matricula, double nova){
		for (int i = 0; i < this.indice; i++){
			if(alunos[i].getMatricula() == matricula){
				alunos[i].setNota1(nova);
			}
		}
	}
	
	public void alterarNota2(int matricula, double nova){
		for (int i = 0; i < this.indice; i++){
			if(alunos[i].getMatricula() == matricula){
				alunos[i].setNota2(nova);
			}
		}
	}
	
	public void estatistica(){
		double acima = 0, abaixo = 0, media = 0;
		Aluno aux = null;
		for(int i = 0; i < this.indice; i++){
			for (int j = i; j < this.indice; j++){
				if(alunos[i].media() < alunos[j].media()){
					aux = alunos[j];
					alunos[j] = alunos[i];
					alunos[i] = aux;
				}
			}
		}
		System.out.println("O aluno com maior média foi o: "+alunos[0].getNome());
		
		for (int i = 0; i < this.indice; i++){
			media += alunos[i].media();
			if(alunos[i].media() >= 7.0){
				acima++;
			}
			else{
				abaixo++;
			}
		}
		System.out.println(acima+" alunos passaram com média >= 7.0");
		System.out.println(abaixo+" alunos não passaram.");
		System.out.println("A média da turma é de: "+media/(acima+abaixo));
	}
	
	public void listaAlfabetica(){
		ArrayList<String> list = new ArrayList();
		for(int i = 0; i < this.indice; i++){
			list.add(alunos[i].getNome());
		}
		
		Collections.sort(list);
		System.out.println("Lista alfabetica");
		
		for(int i = 0; i < this.indice; i++){
			for(int j = 0; j < this.indice; j++){
				if(list.get(i) == alunos[j].getNome()){
					System.out.println("ALUNO : "+alunos[j].getNome()+"/ NOTA 1: "+alunos[j].getNota1()+"/ NOTA 2 :"+alunos[j].getNota2()+"/ MEDIA : "+alunos[j].media());	
				}
			}
		}
	}
	
	public void listaMedia(){
		Aluno aux = null;
		for(int i = 0; i < this.indice; i++){
			for (int j = i; j < this.indice; j++){
				if(alunos[i].media() < alunos[j].media()){
					aux = alunos[j];
					alunos[j] = alunos[i];
					alunos[i] = aux;
				}
			}
		}
		
		System.out.println("Lista Media");
		for(int i = 0; i < this.indice; i++){
			if(alunos[i] != null){
				System.out.println("ALUNO : "+alunos[i].getNome()+"/ NOTA 1: "+alunos[i].getNota1()+"/ NOTA 2 :"+alunos[i].getNota2()+"/ MEDIA : "+alunos[i].media());	
			}
		}
		
	}
}
