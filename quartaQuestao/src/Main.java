
public class Main {
	public static void main(String[] args) {
		Pais brasil = new Pais("Brasil", "Brasília", 500000000);
		Pais argentina = new Pais("Argentina", "Buenos Aires", 250000000);
		
		if(brasil.equals(argentina)){
			System.out.println("É o mesmo país.");
		}
		else{
			System.out.println("Não é o mesmo país.");
		}
		
		brasil.setFronteira("Argentina");
		brasil.setFronteira("Colômbia");
		
		
	}

}
