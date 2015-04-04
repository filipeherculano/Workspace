
public class Main {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Contato cp1 = new Contato("Filipe", 23123, 21);
		Contato cp2 = new Contato("ausdh", 123, 94);
		
		agenda.adicionarContato(cp1);
		agenda.adicionarContato(cp2);
		
		agenda.mostrarContatos();

	}

}
