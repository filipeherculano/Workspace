import java.util.Scanner;


public class table {
	jogador jogadores[] = new jogador[4];
	private Scanner sc1 = new Scanner(System.in);
	private String color;
	private int i = 0, resp;
	
	
	// ----------------- Partida ---------------------
	public void match(){
		do{
			this.rodada();
		}while(this.unfinished());
	}
	
	public void rodada(){
		for(jogador player : jogadores){
			if(player != null){
				System.out.println("-----------------------------------------------");
				System.out.println("Vez do jogador "+player.getCor());
				System.out.println("Pressione <1> para jogar dados!");
				this.resp = this.sc1.nextInt();
				if(resp == 1){
					do{
						if(player.podeJogar()){
							System.out.println("Posição atual: "+player.getPosition());
							player.movimentar(player.rollDice());
							
							if(player.getPosition() == 17 || player.getPosition() == 27){
								System.out.println("Você pode escolher um competidor para voltar! Diga a cor!");
								this.color = this.sc1.next();
								this.reseta(this.color);
							}
							else{
								if(player.getPosition() == 20 || player.getPosition() == 35){
									System.out.println("Opa!!\n Troque de lugar com o mais atrasado!");
									player.setPosition( this.trocaComAnterior(player.getPosition()) );
								}
							}
						}
						else{
							System.out.println("Jogador "+player.getCor()+" não pode jogar essa rodada.");
						}
						
					}while (player.playAgain);
				}
				System.out.println("Posição final: "+player.getPosition());
			}
		}
	}
	
	public boolean unfinished(){
		for(jogador player4 : jogadores){
			if(player4.getPosition() >= 40 && player4 != null){
				System.out.println("Partida terminou!\nJogador "+player4.getCor()+" ganhou a partida!");
				return false;
			}
		}
		return true;
	}
	
	public int trocaComAnterior(int location){
		int min = jogadores[0].getPosition();
		String color = null;
		
		// ---------------- Achando a cor mais distante -------------- 
		for(int j = 1; j < 4; j++){
			if(jogadores[j] != null && jogadores[j].getPosition() <= min){
				min = jogadores[j].getPosition();
				color = jogadores[j].getCor();
			}
		}
		
		// --------------- Trocando com o mais distante -------------
		for(int j = 0; j < 4; j++){
			if(jogadores[j] != null && jogadores[j].getCor().equals(color)){
				jogadores[j].setPosition(location);
			}
		}
		return min;
	}
	
	public void reseta(String cor){
		for(jogador player2 : jogadores){
			if(player2 != null){
				if (player2.getCor().equals(cor)){
					player2.setPosition(0);
					System.out.println("Jogador " +player2.getCor()+ " foi mandado para o começo.");
				}
			}
		}
	}
	
	// -------------- Construtores ---------------------
	public void criarAzarado(String cor){
		if(this.i < 4){
			jogadores[this.i] = new jogadorAzarado(cor);
			this.i ++;
		}
		else{
			System.out.println("Não é possível adicionar mais jogadores.");
		}
	}
	
	public void criarNormal(String cor){
		if(this.i < 4){
			jogadores[this.i] = new jogadorNormal(cor);
			this.i ++;
		}
		else{
			System.out.println("Não é possível adicionar mais jogadores.");
		}
	}
	
	public void criarSortudo(String cor){
		if(this.i < 4){
			jogadores[this.i] = new jogadorNormal(cor);
			this.i ++;
		}
		else{
			System.out.println("Não é possível adicionar mais jogadores.");
		}
	}
	
	public int getInd(){
		return this.i;
	}
}
