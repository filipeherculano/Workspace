
public class Aviao {
	private String prefixo;
	private String modelo;
	private String fabricante;
	private int assentosOcupados;
	
	
	public Aviao(String prefixo, String modelo, String fabricante, int assentos){
		this.prefixo = prefixo;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.assentosOcupados = assentos;
	}
	
	
	public void retornarPrefix(){
		System.out.println(this.prefixo);
	}
	
	public String getPrefixo(){
		return this.prefixo;
	}
	
}
