import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int aux, flag = 1;
		Lista nova = new Lista();
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Adicione um numero");
		aux = sc1.nextInt();
		nova.addNumber(aux);
		System.out.println("Adicione um numero");
		aux = sc1.nextInt();
		nova.addNumber(aux);
		System.out.println("Adicione um numero");
		aux = sc1.nextInt();
		nova.addNumber(aux);
		
		try{
			System.out.println("Qual número você quer ver?");
			aux = sc1.nextInt();
			System.out.println("Número nova["+aux+"]="+nova.getNumber(aux));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
