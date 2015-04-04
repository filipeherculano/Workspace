import java.util.ArrayList;

public class Aeroporto {
	private String codigo;
	private String nome;
	private boolean ehInternacional;
	private ArrayList<Aviao> avioesNoPatio;
	
	public Aeroporto(String codigo, String nome, boolean internacional){
		this.codigo = codigo;
		this.nome = nome;
		this.ehInternacional = internacional;
		avioesNoPatio = new ArrayList<Aviao>();
	}
	
	public void adicionarAviao(Aviao a){
		avioesNoPatio.add(a);
	}
	
	public boolean internacional(){
		return this.ehInternacional;
	}
	
	public void alterna(){
		if(this.ehInternacional){
			this.ehInternacional = false;
		}
		else{
			this.ehInternacional = true;
		}
	}
	
	public void estaPousada(String prefixo){
		for (int i = 0; i < avioesNoPatio.size(); i++){
			if(avioesNoPatio.get(i).getPrefixo() == prefixo){
				System.out.println("A aeronave está pousada nele!");
				break;
			}
		}
	}
	
	public boolean ehIgual(Aeroporto c){
		if(this.codigo == c.getCodigo()){
			return true;
		}
		return false;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}