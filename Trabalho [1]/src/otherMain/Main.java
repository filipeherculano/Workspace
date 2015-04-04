package otherMain;
import java.util.Scanner;
import java.util.Random;

import exception.MovimentoInvalidoException;

public class Main {
	public static void main(String[] args) throws MovimentoInvalidoException{
		int foodX, foodY;
		String color, move;
		Random random = new Random();
		Scanner sc1 = new Scanner(System.in);
		Robo robotOne = new Robo("Azul");
		Robo robotSecond = new Robo("Vermelho");
		
		do{
			System.out.println("Diga o local onde está o alimento. Shh!! Não conte para ninguém! Coloque um valor entre 1 e 10!");
			System.out.println("Primeiro valor: ");
			foodX = sc1.nextInt();
			System.out.println("Segundo valor: ");
			foodY = sc1.nextInt();
		}while (!(foodX > 0 && foodX <= 5 && foodY > 0 && foodY <= 5));

		for(int i = 0; ;i++){
			System.out.println("Movimentação do robô: "+robotOne.getCor()+". Pressione Enter para movimenta-lo.");
			new Scanner(System.in).nextLine();
			try {
				robotOne.mover( random.nextInt(4) + 1);
			} catch (MovimentoInvalidoException e) {
				System.out.println(e.toString());
			}
			
			if(robotOne.foundFood(foodX, foodY)){
				System.out.println("O robô "+robotOne.getCor()+" encontrou a comida.");
				break;
			}
			
			System.out.println("Movimentação do robô: "+robotSecond.getCor()+". Pressione Enter para movimenta-lo.");
			new Scanner(System.in).nextLine();
			try {
				robotSecond.mover( random.nextInt(4) + 1);
			} catch (MovimentoInvalidoException e) {
				System.out.println(e.toString());
			}
			
			if(robotSecond.foundFood(foodX, foodY)){
				System.out.println("O robô "+robotSecond.getCor()+" encontrou a comida.");
				break;
			}
		}
	}
}
