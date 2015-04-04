
public class Main {
	public static void main(String[] args) {
		Disciplina peoo = new Disciplina(1234, "PEOO");
		Aluno filipe = new Aluno("Filipe Herculano Rocha", 1293133);
		Aluno gabriel = new Aluno("Gabriel angelo", 242424);
		Aluno leonardo = new Aluno("Leonardo Dutra", 111222);
		
		peoo.matriculaAluno(filipe);
		peoo.matriculaAluno(leonardo);
		peoo.matriculaAluno(gabriel);
		
		peoo.atribuirNota(1293133, 10.0, 8.0);
		peoo.atribuirNota(242424, 1.0, 8.0);
		peoo.atribuirNota(111222, 4.0, 8.0);
		
		peoo.alterarNota2(1293133, 1.0);

		peoo.listaAlfabetica();
		peoo.listaMedia();
		peoo.estatistica();
	}

}
