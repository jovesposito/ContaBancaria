package conta;

import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;


public class Menu {

	public static void main(String[] args) {
		
		ContaCorrente cc1 = new ContaCorrente(3, 789, 1, "Romeu Bezerra", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
				
		ContaPoupanca cp1 = new ContaPoupanca(4, 159, 2, "Filomena Oliveira", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		Scanner sc = new Scanner(System.in);
		
		int opc;
		
		String menu = "*****************************************************\n" +
	              "\n" +
	              "                BANCO DO BRAZIL COM Z                \n" +
	              "\n" +
	              "*****************************************************\n" +
	              "\n" +
	              "            1 - Criar Conta                          \n" +
	              "            2 - Listar todas as Contas               \n" +
	              "            3 - Buscar Conta por Numero              \n" +
	              "            4 - Atualizar Dados da Conta             \n" +
	              "            5 - Apagar Conta                         \n" +
	              "            6 - Sacar                                \n" +
	              "            7 - Depositar                            \n" +
	              "            8 - Transferir valores entre Contas      \n" +
	              "            9 - Sair                                 \n" +
	              "\n" +
	              "*****************************************************\n" +
	              "\n" +
	              "Entre com a opção desejada:                          " +
	              "\n";
			
		while (true) {
			
			System.out.print(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + menu + Cores.TEXT_RESET);
			
			opc = sc.nextInt();
			

			if (opc == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				sc.close();
				System.exit(0);
			}
			
			switch (opc) {
			
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				break;
				
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				break;
			
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Contar - por número\n\n");
				break;
			
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida!\n\n");
				break;
	
			}
			
		}
	}
	
	public static void sobre() {
		System.out.println("\n*********************************************************\n");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("João Espósito");
		System.out.println("github.com/jovesposito");
		System.out.println("\n*********************************************************");
	}

}


