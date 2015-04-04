
public class Main {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Contato filipe = new Contato("Filipe H", 87489327);
		Contato Ielda = new Contato("Ielda H", 88870708);
		Contato Aline = new Contato("Alime M", 81238328);
		
		agenda.addContato(filipe);
		agenda.addContato(Ielda);
		
		try{
			agenda.removerContato(Aline);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			agenda.buscarContato("Aline");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
