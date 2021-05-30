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
		System.out.println(" 1  | Opera��es com armazem");
		System.out.println(" 2  | Opera��es com v�iculos de um armazem");
		System.out.println(" 3  | Relatorios do Sistema");
		System.out.println(" -1 | Finalizar o sistema de estoque.");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		int entrada = sc.nextInt(); 
		
		if(entrada == -1) {
			System.out.println("Sistema Finalizado.");
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
		

	}
	
	
	// OPERA��O COM ARMAZ�M
	
	// OP��O 1 | ARMAZENS
	static void menu_armazem() {
		System.out.println("--------------------------------------------------");
		System.out.println("Quais das opera��es desej� realizar com o armazem?");
		System.out.println(" 1 | Criar Armazem");
		System.out.println(" 2 | Remover Armazem");
		System.out.println(" 3 | Ver descri��o dos armazem");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		
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
	// OP��O 1 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM PROPRIO
	static void menu_armazem_criar_proprio() {
		System.out.println("Qual � o nome do seu armazem?");
		String nome = sc.next();
		System.out.println("Qual � o tamanho do seu armazem?");
		double tamanho = sc.nextDouble();
		menu.criarArmazemProprio(nome, tamanho);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OP��O 2 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM CONTRATADO
	static void menu_armazem_criar_contratado() {
		System.out.println("Qual � o nome do seu armazem?");
		String nome = sc.next();
		System.out.println("Qual � o tamanho que deseja alugar um armazem contratado?");
		double tamanho = sc.nextDouble();
		menu.criarArmazemContratado(nome, tamanho);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OP��O 3 | ARMAZENS | CRIAR ARMAZENS | ARMAZEM TERCEIRIZADO
	static void menu_armazem_criar_tercerizado() {
		System.out.println("Qual � o nome do seu armazem?");
		String nome = sc.next();
		menu.criarArmazemTerceirizado(nome);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	
	
	// OP��O 2 | ARMAZENS | REMOVER ARMAZEM
	static void menu_armazem_remover() {
		System.out.println("*Se remover o armazem ir� perder todos dados contidos nele.");
		System.out.println("Informe qual o nome do armaz�m que deseja remover:");
		String armazem = sc.next();
		menu.removerArmazem(armazem);
		menu_principal();
	}
	
	// OP��O 3 | ARMAZENS | DESCRICAO ARMAZENS
	static void menu_armazem_criar_decricao(){
		System.out.println("--------------------------------------------------");
		System.out.println("Monstra as diferen�as entre os tipos de armazen");
		System.out.println(" 9 | Voltar");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if(entrada == 9) {
			menu_armazem();
		}
		else if(entrada == 0) {
			menu_principal();
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
		
		int entrada = sc.nextInt();
		
		if(entrada == 0) menu_principal();
		
		else if (entrada == 1) menu_veiculo_adicionar();
		
		else if (entrada == 2) menu_veiculo_remover();
		
		else if (entrada == 3) menu_veiculo_recuperar();
		
		else if (entrada == 4) menu_veiculo_limparH();
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
		
		int entrada = sc.nextInt();
		
		if (entrada == 0) menu_principal();
		
		else if (entrada ==1) menu_veiculo_adicionar_moto();
		
		else if (entrada ==2) menu_veiculo_adicionar_carro();
		
		else if (entrada ==3) menu_veiculo_adicionar_onibus();
		
		else if (entrada ==4) menu_veiculo_adicionar_descrisao();
	}
	// OP��O 1 | VEICULOS | ADICIONAR | MOTO
	static void menu_veiculo_adicionar_moto() {
		System.out.println("Qual � o armazem que deseja adicionar a moto? ");
		String armazem = sc.next();
		System.out.println("Qual � o modelo da moto? ");
		String modelo = sc.next();
		System.out.println("Qual � o ano? ");
		int ano = sc.nextInt();
		System.out.println("Qual � a placa da moto? ");
		String placa = sc.next();
		System.out.println("Qual � o pre�o da moto? ");
		float preco = sc.nextFloat();
		menu.adicionarMoto(armazem, modelo, ano, placa, preco);
		 
		System.out.println("Moto adicionada com sucesso!");
		menu_principal();
	}
	// OP��O 2 | VEICULOS | ADICIONAR | CARRO
	static void menu_veiculo_adicionar_carro() {
		System.out.println("Qual � o armazem que deseja adicionar o carro? ");
		String armazem = sc.next();
		System.out.println("Qual � o modelo do carro? ");
		String modelo = sc.next();
		System.out.println("Qual � o ano? ");
		int ano = sc.nextInt();
		System.out.println("Qual � a placa do carro? ");
		String placa = sc.next();
		System.out.println("Qual � o pre�o do carro? ");
		double preco = sc.nextDouble();
		menu.adicionarCarro(armazem, modelo, ano, placa, preco);
		
		System.out.println("Carro adicionado com sucesso!");
		menu_principal();
	}
	// OP��O 3 | VEICULOS | ADICIONAR | ONIBUS	
	static void menu_veiculo_adicionar_onibus() {
		System.out.println("Qual � o armazem que deseja adicionar o onibus? ");
		String armazem = sc.next();
		System.out.println("Qual � o modelo do onibus? ");
		String modelo = sc.next();
		System.out.println("Qual � o ano? ");
		int ano = sc.nextInt();
		System.out.println("Qual � a placa do onibus? ");
		String placa = sc.next();
		System.out.println("Qual � o pre�o do onibus? ");
		double preco = sc.nextDouble();
		menu.adicionarOnibus(armazem, modelo, ano, placa, preco);
		
		System.out.println("Onibus adicionada com sucesso!");
		menu_principal();
}
	// OP��O 4 | VEICULOS | ADICIONAR | DESCRISAO
	static void menu_veiculo_adicionar_descrisao() {
		System.out.println("--------------------------------------------------");
		System.out.println("Monstra as diferen�as entre os tipos de veiculos e as vagas e tals");
		System.out.println(" 9 | Voltar");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if(entrada == 9) {
			menu_veiculo();
		}
		else if(entrada == 0) {
			menu_principal();
		}
	}
	
	// OP��O 2 | VEICULOS | REMOVER 
	static void menu_veiculo_remover() {
		System.out.println("Qual armazem se encontra o veiculo?");
		String nome_armazem = sc.next();		
		System.out.println("Qual a placa do veiculo que deseja remover?");
		String placa_veiculo = sc.next();
	
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
		System.out.println("Qual � a placa do veiculo que deseja ser recuperado?");
		String placa = sc.next();
	
		menu.recuperarVeiculo(armazem, placa);
		System.out.println("Veiculo recuperado!");
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
		
		int entrada = sc.nextInt();
		
		if (entrada == 0) menu_principal();
		
		else if(entrada == 1) menu_veiculo_limparH_unidade();
		
		else if(entrada == 2) menu_veiculo_limparH_total();
	}
	// OP��O 1 | VEICULOS | LIMPAR HISTORICO | UNIDADE
	static void menu_veiculo_limparH_unidade() {
		System.out.println("Qual � o armaz�m que deseja retirar o ve�culo do hist�rico de removidos?");
		String armazem = sc.next();
		System.out.println("Qual � a placa do veiculo que deseja retirar do hist�rico de removido?");
		String placa = sc.next();
		
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
		
		int entrada = sc.nextInt();
		
		if(entrada == 0)menu_principal();
		
		else if(entrada == 1)menu_relatorio_dados();

		else if(entrada == 2)menu_relatorio_veiculoArmazem();

		else if(entrada == 3)menu_relatorio_armazem();
		
		else if(entrada == 4)menu_relatorio_total();
	}

	// OP��O 1 | RELAT�RIO | DADOS VEICULO 
	static void menu_relatorio_dados() {
		System.out.println("--------------------------------------------------");
		System.out.println(" 1 | Dados do veiculo do armaz�m");
		System.out.println(" 2 | Dados do veiculo removido do armaz�m");
		System.out.println(" 0 | Cancelar opera��o");
		System.out.println("--------------------------------------------------");
		System.out.println("Selecione alguma das op��es para continuar . . .");	
		
		int entrada = sc.nextInt();
		
		if (entrada == 0) menu_principal();
		
		else if(entrada == 1) menu_relatorio_dados_veiculo();
		else if(entrada == 2) menu_relatorio_dados_veiculoRemovido();
	}
	// OP��O 1 | RELAT�RIO | DADOS VEICULO | CONTIDO NO ARMAZEM
	static void menu_relatorio_dados_veiculo() {
		System.out.println("Qual � o armazem que est� contido o ve�culo? ");
		String armazem = sc.next();
		System.out.println("Qual � a placa do ve�culo? ");
		String placa = sc.next();
		menu.dadosVeiculo(armazem, placa);
		menu_principal();
	}
	// OP��O 2 | RELAT�RIO | DADOS VEICULO | REMOVIDO DO ARMAZEM
	static void menu_relatorio_dados_veiculoRemovido() {
		System.out.println("Qual � o armazem que estava contido o ve�culo? ");
		String armazem = sc.next();
		System.out.println("Qual � era placa do ve�culo? ");
		String placa = sc.next();
		menu.dadosVeiculoRemovido(armazem, placa);
		menu_principal();
	}
	
	
	// OP��O 2 | RELAT�RIO | VEICULOS ARMAZEM 
	static void menu_relatorio_veiculoArmazem() {
		System.out.println("Qual � o armazem que deseja emitir o relat�rio de veiculos? ");
		String armazem = sc.next();
		menu.relatorioVeiculosArmazem(armazem);
		menu_principal();
	}
	
	// OP��O 3 | RELAT�RIO | ARMAZEM 
	static void menu_relatorio_armazem() {
		System.out.println("Qual � o armazem que deseja emitir o relat�rio? ");
		String armazem = sc.next();
		menu.relatorioArmazem(armazem);
		menu_principal();
	}
	
	// OP��O 4 | RELAT�RIO | TOTAL 
	static void menu_relatorio_total() {
		menu.relatorioTotal();
		menu_principal();
	}
	

	
	
}
