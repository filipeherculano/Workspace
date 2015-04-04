package exception;

public class AccessNullNumberException extends Exception {
	public String toString(){
		return "Este indice não existe. Ele vai de [0 ~ 9] (AccessNullNumberException)";
	}
}
