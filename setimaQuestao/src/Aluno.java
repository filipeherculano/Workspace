
public class Aluno {
	private String nome;
	private int matricula;
	private double nota1;
	private double nota2;
	
	public Aluno(String nome, int matricula){
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public double media(){
		return (this.nota1 + this.nota2)/2;
	}
	
	//get e set
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setMatricula(int matricula){
		this.matricula = matricula;
	}
	
	public void setNota1(double nota){
		this.nota1 = nota;
	}
	
	public void setNota2(double nota){
		this.nota2 = nota;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getMatricula(){
		return this.matricula;
	}
	
	public double getNota1(){
		return this.nota1;
	}
	
	public double getNota2(){
		return this.nota2;
	}
}
