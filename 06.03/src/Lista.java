import exception.AccessNullNumberException;

public class Lista {
	private int [] list = new int[10];
	private int ind = 0;
	
	public void addNumber(int a){
		this.list[ind] = a;
		ind++;
	}
	
	public int getNumber(int i) throws AccessNullNumberException{
		if(i > ind || i < 0){
			throw new AccessNullNumberException();
		}
		return this.list[i];
	}
}