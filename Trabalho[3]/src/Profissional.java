import java.util.ArrayList;


public class Profissional {
	private int id, idade;
	private String nome, sexo;
	private ArrayList<Instituição> a = new ArrayList<Instituição>();
	
	public Profissional(int id, int idade, String nome, String sexo){
		this.id = id;
		this.idade = idade;
		this.nome = nome;
		this.sexo = sexo;
	}
	
	public void addInstituição(Instituição e){
		this.a.add(e);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}

	public int getId(){
		return this.id;
	}
	
	public int getIdade(){
		return this.idade;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getSexo(){
		return this.sexo;
	}
	
	public ArrayList getInstituição(){
		return this.a;
	}
}
