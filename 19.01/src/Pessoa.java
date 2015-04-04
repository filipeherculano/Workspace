
public class Pessoa {
		private String nome;
		private int telefone;
		private int idade;
		
		public void Pessoa(String nome, int telefone, int idade){
			this.nome = nome;
			this.idade = idade;
			this.telefone = telefone;
		}
		
		public String getNome(){
			return this.nome;
		}
		
		public int getTelefone(){
			return this.telefone;
		}
		
		public int getIdade(){
			return this.idade;
		}
		
		public void setNome(String name){
			this.nome = name;
		}
		
		public void setTelefone(int telefone){
			this.telefone = telefone;
		}
		
		public void setIdade(int idade){
			this.idade = idade;
		}
		
		public void mostrarDado(){
			System.out.println("Nome: "+nome);
			System.out.println("Idade: "+idade);
			System.out.println("Telefone: "+telefone);
		}
		
		
}
