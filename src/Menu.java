import java.util.Scanner;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static SistemaEstoque menu = new SistemaEstoque();
	
	public static void main(String[] args) {
		menu_principal();
		
		}
	
	static void menu_principal() {
		System.out.println(" 1  | Operações com armazem");
		System.out.println(" 2  | Operaçõesc com véiculos de um armazem");
		System.out.println(" 3  | Relatorios do Sistema");
		System.out.println(" -1 | Finalizar o sistema de estoque.");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt(); 
		
		if(entrada == -1);
		
		else if(entrada == 1) {
			menu_armazem();
		}
		else if(entrada == 2) {
			menu_veiculo();
		}
		

	}
	
	// OPÇÃO 1 | ARMAZENS
	static void menu_armazem() {
		System.out.println("Quais das operações desejá realizar com o armazem?");
		System.out.println(" 1 | Criar Armazem");
		System.out.println(" 2 | Remover Armazem");
		System.out.println(" 3 | Ver descrição dos armazem");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt(); 
		if(entrada == 1) {
			menu_armazem_criar();
		}
		else if(entrada == 2) {
			menu_armazem_remover();
		}
		else if(entrada == 3) {
			menu_armazem_criar_decricao();
		}
		else if(entrada == 0) {
			menu_principal();
		}
		/*
		menu.criarArmazemTerceirizado("Eduardo");
		menu.criarArmazemContratado("Gabriel",20);

		menu.adicionarMoto("Eduardo", "Bis", 2000, "ABC-1234", 500.00);
		menu.adicionarCarro("Eduardo", "Celta", 2019, "FOA-9924", 50.00);
		menu.adicionarOnibus("Eduardo", "Onibus", 2022, "EOF-3259", 100.000);
		menu.adicionarCarro("Eduardo","CeltINHAA", 2020, "ABC-3125", 0);
		
		menu.adicionarMoto("Eduardo", "Bis", 2000, "ABC-2523", 500.00);
		menu.adicionarCarro("Eduardo", "Celta", 2019, "FOA-5412", 50.00);
		menu.adicionarOnibus("Eduardo", "Onibus", 2022, "EOF-3215", 100.000);
		menu.adicionarCarro("Eduardo","CeltINHAA", 2020, "ABC-4215", 0);		
		
		menu.removerVeiculo("Eduardo","FOA-5412");
		menu.removerVeiculo("Eduardo", "EOF-3215");
		menu.removerVeiculo("Eduardo", "ABC-4215");		
		
		menu.adicionarOnibus("Gabriel", "Escolar", 2000, "BOB-0000", 300.00);
		//menu.relatorioVeiculosArmazem("Eduardo");
		menu.limparRemovidosTotal("Eduardo");
		//menu.relatorioVeiculosArmazem("Eduardo");
		//menu.relatorioTotal();
		menu.removerVeiculo("Eduardo", "ABC-1234");		
		
		
		menu.relatorioVeiculosArmazem("Eduardo");
		
		menu.dadosVeiculoRemovido("Eduardo", "ABC-1234");
		
		menu.recuperarVeiculo("Eduardo", "ABC-1234");
		
		menu.relatorioVeiculosArmazem("Eduardo");
		
		menu.dadosVeiculo("Eduardo", "ABC-1234");
		
		//menu.relatorioArmazem("Gabriel");
		 * 
		 */
	}

	// OPÇÃO 1 | ARMAZENS | CRIAR ARMAZENS
	static void menu_armazem_criar() {
		System.out.println("Existem três tipos de armazens, quais deles você desejá criar?");
		System.out.println(" 1 | Armazem Proprio");
		System.out.println(" 2 | Armazem Contratado");
		System.out.println(" 3 | Armazem Terceirizado");
		System.out.println(" 4 | Ver descrição dos armazem");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
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
			menu_armazem_criar_decricao();
		}
		else if(entrada == 0) {
			menu_principal();
		}
	}
	// OPÇÃO 1 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM PROPRIO
	static void menu_armazem_criar_proprio() {
		System.out.println("Qual é o nome do seu armazem?");
		String nome = sc.next();
		System.out.println("Qual é o tamanho do seu armazem?");
		double tamanho = sc.nextDouble();
		menu.criarArmazemProprio(nome, tamanho);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OPÇÃO 2 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM CONTRATADO
	static void menu_armazem_criar_contratado() {
		System.out.println("Qual é o nome do seu armazem?");
		String nome = sc.next();
		System.out.println("Qual é o tamanho que deseja alugar um armazem contratado?");
		double tamanho = sc.nextDouble();
		menu.criarArmazemContratado(nome, tamanho);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OPÇÃO 3 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM TERCEIRIZADO
	static void menu_armazem_criar_tercerizado() {
		System.out.println("Qual é o nome do seu armazem?");
		String nome = sc.next();
		menu.criarArmazemTerceirizado(nome);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	
	
	// OPÇÃO 2 | ARMAZENS | REMOVER ARMAZEM
	static void menu_armazem_remover() {
		System.out.println("*Se remover o armazem irá perder todos dados contidos nele.");
		System.out.println("Informe qual o nome do armazém que deseja remover:");
		String armazem = sc.next();
		menu.removerArmazem(armazem);
		menu_principal();
	}
	
	// OPÇÃO 3 | ARMAZENS | DESCRICAO ARMAZENS
	static void menu_armazem_criar_decricao(){
		System.out.println("Monstra as diferenças entre os tipos de armazen");
		System.out.println(" 9 | Voltar");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if(entrada == 9) {
			menu_armazem();
		}
		else if(entrada == 0) {
			menu_principal();
		}
	}

	
	// OPÇÃO 2 | VEICULOS
	static void menu_veiculo() {
		System.out.println(" 1 | Adicionar véiculos no armazem");
		System.out.println(" 2 | Remover véiculos no armazem");		
		System.out.println(" 3 | Recuperar véiculos removidos do armazem");
		System.out.println(" 4 | Ver dados dos véiculos no armazem");
		System.out.println(" 5 | Limpar histórico de veiculos removidos");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if(entrada == 0) menu_principal();
		
		else if (entrada == 1) menu_veiculo_adicionar();
		
		else if (entrada == 2) menu_veiculo_remover();
		
		else if (entrada == 3) menu_veiculo_recuperar();
		
		else if (entrada == 4) menu_veiculo_dados();
		
		else if (entrada == 5) menu_veiculo_limparH();
	}

	// OPÇÃO 1 | VEICULOS | ADICIONAR 
	static void menu_veiculo_adicionar() {
		System.out.println(" Que tipo de veiculo deseja adicionar?");
		System.out.println(" 1 | Adicionar moto no armazem");
		System.out.println(" 2 | Adicionar carro no armazem");
		System.out.println(" 3 | Adicionar onibus no armazem");
		System.out.println(" 4 | Ver descrissão dos veiculos");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if (entrada == 0) menu_principal();
		
		else if (entrada ==1) menu_veiculo_adicionar_moto();
		
		else if (entrada ==1) menu_veiculo_adicionar_carro();
		
		else if (entrada ==1) menu_veiculo_adicionar_onibus();
		
		else if (entrada ==1) menu_veiculo_adicionar_descrisao();
	}
	// OPÇÃO 1 | VEICULOS | ADICIONAR | MOTO
	static void menu_veiculo_adicionar_moto() {
		System.out.println("Qual é o armazem que deseja adicionar a moto? ");
		String armazem = sc.next();
		System.out.println("Qual é o modelo da moto? ");
		String modelo = sc.next();
		System.out.println("Qual é o ano? ");
		int ano = sc.nextInt();
		System.out.println("Qual é a placa da moto? ");
		String placa = sc.next();
		System.out.println("Qual é o preço da moto? ");
		float preco = sc.nextFloat();
		menu.adicionarMoto(armazem, modelo, ano, placa, preco);
		 
		System.out.println("Moto adicionada com sucesso!");
		menu_principal();
	}
	// OPÇÃO 2 | VEICULOS | ADICIONAR | CARRO
	static void menu_veiculo_adicionar_carro() {
		System.out.println("Qual é o armazem que deseja adicionar o carro? ");
		String armazem = sc.next();
		System.out.println("Qual é o modelo do carro? ");
		String modelo = sc.next();
		System.out.println("Qual é o ano? ");
		int ano = sc.nextInt();
		System.out.println("Qual é a placa do carro? ");
		String placa = sc.next();
		System.out.println("Qual é o preço do carro? ");
		double preco = sc.nextDouble();
		menu.adicionarCarro(armazem, modelo, ano, placa, preco);
		
		System.out.println("Carro adicionado com sucesso!");
		menu_principal();
	}
	// OPÇÃO 3 | VEICULOS | ADICIONAR | ONIBUS	
	static void menu_veiculo_adicionar_onibus() {
		System.out.println("Qual é o armazem que deseja adicionar o onibus? ");
		String armazem = sc.next();
		System.out.println("Qual é o modelo do onibus? ");
		String modelo = sc.next();
		System.out.println("Qual é o ano? ");
		int ano = sc.nextInt();
		System.out.println("Qual é a placa do onibus? ");
		String placa = sc.next();
		System.out.println("Qual é o preço do onibus? ");
		double preco = sc.nextDouble();
		menu.adicionarOnibus(armazem, modelo, ano, placa, preco);
		
		System.out.println("Onibus adicionada com sucesso!");
		menu_principal();
}
	// OPÇÃO 4 | VEICULOS | ADICIONAR | DESCRISAO
	static void menu_veiculo_adicionar_descrisao() {
		System.out.println("Monstra as diferenças entre os tipos de veiculos e as vagas e tals");
		System.out.println(" 9 | Voltar");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if(entrada == 9) {
			menu_veiculo();
		}
		else if(entrada == 0) {
			menu_principal();
		}
	}
	
	// OPÇÃO 2 | VEICULOS | REMOVER 
	static void menu_veiculo_remover() {
		System.out.println("Qual armazem se encontra o veiculo?");
		String nome_armazem = sc.next();		
		System.out.println("Qual a placa do veiculo que deseja remover?");
		String placa_veiculo = sc.next();
		
		menu.removerVeiculo(nome_armazem, placa_veiculo);
		System.out.println("Veiculo removido com sucesso!");
	}

	// OPÇÃO 3 | VEICULOS | RECUPERAR 
	static void menu_veiculo_recuperar() {
	
	}
	
	// OPÇÃO 4 | VEICULOS | DADOS VEICULO 
	static void menu_veiculo_dados() {
		
	// OPÇÃO 5 | VEICULOS | LIMPAR HISTORICO 
	}
	static void menu_veiculo_limparH() {
		
	}
}
