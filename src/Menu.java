import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static SistemaEstoque menu = new SistemaEstoque();
	
	public static void main(String[] args) {
		
		menu_principal();
		}
	// MENU PRINCIPAL
	static void menu_principal() {
		System.out.println("############### SISTEMA DE ESTOQUE ###############");
		System.out.println("----------------- MENU PRINCIPAL -----------------");
		System.out.println(" 1  | Opera��es com Armazem");
		System.out.println(" 2  | Opera��es com Veiculos de um Armazem");
		System.out.println(" 3  | Relatorios do Sistema");
		System.out.println(" -1 | Finalizar o Sistema de Estoque.");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt(); 
			
			if(entrada == -1) {
				System.out.println("\n############### SISTEMA FINALIZADO ###############");
				System.exit(1);
			}
	
			else if(entrada == 1) {
				menu_armazem();
			}
			else if(entrada == 2) {
				menu_veiculo();
			}
			else if(entrada == 3) {
				menu_relatorio();
			}
			else if (entrada >= 4) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_principal();
			}
			else if (entrada <-1 ) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_principal();
			}
		
		} catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_principal();
		}
		
		
	}

	
	// OPERA��O COM ARMAZ�M
	
	// OP��O 1 | ARMAZENS
	static void menu_armazem() {
		System.out.println("--------------------------------------------------");
		System.out.println("Quais das opera��es desej� realizar com o armazem?");
		System.out.println(" 1 | Criar Armazem");
		System.out.println(" 2 | Remover Armazem");
		System.out.println(" 3 | Descri��o dos Armazens");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt(); 
			if(entrada == 1) {
				menu_armazem_criar();
			}
			else if(entrada == 2) {
				menu_armazem_remover();
			}
			else if(entrada == 3) {
				menu_armazem_descricao(0);
			}
			else if(entrada == 0) {
				System.out.println("\nOpera��o cancelada!\n");
				menu_principal();
			}
			else if (entrada >= 4) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_armazem();
			}
			else if (entrada < 0 ) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_armazem();
			}
			
		}catch (InputMismatchException e) {
				System.out.println("Entrada invalida, selecine as op��es validas\n");
				sc.nextLine();
				menu_armazem();
			}
	}

	// OP��O 1 | ARMAZENS | CRIAR ARMAZENS
	static void menu_armazem_criar() {
		System.out.println("--------------------------------------------------");
		System.out.println("Existem tr�s tipos de armazens, quais deles voc� desej� criar?");
		System.out.println(" 1 | Armazem Proprio");
		System.out.println(" 2 | Armazem Contratado");
		System.out.println(" 3 | Armazem Terceirizado");
		System.out.println(" 4 | Ver descri��o dos armazem");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt(); 
			if(entrada == 1) {
				menu_armazem_criar_proprio();
			}
			else if(entrada == 2) {
				menu_armazem_criar_contratado();
			}
			else if(entrada == 3) {
				menu_armazem_criar_tercerizado();
			}
			else if(entrada == 4) {
				menu_armazem_descricao(1);
			}
			else if(entrada == 0) {
				menu_principal();
			}
			else if (entrada > 4) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_principal();
			}
			else if (entrada <-0 ) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_principal();
			}
		}catch  (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_armazem();
		}
	}
	// OP��O 1 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM PROPRIO
	static void menu_armazem_criar_proprio() {
		System.out.println("Qual � o nome do seu armazem?");
		String armazem = sc.next();
		verificarExistenciaArmazem_EXISTE(menu.armazens.get(armazem));
		
		double tamanho=0;
		int verific = 0;
		
		do {
			try {
				System.out.println("Qual � o tamanho do seu armazem?");
				tamanho = sc.nextDouble();
				if(tamanho == 0)menu_principal();
				else if(tamanho>0);
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo flutuante.\n"
						+ "Observa��o: N�o utilize '.' para indicar um valor flutuante, utilize virgula ','\n"
						+ "Se deseja cancelar essa opera��o, insira o valor 0");
			}
			sc.nextLine();
		}while(verific==0);

		
		menu.criarArmazemProprio(armazem, tamanho);
		menu_principal();
	}
	// OP��O 2 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM CONTRATADO
	static void menu_armazem_criar_contratado() {
		System.out.println("Qual � o nome do seu armazem?");
		String armazem = sc.next();
		verificarExistenciaArmazem_EXISTE(menu.armazens.get(armazem));
		
		double tamanho=0;
		int verific = 0;
		
		do {
			try {
				System.out.println("Qual � o tamanho do seu armazem?");
				tamanho = sc.nextDouble();
				if(tamanho == 0)menu_principal();
				else if(tamanho>0);
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo flutuante.\n"
						+ "Observa��o: N�o utilize '.' para indicar um valor flutuante, utilize virgula ','\n"
						+ "Se deseja cancelar essa opera��o, insira o valor 0");
			}
			sc.nextLine();
		}while(verific==0);

		
		menu.criarArmazemContratado(armazem, tamanho);
		menu_principal();
	}
	// OP��O 3 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM TERCEIRIZADO
	static void menu_armazem_criar_tercerizado() {
		System.out.println("Qual � o nome do seu armazem?");
		String armazem = sc.next();
		verificarExistenciaArmazem_EXISTE(menu.armazens.get(armazem));
		menu.criarArmazemTerceirizado(armazem);
		menu_principal();
	}
	
	
	// OP��O 2 | ARMAZENS | REMOVER ARMAZEM
	static void menu_armazem_remover() {
		System.out.println("*Se remover o armazem ir� perder todos dados contidos nele.");
		System.out.println("Informe qual o nome do armaz�m que deseja remover:");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		menu.removerArmazem(armazem);
		menu_principal();
	}
	
	// OP��O 3 | ARMAZENS | DESCRICAO ARMAZENS
	static void menu_armazem_descricao(int nav){
		System.out.println("--------------------------------------------------");
		System.out.println("Em nosso Sistema de Estoque, pode possuir 3 tipos de armaz�ns: pr�prio, contratado e terceirizado.");
		System.out.println("------------------------------------ Pr�prio  ------------------------------------");
		System.out.println(" O armaz�m pr�pio, como o nome j� diz, � o armaz�m em que a empresa possu�.Em um \narmaz�m pr�pio n�o temos custo em adicionar um ve�culo por�m, teremos um tamanho, \nsendo assim, podemos adicionar o maximo de ve�culo de acordo com esse tamanho.");
		System.out.println("----------------------------------- Contratado -----------------------------------");
		System.out.println(" O armaz�m contratado � um armaz�m onde contratamos um espa�o para deixar o(s) vei-\nculo(s) da empresa. Em um armaz�m contratado alugamos um tamanho, sendo assim, po-\ndemos adicionar o maximo de ve�culo de acordo com esse tamanho.  \n Valor unit�rio por vaga: 100,00");
		System.out.println("---------------------------------- Terceirizado ----------------------------------");
		System.out.println(" O armaz�m terceirizado � um armaz�m onde contratamos uma empresa para armazenar nos-\nso ve�culo. Nesse tipo de armaz�m, a empresa ir� cobrar por ve�culo adicionado. \n Valor unit�rio da moto  : 100,00 \n Valor unit�rio do carro : 200,00 \n Valor unit�rio do onibus: 600,00");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1 | Ver descri��o dos veiculos");
		System.out.println(" 9 | Voltar");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		
		
		try {
			int entrada = sc.nextInt();
			if(entrada == 9) {
				if (nav==0)	menu_armazem();
				else if(nav==1)menu_armazem_criar();
				else if(nav==2)menu_veiculo_adicionar_descricao(nav,nav);
			}
			else if(entrada == 0) {
				menu_principal();
			}
			else if(entrada == 1) {
				menu_veiculo_adicionar_descricao(1,nav);
			}
			
			else if (entrada > 1 ) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_armazem_descricao(nav);
			}
			else if (entrada < 0 ) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_armazem_descricao(nav);
			}
		}catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			
			menu_armazem_descricao(nav);
		}
	}

	
	
	// OPERA��O COM VEICULO
	
	
	// OP��O 2 | VEICULOS
	static void menu_veiculo() {
		System.out.println("--------------------------------------------------");
		System.out.println(" 1 | Adicionar v�iculos no armazem");
		System.out.println(" 2 | Remover v�iculos no armazem");		
		System.out.println(" 3 | Recuperar v�iculos removidos do armazem");
		System.out.println(" 4 | Limpar hist�rico de veiculos removidos");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt();
			
			if(entrada == 0) menu_principal();
			
			else if (entrada == 1) menu_veiculo_adicionar();
			
			else if (entrada == 2) menu_veiculo_remover();
			
			else if (entrada == 3) menu_veiculo_recuperar();
			
			else if (entrada == 4) menu_veiculo_limparH();
			
			else if (entrada > 4) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_veiculo();
			}
			
			else if(entrada < 0) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_veiculo();
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_veiculo();
		}
	}

	// OP��O 1 | VEICULOS | ADICIONAR 
	static void menu_veiculo_adicionar() {
		System.out.println("--------------------------------------------------");
		System.out.println(" Que tipo de veiculo deseja adicionar?");
		System.out.println(" 1 | Adicionar moto no armazem");
		System.out.println(" 2 | Adicionar carro no armazem");
		System.out.println(" 3 | Adicionar onibus no armazem");
		System.out.println(" 4 | Ver descriss�o dos veiculos");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt();
			
			if (entrada == 0) menu_principal();
			
			else if (entrada ==1) menu_veiculo_adicionar_moto();
			
			else if (entrada ==2) menu_veiculo_adicionar_carro();
			
			else if (entrada ==3) menu_veiculo_adicionar_onibus();
			
			else if (entrada ==4) menu_veiculo_adicionar_descricao(0,0);
			
			else if (entrada < 0) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_veiculo_adicionar();
			}
			
			else if (entrada > 4) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_veiculo_adicionar();
			}
			
			else if(entrada < 0) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_veiculo_adicionar();
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_veiculo_adicionar();
		}
	}
	// OP��O 1 | VEICULOS | ADICIONAR | MOTO
	static void menu_veiculo_adicionar_moto() {
		System.out.println("Qual � o armazem que deseja adicionar a moto? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		
		System.out.println("Qual � o modelo da moto? ");
		String modelo = sc.next();
		
		int ano=0;
		int verific = 0;
		
		do {
			try {
				System.out.println("Qual � o ano? ");
				ano = sc.nextInt();
				if(ano ==-1)menu_principal();
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo inteiro.\n"
						+ "Se deseja cancelar essa opera��o, insira o valor -1");
			}
			sc.nextLine();
		}while(verific==0);

		System.out.println("Qual � a placa da moto? ");
		String placa = sc.next();
		verificarExistenciaPlaca_EXISTE(menu.armazens.get(armazem).veiculos.get(placa));
		
		float preco = 0;
		verific = 0;
		do {
			try {
				System.out.println("Qual � o pre�o da moto? ");
				preco = sc.nextFloat();
				if(ano ==-1)menu_principal();
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo flutuante.\n"
						+ "Observa��o: N�o utilize '.' para indicar um valor flutuante, utilize virgula ','\n"
						+ "Se deseja cancelar essa opera��o, insira o valor -1");
			}
			sc.nextLine();
		}while(verific==0);

		menu.adicionarMoto(armazem, modelo, ano, placa, preco);
		menu_principal(); 
	}
	// OP��O 2 | VEICULOS | ADICIONAR | CARRO
	static void menu_veiculo_adicionar_carro() {
		System.out.println("Qual � o armazem que deseja adicionar o carro? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		System.out.println("Qual � o modelo do carro? ");
		String modelo = sc.next();
		
		
		int ano=0;
		int verific = 0;
		
		do {
			try {
				System.out.println("Qual � o ano? ");
				ano = sc.nextInt();
				if(ano ==-1)menu_principal();
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo inteiro.\n"
						+ "Se deseja cancelar essa opera��o, insira o valor -1");
			}
			sc.nextLine();
		}while(verific==0);

		System.out.println("Qual � a placa do carro? ");
		String placa = sc.next();
		verificarExistenciaPlaca_EXISTE(menu.armazens.get(armazem).veiculos.get(placa));
		
		float preco = 0;
		verific = 0;
		do {
			try {
				System.out.println("Qual � o pre�o do carro? ");
				preco = sc.nextFloat();
				if(ano ==-1)menu_principal();
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo flutuante.\n"
						+ "Observa��o: N�o utilize '.' para indicar um valor flutuante, utilize virgula ','\n"
						+ "Se deseja cancelar essa opera��o, insira o valor -1");
			}
			sc.nextLine();
		}while(verific==0);
		
		menu.adicionarCarro(armazem, modelo, ano, placa, preco);
		menu_principal();
	}
	// OP��O 3 | VEICULOS | ADICIONAR | ONIBUS	
	static void menu_veiculo_adicionar_onibus() {
		System.out.println("Qual � o armazem que deseja adicionar o onibus? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		System.out.println("Qual � o modelo do onibus? ");
		String modelo = sc.next();
		
		int ano=0;
		int verific = 0;
		
		do {
			try {
				System.out.println("Qual � o ano? ");
				ano = sc.nextInt();
				if(ano ==-1)menu_principal();
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo inteiro.\n"
						+ "Se deseja cancelar essa opera��o, insira o valor -1");
			}
			sc.nextLine();
		}while(verific==0);

		System.out.println("Qual � a placa do onibus? ");
		String placa = sc.next();
		verificarExistenciaPlaca_EXISTE(menu.armazens.get(armazem).veiculos.get(placa));
		
		float preco = 0;
		verific = 0;
		do {
			try {
				System.out.println("Qual � o pre�o do onibus? ");
				preco = sc.nextFloat();
				if(ano ==-1)menu_principal();
				else verific=1;
			}catch (InputMismatchException e) {
				System.out.println("Entrada inv�lida. Por favor, insira uma entrada do tipo flutuante.\n"
						+ "Observa��o: N�o utilize '.' para indicar um valor flutuante, utilize virgula ','\n"
						+ "Se deseja cancelar essa opera��o, insira o valor -1");
			}
			sc.nextLine();
		}while(verific==0);

		menu.adicionarOnibus(armazem, modelo, ano, placa, preco);
		menu_principal();
}
	// OP��O 4 | VEICULOS | ADICIONAR | DESCRICAO
	static void menu_veiculo_adicionar_descricao(int nav, int aux_nav) {
		System.out.println("--------------------------------------------------");
		System.out.println("Todos os veiculos dos sistema possui os seguintes atributos: \n ~Placa. \n ~Modelo. \n ~Ano. \n ~Pre�o \n ~Vaga.");
		System.out.println("Em nosso Sistema de Estoque, pode possuir 3 tipos de ve�culos: moto, carro e onibus.");
		System.out.println("A tabela abaixo ilustra quais s�o as diferen�as entre os tipos de veiculos");
		System.out.println("-------------------------------------- Moto --------------------------------------");
		System.out.println(" Vaga ocupada: 0.5");	
		System.out.println("-------------------------------------- Carro -------------------------------------");
		System.out.println(" Vaga ocupada: 2");	
		System.out.println("------------------------------------- Onibus -------------------------------------");
		System.out.println(" Vaga ocupada: 6");	
		System.out.println("--------------------------------------------------");
		System.out.println(" 9 | Voltar");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt();
			
			if(entrada == 9) {
				if (nav==0)	menu_veiculo_adicionar();
				else if(nav!=0)menu_armazem_descricao(aux_nav);
			}
			else if(entrada == 0) {
				menu_principal();
			}
			else if (entrada > 9) {
				System.out.println("Entrada invalida, selecine as op��es validas\n");
				menu_veiculo_adicionar_descricao(nav,aux_nav);
				
			}
			else if (entrada < 0) {
				System.out.println("Entrada invalida, selecine as op��es validas\n");
				menu_veiculo_adicionar_descricao(nav,aux_nav);
				
			}
			
			else if (entrada > 0 && entrada < 9 ) {
				System.out.println("Entrada invalida, selecine as op��es validas\n");
				menu_veiculo_adicionar_descricao(nav,aux_nav);
				
			}
		}catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_veiculo_adicionar_descricao(nav,aux_nav);
		}
	}
	
	// OP��O 2 | VEICULOS | REMOVER 
	static void menu_veiculo_remover() {
		System.out.println("Qual armazem se encontra o veiculo?");
		String nome_armazem = sc.next();		
		verificarExistenciaArmazem(menu.armazens.get(nome_armazem));
		System.out.println("Qual a placa do veiculo que deseja remover?");
		String placa_veiculo = sc.next();
		verificarExistenciaPlaca(menu.armazens.get(nome_armazem).veiculos.get(placa_veiculo));
	
		System.out.println("Tem certeza que deseja remover o veiculo?");
		System.out.println("Pressione 1 para confirmar. . .");
		
		int entrada = sc.nextInt();

		if(entrada == 1) {
			menu.removerVeiculo(nome_armazem, placa_veiculo);
			System.out.println("Ve�culo removido com sucesso!");
			menu_principal();
		}else {
			System.out.println("Ve�culo n�o removido");
			menu_principal();
		}
	}

	// OP��O 3 | VEICULOS | RECUPERAR 
	static void menu_veiculo_recuperar() {
		System.out.println("Qual armazem se encontra o veiculo removido?");
		String armazem = sc.next();		
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		System.out.println("Qual � a placa do veiculo que deseja ser recuperado?");
		String placa = sc.next();
		verificarExistenciaPlaca(menu.armazens.get(armazem).veiculos_removidos.get(placa));
		menu.recuperarVeiculo(armazem, placa);
		menu_principal();
	}
	
	// OP��O 4 | VEICULOS | LIMPAR HISTORICO 
	static void menu_veiculo_limparH() {
		System.out.println("--------------------------------------------------");
		System.out.println("*Ir� limpar permanentemente.");
		System.out.println(" 1 | Limpar um unico veiculos removido do armazem");
		System.out.println(" 2 | Limpar todo hist�rico de veiculos removidos do armazem");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");	
		
		try {
			int entrada = sc.nextInt();
			
			if (entrada == 0) menu_principal();
			
			else if(entrada == 1) menu_veiculo_limparH_unidade();
			
			else if(entrada == 2) menu_veiculo_limparH_total();
			
			else if(entrada > 3) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_veiculo_limparH();
			}
		} catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_veiculo_adicionar();
		}
	}
	// OP��O 1 | VEICULOS | LIMPAR HISTORICO | UNIDADE
	static void menu_veiculo_limparH_unidade() {
		System.out.println("Qual � o armaz�m que deseja retirar o ve�culo do hist�rico de removidos?");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		System.out.println("Qual � a placa do veiculo que deseja retirar do hist�rico de removido?");
		String placa = sc.next();
		verificarExistenciaPlaca(menu.armazens.get(armazem).veiculos_removidos.get(placa));
		
		System.out.println("Tem certeza que deseja remover o veiculo do hist�rico de removidos?");
		System.out.println("Pressione 1 para confirmar. . .");
		int entrada = sc.nextInt();

		if(entrada == 1) {
			menu.limparRemovidosUnidade(armazem, placa);
			System.out.println("Ve�culo removido do hist�rico com sucesso!");
			menu_principal();
		}else {
			System.out.println("Ve�culo n�o removido do hist�rico de removidos");
			menu_principal();
		}
		
	}
	// OP��O 2 | VEICULOS | LIMPAR HISTORICO | TOTAL
	static void menu_veiculo_limparH_total() {
		System.out.println("Qual � o armaz�m que deseja limpar o hist�rico?");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));

		System.out.println("Tem certeza que deseja limpar o hist�rico de removidos?");
		System.out.println("Pressione 1 para confirmar. . .");
		int entrada = sc.nextInt();

		if(entrada == 1) {
			menu.limparRemovidosTotal(armazem);
			System.out.println("Hist�rico limpo com sucesso!");
			menu_principal();
		}else {
			System.out.println("Hist�rico n�o foi limpo!");
			menu_principal();
		}
	}


	// RELAT�RIOS
	
	// OP��O 3 | RELAT�RIO 
	static void menu_relatorio() {
		System.out.println("--------------------------------------------------");
		System.out.println(" 1 | Relat�rio dos v�iculos no armazem");
		System.out.println(" 2 | Relat�rio de todos veiculos do armaz�m");
		System.out.println(" 3 | Relat�rio do armaz�m");
		System.out.println(" 4 | Relat�rio total");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		try {
			int entrada = sc.nextInt();
			
			if(entrada == 0) {
				System.out.println("\nOpera��o cancelada!\n");
				menu_principal();
			}
			else if(entrada == 1)menu_relatorio_dados();
	
			else if(entrada == 2)menu_relatorio_veiculoArmazem();
	
			else if(entrada == 3)menu_relatorio_armazem();
			
			else if(entrada == 4)menu_relatorio_total();
			
			else if (entrada > 4) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_relatorio();
			}
			
			else if(entrada < 0) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_relatorio();
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_relatorio();
		}
	}

	// OP��O 1 | RELAT�RIO | DADOS VEICULO 
	static void menu_relatorio_dados() {
		System.out.println("--------------------------------------------------");
		System.out.println(" 1 | Dados do veiculo do armaz�m");
		System.out.println(" 2 | Dados do veiculo removido do armaz�m");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");	
		
		try {
			int entrada = sc.nextInt();
			
			if (entrada == 0) menu_principal();
			
			else if(entrada == 1) menu_relatorio_dados_veiculo();
			else if(entrada == 2) menu_relatorio_dados_veiculoRemovido();
			
			else if (entrada < 0) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_relatorio_dados();
			}
			
			else if (entrada > 2) {
				System.out.println("Voc� inseriu uma entrada n�o existente, por favor selecione as op��es validas\n");
				menu_relatorio_dados();
			}
		}catch (InputMismatchException e) {
			System.out.println("Entrada invalida, selecine as op��es validas\n");
			sc.nextLine();
			menu_relatorio_dados();
		}
	}
	// OP��O 1 | RELAT�RIO | DADOS VEICULO | CONTIDO NO ARMAZEM
	static void menu_relatorio_dados_veiculo() {
		System.out.println("Qual � o armazem que est� contido o ve�culo? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		System.out.println("Qual � a placa do ve�culo? ");
		String placa = sc.next();
		verificarExistenciaPlaca(menu.armazens.get(armazem).veiculos.get(placa));
		menu.dadosVeiculo(armazem, placa);
		menu_principal();
	}
	// OP��O 2 | RELAT�RIO | DADOS VEICULO | REMOVIDO DO ARMAZEM
	static void menu_relatorio_dados_veiculoRemovido() {
		System.out.println("Qual � o armazem que estava contido o ve�culo? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		System.out.println("Qual � era placa do ve�culo? ");
		String placa = sc.next();
		verificarExistenciaPlaca(menu.armazens.get(armazem).veiculos.get(placa));
		menu.dadosVeiculoRemovido(armazem, placa);
		menu_principal();
	}
	
	
	// OP��O 2 | RELAT�RIO | VEICULOS ARMAZEM 
	static void menu_relatorio_veiculoArmazem() {
		System.out.println("Qual � o armazem que deseja emitir o relat�rio de veiculos? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		menu.relatorioVeiculosArmazem(armazem);
		menu_principal();
	}
	
	// OP��O 3 | RELAT�RIO | ARMAZEM 
	static void menu_relatorio_armazem() {
		System.out.println("Qual � o armazem que deseja emitir o relat�rio? ");
		String armazem = sc.next();
		verificarExistenciaArmazem(menu.armazens.get(armazem));
		menu.relatorioArmazem(armazem);
		menu_principal();
	}
	
	// OP��O 4 | RELAT�RIO | TOTAL 
	static void menu_relatorio_total() {
		menu.relatorioTotal();
		menu_principal();
	}
	

	
	// VERIFICANDO
	
	static private void verificarExistenciaArmazem(Armazem armazem) {
		if (armazem == null) {
			System.out.println("O armaz�m inexistente!!");
			menu_principal();
		}
	}
	static private void verificarExistenciaPlaca(Veiculo veiculo) {
		if (veiculo == null) {
			System.out.println("O veiculo inexistente!!");
			menu_principal();
		}
	}
	static private void verificarExistenciaPlaca_EXISTE (Veiculo veiculo) {
		if (veiculo != null) {
			System.out.println("A placa do veiculo condiz com um veiculo existente no sistema!!"
					+ "\nN�o foi poss�vel adicionar este veiculo no armaz�m.");
			menu_principal();
		}
	}
	static private void verificarExistenciaArmazem_EXISTE (Armazem armazem) {
		if (armazem != null) {
			System.out.println("O nome do armazem condiz com um armazem existente no sistema!!");
			menu_principal();
		}
	}
	
	

	
	
}
