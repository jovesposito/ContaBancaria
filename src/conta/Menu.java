package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;


public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		Scanner sc = new Scanner(System.in);
		
		int opc, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana Rios", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Paes", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
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
			
			try {
				opc = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opc=0;
			}
			
			if (opc == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				sc.close();
				System.exit(0);
			}
			
			switch (opc) {
			
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				
				System.out.println("Digite o número da Agência: ");
				agencia = sc.nextInt();
				
				System.out.println("Digite o nome do Titular: ");
				sc.skip("\\R");
				titular = sc.nextLine();
				
				do {
					System.out.println("Digite o tipo da Conta (1 - CC ou 2 - CP): ");
					tipo = sc.nextInt();
				} while (tipo < 1 || tipo > 2);
				
				System.out.println("Digite o Saldo da conta: ");
				saldo = sc.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = sc.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = sc.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
				
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Contar - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o número da Agência: ");
					agencia = sc.nextInt();
					
					System.out.println("Digite o nome do Titular: ");
					sc.skip("\\R");
					titular = sc.nextLine();
					
					System.out.println("Digite o Saldo da conta (R$): ");
					saldo = sc.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o limite de crédito (R$): ");
							limite = sc.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do aniversário da conta: ");
							aniversario = sc.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						} 
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
					}
					
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				
				keyPress();
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.println("Digite o valor do depósito (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);
				
				contas.depositar(numero, valor);;
				
				keyPress();
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = sc.nextInt();
				
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = sc.nextInt();
				
				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
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

	public static void keyPress() {

	try {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		System.in.read();
	} catch (IOException e) {
		System.out.println("Você pressionou uma tecla diferente de enter!");
	}
	}
}

