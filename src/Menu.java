import java.util.Scanner;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static SistemaEstoque menu = new SistemaEstoque();
	
	public static void main(String[] args) {
		menu_principal();
		
		}
	
	static void menu_principal() {
		System.out.println(" 1  | Criar um armazem");
		System.out.println(" 2  | Adicionar véiculos no armazem");
		System.out.println(" 3  | Remover véiculos no armazem");		
		System.out.println(" 4  | Recuperar véiculos removidos do armazem");
		System.out.println(" 5  | Limpar histórico de veiculos removidos");
		System.out.println(" 6  | Relatorios do Sistema");
		System.out.println(" -1 | Finalizar o sistema de estoque.");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt(); 
		
		if(entrada == -1);
		
		if(entrada == 1) {
			menu_armazem();
		}
		

	}
	
	// OPÇÃO 1 | CRIAR ARMAZEM
	static void menu_armazem() {
		System.out.println("Existem três tipos de armazens, quais deles você desejá criar?");
		System.out.println(" 1 | Armazem Proprio");
		System.out.println(" 2 | Armazem Contratado");
		System.out.println(" 3 | Armazem Terceirizado");
		System.out.println(" 4 | Ver descrição dos armazem");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt(); 
		if(entrada == 1) {
			menu_armazem_proprio();
		}
		else if(entrada == 2) {
			menu_armazem_contratado();
		}
		else if(entrada == 3) {
			menu_armazem_tercerizado();
		}
		else if(entrada == 4) {
			menu_armazem_decricao();
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

	// OPÇÃO 1 DO MENU ARMAZEM | ARMAZEM PROPRIO
	static void menu_armazem_proprio() {
		System.out.println("Qual é o nome do seu armazem?");
		String nome = sc.next();
		System.out.println("Qual é o tamanho do seu armazem?");
		double tamanho = sc.nextDouble();
		menu.criarArmazemProprio(nome, tamanho);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OPÇÃO 2 DO MENU ARMAZEM | ARMAZEM CONTRATADO
	static void menu_armazem_contratado() {
		System.out.println("Qual é o nome do seu armazem?");
		String nome = sc.next();
		System.out.println("Qual é o tamanho que deseja alugar um armazem contratado?");
		double tamanho = sc.nextDouble();
		menu.criarArmazemContratado(nome, tamanho);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OPÇÃO 3 DO MENU ARMAZEM | ARMAZEM TERCEIRIZADO
	static void menu_armazem_tercerizado() {
		System.out.println("Qual é o nome do seu armazem?");
		String nome = sc.next();
		menu.criarArmazemTerceirizado(nome);
		System.out.println("Armazem criado com sucesso!!");
		menu_principal();
	}
	// OPÇÃO 4 DO MENU ARMAZEM | DESCRISSAO DOS ARMAZENS
	static void menu_armazem_decricao(){
		System.out.println("Monstra as diferenças entre os tipos de armazen");
		System.out.println(" 1 | Voltar");
		System.out.println(" 0 | Cancelar operação");
		System.out.println("Selecione alguma das opções para continuar . . .");
		
		int entrada = sc.nextInt();
		
		if(entrada == 1) {
			menu_armazem();
		}
		else if(entrada == 0) {
			menu_principal();
		}
	}
}
