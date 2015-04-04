import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		table jogo = new table();
		Random sc2 = new Random();
		Scanner sc1 = new Scanner(System.in);
		String cor;
		int resp, random, i = 0;
		
		
		// ------------ Setando jogadores ! --------------------
		do{
			System.out.println("Aqui você adiociona novos jogadores!");
			System.out.println("<1> Adicionar novo jogador.");
			System.out.println("<2> Começar partida.");
			resp = sc1.nextInt();
			if(resp == 1){
				System.out.println("Informe a cor do novo jogador!");
				cor = sc1.next();
				random = sc2.nextInt(3 - 1) + 1;
				
				if(random == 1){
					jogo.criarAzarado(cor);
				}
				else{
					if(random == 2){
						jogo.criarNormal(cor);
					}
					else{
						jogo.criarSortudo(cor);
					}
				}
			}
			else{
				if(jogo.getInd() < 2){
					System.out.println("O jogo não pode ser começado, pois existe menos de dois jogadores!");
				}
				else{
					if(jogo.getInd() == 3){
						System.out.println("O jogo começará, visto que o número total de jogadores foi atingido!");
					}
				}
			}
		}while(resp != 2 || jogo.getInd() < 2);
		
		
		// ------------------ Começando a partida! ---------------------
		jogo.match();
	}

}
