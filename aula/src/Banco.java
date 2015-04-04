import java.util.ArrayList;

public class Banco {
	private String nome;
	private ArrayList<Conta> contas;
	private int numContas = 0;
	
	public Banco(String name){
		this.nome = name;
		contas = new ArrayList<Conta>();
	}
	
	public void adicionarConta(Conta c){
		contas.add(c);
	}
	
	public void removerConta(Conta c){
		contas.remove(c);
	}
	
	public Conta procurarConta(int num){
		Conta c = null;
		for (int i=0; i < contas.size(); i++){
			if(contas.get(i).getNumero() == num){
				c = contas.get(i);
				break;
			}
		}
		return c;
	}
	
	public boolean sacar(int numero, double saque){
		for (int i = 0; i < contas.size(); i++){
			if(contas.get(i).getNumero() == numero){
				contas.get(i).sacar(saque);
				return true;
			}
		}
		return false;
	}
	
	public boolean depositar(int numero, double deposito){
		for (int i = 0; i < contas.size(); i++){
			if(contas.get(i).getNumero() == numero){
				contas.get(i).depositar(deposito);
				return true;
			}
		}
		return false;
	}
	
	public boolean transferir(int remetente, int destinatario, double saque){
		for (int i = 0; i < contas.size(); i++){
			if(contas.get(i).getNumero() == remetente){
				contas.get(i).sacar(saque);
				for(int j = 0; j < contas.size(); j++){
					if(contas.get(j).getNumero() == destinatario){
						contas.get(j).depositar(saque);
						return true;	
					}
				}
			}
		}
		return false;
	}
	
	public boolean setTitular(int numero, String titular){
		for (int i = 0; i < contas.size(); i++){
			if(contas.get(i).getNumero() == numero){
				contas.get(i).setTitular(titular);
				return true;
			}
		}
		return true;
	}
	
	public void exibirContas(){
		for (Conta c: contas){
			if(c != null){
				c.mostrarDado();
			}
		}
	}
	
}
