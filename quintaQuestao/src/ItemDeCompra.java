
public class ItemDeCompra {
	private int codigo;
	private String nome;
	private double preco;
	private int quantidadeComprada;
	
	public ItemDeCompra(int codigo, String nome, double preco, int quantidade){
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeComprada = quantidade;
	}
	
	public double calcularTotal(){
		return this.preco*this.quantidadeComprada;
	}
	
	
	//get e set
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public void set(int quantidade){
		this.quantidadeComprada = quantidade;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public int getQuantidade(){
		return this.quantidadeComprada;
	}
}
