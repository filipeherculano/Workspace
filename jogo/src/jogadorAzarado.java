
public class jogadorAzarado extends jogador{
	public jogadorAzarado(String cor){
		super(cor, "azarado");
	}
	
	public int rollDice(){
		System.out.println("Jogador jogou os dados ...");
		do{
			this.r1 = (randomNumber.nextInt(6 - 1) + 1);
			this.r2 = (randomNumber.nextInt(6 - 1) + 1);
		}while (this.r1+this.r2 > 6);
		
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