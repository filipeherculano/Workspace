import java.util.Random;
import exception.MovimentoInvalidoException;

public class Robo {
	public int x, y;
	public String cor;
	public Random sc1 = new Random();
	
	public Robo(String cor){
		this.x = 0;
		this.y = 0;
		this.cor = cor;
	}
	
	public boolean foundFood(int foodX, int foodY){
		if(this.x == foodX && this.y == foodY)
			return true;
		return false;
	}
	
	public void mover(String move) throws MovimentoInvalidoException{
		switch (move){
			case "down":
				if(this.x == 0){
					throw new MovimentoInvalidoException(move);
				}else{
					this.x --;
					System.out.println("Posição atual: "+this.getX()+","+this.getY()+";");
				}
				break;
			case "left":
				if(this.y == 0){
					throw new MovimentoInvalidoException(move);
				}else{
					this.y --;
					System.out.println("Posição atual: "+this.getX()+","+this.getY()+";");
				}
				break;
			case "up":
				if(this.x == 10){
					throw new MovimentoInvalidoException(move);
				}else{
					this.x ++;
					System.out.println("Posição atual: "+this.getX()+","+this.getY()+";");
				}
				break;
			case "right":
				if(this.y == 10){
					throw new MovimentoInvalidoException(move);
				}else{
					this.y ++;
					System.out.println("Posição atual: "+this.getX()+","+this.getY()+";");
				}
				break;
			default:
				throw new MovimentoInvalidoException(move);
		}
		
	}
	
	//@override
		public void mover(int move) throws MovimentoInvalidoException{
			switch (move){
				case 1:
					if(this.x == 5){
						throw new MovimentoInvalidoException("up");
					}else{
						this.x ++;
						System.out.println("Posição atual do robô "+this.getCor()+": "+this.getX()+","+this.getY()+";");
					}
					break;
				case 2:
					if(this.x == 0){
						throw new MovimentoInvalidoException("down");
					}else{
						this.x --;
						System.out.println("Posição atual do robô "+this.getCor()+": "+this.getX()+","+this.getY()+";");
					}
					break;
				case 3:
					if(this.y == 5){
						throw new MovimentoInvalidoException("right");
					}else{
						this.y ++;
						System.out.println("Posição atual do robô "+this.getCor()+": "+this.getX()+","+this.getY()+";");
					}
					break;
				case 4:
					if(this.y == 0){
						throw new MovimentoInvalidoException("left");
					}else{
						this.y --;
						System.out.println("Posição atual do robô "+this.getCor()+": "+this.getX()+","+this.getY()+";");
					}
					break;
				default:
					throw new MovimentoInvalidoException("other");
			}
			
		}
	
	// -------------------- get/set -----------------
	public String getCor(){
		return this.cor;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
