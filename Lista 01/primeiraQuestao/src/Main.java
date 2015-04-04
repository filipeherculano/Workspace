
public class Main {
	public static void main(String[] args) {
		Data db1 = new Data(31, 12, 2015);
		Data db2 = new Data(29, 02, 2016);
		
		db1.toString();
		db2.toString();
		
		if(db1.maisAntiga(db2.getDia(), db2.getMes(), db2.getAno())){
			System.out.println("A segunda data é a mais antiga.");
		}
		else{
			System.out.println("A segunda data é mais recente.");
		}
		

		db1.avançarDia();
		System.out.print("Nova data->");
		db1.toString();

		db2.avançarDia();
		System.out.print("Nova data->");
		db2.toString();
	}

}
