
public class Contato {
	private String nome;
	private int telefone;
	private int idade;

	public Contato(String nome, int telefone, int idade){
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
	}
	
	public void mostrarContatos(){
		System.out.println("Nome: "+nome);
		System.out.println("Idade: "+idade);
		System.out.println("Telefone: "+telefone);
	}
	
}
