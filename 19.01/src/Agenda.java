import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contato> contatos = new ArrayList();
	
	public void adicionarContato(Contato c){
		contatos.add(c);
	}
	
	public void removerContato(Contato c){
		contatos.remove(c);
	}

	public void mostrarContatos(){
		for (Contato c : contatos){
			c.mostrarContatos();
		}
	}
	
	/*public ArrayList procurarIdade(int idade){
		ArrayList<Pessoa> age;
		j = 0;
		for (int i = 0; i < pessoas.size(); i++){
			if(pessoas.get(i).getIdade() == idade){
				age.get(j) = pessoas.get(i);
			}
		}
		return age;
	}
	
	public Pessoa procurarNome(String nome){
		Pessoa c = null;
		for (int i = 0; i < pessoas.size(); i++){
			if(pessoas.get(i).getNome() == nome){
				c = pessoas.get(i);
			}
		}
		return c;
	}
	
	public void alterarIdade(String nome, int idade){
		Pessoa c = null;
		for(int i = 0; i < pessoas.size(); i++){
			if(pessoas.get(i).getNome() == nome){
				pessoas.get(i).setIdade(idade);
			}
		}
	}*/
	
	
}
