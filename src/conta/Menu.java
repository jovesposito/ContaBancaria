package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;


public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1, 123, 1, "Elvira", 10000.0f);
		c1.visualizar();
		c1.sacar(15000.0f);
		c1.visualizar();
		c1.depositar(7000.0f);
		c1.visualizar();
		
		Conta c2 = new Conta(2, 456, 1, "Muriel", 17000.0f);
		c2.visualizar();
		c2.sacar(15000.0f);
		c2.visualizar();
		c2.depositar(3000.0f);
		c2.visualizar();
		
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


