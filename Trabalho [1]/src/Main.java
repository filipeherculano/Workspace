import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int foodX, foodY;
		String color, move;
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Digite uma cor para o seu robô!");
		color = sc1.next();
		Robo robot = new Robo(color);
		do{
			System.out.println("Diga o local onde está o alimento. Shh!! Não conte para ninguém! Coloque um valor entre 1 e 10!");
			System.out.println("Primeiro valor: ");
			foodX = sc1.nextInt();
			System.out.println("Segundo valor: ");
			foodY = sc1.nextInt();
		}while (!(foodX > 0 && foodX <= 10 && foodY > 0 && foodY <= 10));
		
		while(!(robot.foundFood(foodX, foodY))){
			try{
				System.out.println("Você ainda não conseguiu pegar a comida! Digite qual movimento deseja fazer: ");
				System.out.println("--up\n--down\n--right\n--left");
				move = sc1.next();
				robot.mover(move);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		System.out.println("O robô "+robot.getCor()+" achou a comida!");
	}
}
