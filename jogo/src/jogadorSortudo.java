
public class jogadorSortudo extends jogador{
	public jogadorSortudo(String cor) {
		super(cor, "sortudo");
	}
	
	public int rollDice(){
		System.out.println("Jogador jogou os dados ...");
		do{
			this.r1 = (randomNumber.nextInt(6 - 1) + 1);
			this.r2 = (randomNumber.nextInt(6 - 1) + 1);
		}while (this.r1+this.r2 < 7);
		
		System.out.println("Dado um deu: "+this.r1+"\nDado dois deu: "+this.r2);
		if(this.r1 == this.r2){
			System.out.println("Jogador deverá jogar os dados novamente!");
			this.playAgain = true;
		}
		else{
			this.playAgain = false;
		}
		
		return this.r1 + this.r2;
	}

}
