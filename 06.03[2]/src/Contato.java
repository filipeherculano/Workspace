
public class Contato {
	private String nome;
	private int telefone;
	
	public Contato(String nome, int tel){
		this.nome = nome;
		this.telefone = tel;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setTelefone(int tel){
		this.telefone = tel;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getTelefone(){
		return this.telefone;
	}
}
