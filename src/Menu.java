
public class Menu {

	public static void main(String[] args) {
		SistemaEstoque menu = new SistemaEstoque();

		
		menu.criarArmazemTerceirizado("Eduardo");
		menu.criarArmazemContratado("Gabriel",20);

		menu.adicionarMoto("Eduardo", "Bis", 2000, "ABC-1234", 500.00);
		menu.adicionarCarro("Eduardo", "Celta", 2019, "FODA-9924", 50.00);
		menu.adicionarOnibus("Eduardo", "Onibus", 2022, "EOF-3259", 100.000);
		menu.removerVeiculo("Eduardo", "FODA-9924");
		menu.relatorioArmazem("Eduardo");
		System.out.println(" ...... ");
		menu.relatorioTotal();
	}

}
