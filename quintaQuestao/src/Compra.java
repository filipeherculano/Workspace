import java.util.ArrayList;

public class Compra {
	private ArrayList<ItemDeCompra> carrinho = new ArrayList<ItemDeCompra>();
	
	public void inserirItem(ItemDeCompra a){
		carrinho.add(a);
	}
	
	public double calcularTotalCompra(){
		double soma = 0;
		for(int i = 0; i < carrinho.size(); i++){
			if(carrinho.get(i) != null){
				soma += carrinho.get(i).calcularTotal();
			}
		}
		return soma;
	}
	
	public double darDesconto(double desconto){
		double soma = 0;
		for(int i = 0; i < carrinho.size(); i++){
			if(carrinho.get(i) != null){
				soma += carrinho.get(i).calcularTotal();
			}
		}
		return soma*desconto;
	}
	
	public double calcularTotalFinal(double valor, double desconto){
		return valor-desconto;
	}
	
	public void gerarRelatorio(double desconto, String pagamento, double valor, double porcentagem){
		System.out.println("Codigo ---- Nome ---- Quantidade de itens ----- Preço");
		for(int i = 0; i < carrinho.size(); i++){
			System.out.println(carrinho.get(i).getCodigo()+"---"+carrinho.get(i).getNome()+"---"+carrinho.get(i).getQuantidade()+"---"+carrinho.get(i).getPreco());
		}
		System.out.println("Desconto  --------------------------->"+this.darDesconto(porcentagem));
		System.out.println("Tipo de pagamento ------------------->"+pagamento);
		System.out.println("Valor final ------------------------->"+this.calcularTotalFinal(valor, desconto));
	}
}
