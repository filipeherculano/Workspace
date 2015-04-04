
public class Main {
	public static void main(String[] args) {
		MatrizDeInteiros matrix = new MatrizDeInteiros(8,23);
		
		matrix.coordinate(333, 12, 27);
		matrix.coordinate(1, 2, -12);
		
		if(matrix.éQuadrada()){
			System.out.println("A matriz é quadrada.");
		}
		else{
			System.out.println("A matriz não é quadrada.");
		}
		
		System.out.println("A soma de todos os valores da matriz é: "+matrix.total());
		System.out.println("A linha na qual existe o valor 27 é: "+matrix.valorIgual(27));
		
		matrix.mostrarMatriz();
	}

}
