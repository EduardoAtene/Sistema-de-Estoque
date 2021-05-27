import java.util.Map;
import java.util.HashMap;

public class SistemaEstoque {
	private int quantidade_total_armazem = 0;
	private int quantidade_total_proprio = 0;
	private int quantidade_total_terceirizado = 0;
	private int quantidade_total_contratado = 0;
	private int quantidade_tipos_armazens= 0;
	private int tipos_armazens[] = {0,0,0};
	//private int quantidade_total_veiculos = 0;
	
	Map <String,Armazem> armazens = new HashMap<>();

	
	// CRIAR / REMOVER ARMAZEM
	public void criarArmazemProprio(String nome,double tamanho) {
		Propio proprio = new Propio(nome,1,(float)tamanho);
		armazens.put(nome, proprio);
		quantidade_total_proprio++;
		quantidade_total_armazem++;
		if(tipos_armazens[0] == 0) {
			tipos_armazens[0] = 1;
			quantidade_tipos_armazens ++;
		}
	}

	public void criarArmazemContratado(String nome,double tamanho) {
		Contratado contratado = new Contratado(nome,2,tamanho);
		armazens.put(nome, contratado);
		quantidade_total_contratado++;
		quantidade_total_armazem++;
		if(tipos_armazens[0] == 0) {
			tipos_armazens[1] = 1;
			quantidade_tipos_armazens ++;
		}
	}
	
	public void criarArmazemTerceirizado(String nome) {
		Tercerizado terceirizado = new Tercerizado(nome,3);
		armazens.put(nome, terceirizado);
		quantidade_total_terceirizado++;
		quantidade_total_armazem++;
		if(tipos_armazens[1] == 0) {
			tipos_armazens[2] = 1;
			quantidade_tipos_armazens ++;
		}
	}
	
	public void removerArmazem(String nome) {
		int tipo_armazem = armazens.get(nome).getTipo();
		
		if(tipo_armazem == 1)quantidade_total_proprio--;
		else if(tipo_armazem == 2)quantidade_total_contratado--;
		else if(tipo_armazem == 3)quantidade_total_terceirizado--;
		armazens.remove(nome);
		quantidade_total_armazem--;
	}
	
	// ADICIONAR / REMEVER VEICULO
	
	public void adicionarMoto(String armazem, String modelo, int ano, String placa,double preco ) {
		armazens.get(armazem).adicionarMoto(modelo, ano, placa, preco);
	}
	public void adicionarCarro(String armazem, String modelo, int ano, String placa,double preco ) {
		armazens.get(armazem).adicionarCarro(modelo, ano, placa, preco);
	}
	public void adicionarOnibus(String armazem, String modelo, int ano, String placa,double preco ) {
		armazens.get(armazem).adicionarOnibus(modelo, ano, placa, preco);
	}
	
	public void removerVeiculo(String armazem, String placa) {
		armazens.get(armazem).removerVeiculo(placa);
	}
	
	//
	
	public void relatorioArmazem(String armazem) {
		//TRATAR EXCE��O  - NO CASO, SE O ARMAZEM � INEXISTENTE, N�O EXISTE, MONSTRAR NA TELA QUE O ERRO N�O EXISTE.
		armazens.get(armazem).relatorioArmazem();
	}
	
	public void relatorioTotal() {
		System.out.println("Quantidade total de armazens: " + this.quantidade_total_armazem);
		//System.out.println("Quantidade total de veiculos: " + );
		System.out.println("Quantidade de tipos de armazens: " + this.quantidade_tipos_armazens);
		for(int i = 0; i < 3;i++) {
			if(tipos_armazens[i] == 1) {
				if(i == 0 ) {
					System.out.println(" ### ARMAZEM PR�PRIO ###");
					System.out.println("Quantidade total de armazens pr�prio: " + this.quantidade_total_proprio);
				}
				else if(i == 1) {
					System.out.println(" ### ARMAZEM CONTRATADO ###");
					System.out.println("Quantidade total de armazens contratado: " + this.quantidade_total_contratado);
				}
				else if(i == 2) {
					System.out.println(" ### ARMAZEM TERCEIRIZADO ###");
					System.out.println("Quantidade total de armazens tercerizado: " + this.quantidade_total_terceirizado);
				}
				//System.out.println("Quantidade total de veiculos do armazem: " + );

		
			}
		}
	}

	
	
	
	
	
	
	
}
