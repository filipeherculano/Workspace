import exception.ExcecaoElementoInexistente;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contato> lista = new ArrayList();
	
	public void addContato(Contato a){
		lista.add(a);
	}
	
	public void removerContato(Contato a) throws ExcecaoElementoInexistente{
		if(!lista.remove(a))
			throw new ExcecaoElementoInexistente();
		else
			lista.remove(a);
	}

	public Contato buscarContato(String nome) throws ExcecaoElementoInexistente{
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nome){
				return lista.get(i);
			}
		}
		throw new ExcecaoElementoInexistente();
	}
}
