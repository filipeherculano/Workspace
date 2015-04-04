
public class Aluno {
	private String nome;
	private double nota;
	private char gabarito[] = new char[20];
	
	public Aluno(String nome){
		this.nome = nome;
	}
		
	public char getGabarito(int i){
		return gabarito[i];
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public double getNota(){
		return this.nota;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setNota(double nota){
		this.nota = nota;
	}
	
	public void setGabarito(int i, char c){
		if(i >= 0 && i < 20){
			this.gabarito[i] = c;
		}
	}
}	
