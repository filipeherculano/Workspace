
public class Conta {
	private int numero;
	private String titular;
	private double saldo;
	
	public Conta(int numero, String titular, double saldo){
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public void depositar(double valor){
		this.saldo += valor;
	}
	
	public boolean sacar(double valor){
		if(saldo >= valor){
			saldo -= valor;
			return true;
		}
		return false;
	}
	
	// ----- Get e Set -----
	public double getSaldo(){
		return this.saldo;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public String getTitular(){
		System.out.println("Titular trocado com sucesso");
		return this.titular;
	}
	
	public void setNumero(int numero){
		this.numero = numero;
		System.out.println("Numero trocado com sucesso.");
	}
	
	public void setTitular(String nome){
		this.titular = nome;
		System.out.println("Nome do titular alterado com sucesso.");
	}
	
	public void mostrarDado(){
		System.out.println("Numero: " +numero);
		System.out.println("Titular: "+titular);
		System.out.println("Saldo: " +saldo);
	}
}
