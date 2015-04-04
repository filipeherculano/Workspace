
public class Main {
	public static void main(String[] args) {
		Aeroporto um = new Aeroporto("SSA", "Salvador", true);
		Aeroporto dois = new Aeroporto("BSB", "Brasília", false);
		Aviao primeiro = new Aviao("zigzag", "jumbo", "sei la", 120);
		Aviao segundo = new Aviao("zig", "jambo", "tbm nao sei", 100);
		
		um.adicionarAviao(primeiro);
		dois.adicionarAviao(segundo);
		
		if(um.internacional()){
			System.out.println("O aeroporto Um é internacional");
		}
		else{
			System.out.println("O aeroporto Um não é internacional");
		}
		
		um.alterna();
		
		if(um.internacional()){
			System.out.println("O aeroporto Um é internacional");
		}
		else{
			System.out.println("O aeroporto Um não é internacional");
		}
		
		if(um.ehIgual(dois)){
			System.out.println("Os aeroportos são iguais");
		}
		else{
			System.out.println("Os aeroportos são diferentes");
		}
		
		um.estaPousada("zigzag");
	}

}
