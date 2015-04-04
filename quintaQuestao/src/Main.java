import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		String pagamento;
		
		Compra cart = new Compra();
		ItemDeCompra item1 = new ItemDeCompra(1212,"leite", 2.30, 3);
		cart.inserirItem(item1);
		ItemDeCompra item2 = new ItemDeCompra(1321,"café", 3.50, 2);
		cart.inserirItem(item2);
		
		System.out.println("Qual método de pagamento");
		pagamento = sc1.next();
		if(pagamento.equals("credito")){
			cart.gerarRelatorio(cart.darDesconto(0.05), pagamento, cart.calcularTotalCompra(), 0.05);
		}
		else{
			if(pagamento == "vista"){
				cart.gerarRelatorio(cart.darDesconto(0.1), pagamento, cart.calcularTotalCompra(), 0.1);
			}
		}
		
	}

}
