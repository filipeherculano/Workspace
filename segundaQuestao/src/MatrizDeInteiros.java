
public class MatrizDeInteiros {
	private int [][]matriz;
	private int linha, coluna;
	
	public MatrizDeInteiros(int linha, int coluna){
		matriz = new int[linha][coluna];
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				this.matriz[i][j] = 0;
			}
		}
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public void coordinate(int linha, int coluna, int numero){
		if(this.linha >= linha-1 && this.coluna >= coluna-1){
			this.matriz[linha-1][coluna-1] = numero;
		}
		else{
			System.out.println("Coordenadas dadas estão fora do escopo.");
		}
	}
	
	public boolean éQuadrada(){
		if(this.linha == this.coluna){
			return true;
		}
		return false;
	}
	
	public int total(){
		int soma = 0;
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				soma += matriz[i][j];
			}
		}
		return soma;
	}
	
	public int valorIgual(int numero){
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				if(matriz[i][j] == numero){
					return i+1;
				}
			}
		}
		return -1;
	}
	
	public void mostrarMatriz(){
		for(int i = 0; i < linha; i++){
			System.out.println("");
			for(int j = 0; j < coluna; j++){
				System.out.print(this.matriz[i][j]+" ");
			}
		}
	}
}
