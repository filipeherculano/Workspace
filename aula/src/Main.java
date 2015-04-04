import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		int resposta;
		String name;
		Scanner in = new Scanner(System.in);
		int num, i = 0, d;
		double saque, deposito;
		Banco b = new Banco("Banco PEOO");
		
		do{
			System.out.println("O que deseja?");
			System.out.println("1.Criar conta");
			System.out.println("2.Sacar");
			System.out.println("3.Depositar");
			System.out.println("4.Alterar nome do titular");
			System.out.println("5.Transferir");
			System.out.println("6.Sair");
			resposta = in.nextInt();
			
			switch(resposta){
			case 1:
				System.out.println("Digite o numero da conta.");
				num = in.nextInt();
				System.out.println("Digite seu nome.");
				name = in.next();
				Conta c = new Conta(num, name, 0);
				b.adicionarConta(c);
				break;
			case 2:
				System.out.println("digite o numero da sua conta.");
				num = in.nextInt();
				System.out.println("Quanto voce deseja sacar?");
				saque = in.nextDouble();
				b.sacar(num, saque);
				break;
			case 3:
				System.out.println("digite o numero da sua conta.");
				num = in.nextInt();
				System.out.println("Quanto voce deseja depositar?");
				deposito = in.nextDouble();
				b.depositar(num, deposito);
				break;
			case 4:
				System.out.println("digite o numero da sua conta.");
				num = in.nextInt();
				System.out.println("Digite o nome a ser alterado.");
				name = in.next();
				b.setTitular(num, name);
				break;
			case 5:
				System.out.println("digite o numero da sua conta.");
				int rem = in.nextInt();
				System.out.println("digite o numero do destinatario.");
				int dest = in.nextInt();
				System.out.println("Digite o valor de transferencia");
				saque = in.nextDouble();
				b.transferir(rem, dest, saque);
				break;
			case 6:
				System.out.println("--->FIM DO PROGRAMA.");
				b.exibirContas();
				break;
			}
		}while (resposta != 6);
		
	}

}
