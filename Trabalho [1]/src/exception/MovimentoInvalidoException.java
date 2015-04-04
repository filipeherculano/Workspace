package exception;

public class MovimentoInvalidoException extends Exception{
	private String move;
	
	public MovimentoInvalidoException(String move){
		this.move = move;
	}
	
	public String toString(){
		switch (this.move){
			case "down":
				return "--------------------->ERRO: Você não pode se mover para 'down'. Pois possue coordenada negativa.";
			case "left":
				return "--------------------->ERRO: Você não pode se mover para 'left'. Pois possue coordenada negativa.";
			case "up":
				return "--------------------->ERRO: Você não pode se mover para 'up'. Pois estará fora da range máxima.";
			case "right":
				return "--------------------->ERRO: Você não pode se mover para 'right'. Pois estará fora da range máxima.";
			default:
				return "--------------------->ERRO: Movimento não cadastrado.";
		}
	}
}
