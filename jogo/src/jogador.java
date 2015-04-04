import java.util.Random; 

public class jogador {
	protected String cor;
	protected String characteristc;
	protected int position = 0;
	protected Random randomNumber = new Random();
	protected int r1 = 0, r2 = 0, r3 = 0;
	protected boolean playAgain = false;
	protected boolean abletoPlay = true;
	
	// -------------- Construtor --------------
	public jogador(String cor, String carater){
		this.cor = cor;
		this.characteristc = carater;
	}
	// ---------------- Métodos ---------------------
	public int rollDice(){
		System.out.println("Jogador jogou os dados ...");
		this.r1 = (randomNumber.nextInt(6 - 1) + 1);
		this.r2 = (randomNumber.nextInt(6 - 1) + 1);
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
	
	public boolean podeJogar(){
		if ((this.position != 10 && this.position != 25 && this.position != 38) || (!abletoPlay)){
			this.abletoPlay = true;
			return this.abletoPlay;
		}
		this.abletoPlay = false;
		return this.abletoPlay;
	}
	
	public void movimentar(int dados){
		if(this.position == 5 || this.position == 15 || this.position == 30){
			System.out.println("Ande mais 3 casas!");
			this.position += 3;
		}
		this.position += dados;
	}
	
	// ------------------- get e set ---------------------
	public String getCor(){
		return this.cor;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public String getCharacteristc(){
		return this.characteristc;
	}
	
	public boolean getPlayAgain(){
		return this.playAgain;
	}
	
	public boolean getAbletoPlay(){
		return this.abletoPlay;
	}
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	public void setCharacteristic(String carater){
		this.characteristc = carater;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
}