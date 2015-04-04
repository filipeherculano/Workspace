import java.util.ArrayList;

public class Pais {
	private String nome;
	private String capital;
	private int dimensao;
	private ArrayList<String> fronteira;
	
	public Pais(String nome, String capital, int dimensao){
		fronteira = new ArrayList<String>();
		this.nome = nome;
		this.capital = capital;
		this.dimensao = dimensao;
	}
	
	
	public boolean equals(Pais outro){
		if(this.nome == outro.getNome() && this.capital == outro.getCapital()){
			return true;
		}
		return false;
	}
	
	public void setFronteira(String pais){
		if(this.nome != pais){
			fronteira.add(pais);
		}
		else{
			System.out.println("O país informado é o mesmo.");
		}
	}
	
	public ArrayList listaFronteira(){
		return this.fronteira;
	}
	
	//Get e set
	public String getNome(){
		return this.nome;
	}
	
	public String getCapital(){
		return this.capital;
	}
	
	public int getDimensao(){
		return this.dimensao;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setCapital(String capital){
		this.capital = capital;
	}
	
	public void setDimensao(int dimensao){
		this.dimensao = dimensao;
	}
	
	
}
