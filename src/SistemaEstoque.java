import java.util.Map;
import java.util.HashMap;

public class SistemaEstoque {
	private int quantidade_total_armazem = 0;
	private int quantidade_total_proprio = 0;
	private int quantidade_total_terceirizado = 0;
	private int quantidade_total_contratado = 0;
	private int quantidade_tipos_armazens= 0;
	private int tipos_armazens[] = {0,0,0};
	private int quantidade_total_veiculos;
	private int quantidade_total_veiculos_do_armazem[] = {0,0,0}; 

	
	protected Map <String,Armazem> armazens = new HashMap<>();

	public void verificarQuantidadeTotalVeiculo() {
		quantidade_total_veiculos = 0;
		for (Map.Entry<String, Armazem> armazem : armazens.entrySet()) {
			quantidade_total_veiculos +=armazem.getValue().getQuantidade_veiculos();
		}
	}	
	
	public void verificarQuantidadeTotalVeiculoArmazem() {
		quantidade_total_veiculos_do_armazem[0] = 0;
		quantidade_total_veiculos_do_armazem[1] = 0;
		quantidade_total_veiculos_do_armazem[2] = 0;
		for (Map.Entry<String, Armazem> armazem : armazens.entrySet()) {
			if(armazem.getValue().getTipo() == 1) {
				quantidade_total_veiculos_do_armazem[0] += armazem.getValue().getQuantidade_veiculos();
			}
			else if(armazem.getValue().getTipo() == 2) {
				quantidade_total_veiculos_do_armazem[1] += armazem.getValue().getQuantidade_veiculos();
			}
			else if(armazem.getValue().getTipo() == 3) {
				quantidade_total_veiculos_do_armazem[2] += armazem.getValue().getQuantidade_veiculos();
			}
		}
	}	
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
		if(tipos_armazens[1] == 0) {
			tipos_armazens[1] = 1;
			quantidade_tipos_armazens ++;
		}
	}
	
	public void criarArmazemTerceirizado(String nome) {
		Tercerizado terceirizado = new Tercerizado(nome,3);
		armazens.put(nome, terceirizado);
		quantidade_total_terceirizado++;
		quantidade_total_armazem++;
		if(tipos_armazens[2] == 0) {
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
	
	// ADICIONAR / REMOVER / RECUPEAR VEICULO
	
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
	
	public void recuperarVeiculo(String armazem, String placa) {
		armazens.get(armazem).recuperarVeiculo(placa);
	}
	
	// RELATORIO VEICULO
	
	public void dadosVeiculo(String armazem, String placa) {
		armazens.get(armazem).dadosVeiculos(armazem, placa,1);
	}
	public void dadosVeiculoRemovido(String armazem, String placa) {
		armazens.get(armazem).dadosVeiculos(armazem, placa,2);
	}
	
	// VEICULOS REMOVIDOS
	
	public void limparRemovidosTotal(String armazem) {
		armazens.get(armazem).limparRemovidoTotal();
	}
	public void limparRemovidosUnidade(String armazem, String placa) {
		armazens.get(armazem).limparRemovidoUnidade(placa);
	}
	
	
	//RELATORIOS
	public void relatorioVeiculosArmazem(String armazem) {
		armazens.get(armazem).relatorioVeiculosArmazem(armazem);
	}

	public void relatorioArmazem(String armazem) {
		//TRATAR EXCEÇÃO  - NO CASO, SE O ARMAZEM É INEXISTENTE, NÃO EXISTE, MONSTRAR NA TELA QUE O ERRO NÃO EXISTE.
		armazens.get(armazem).relatorioArmazem();
	}
	
	public void relatorioTotal() {
		verificarQuantidadeTotalVeiculo();
		System.out.println("** #### RELATÓRIO TOTAL #### **");
		System.out.println("Quantidade total de armazens: " + this.quantidade_total_armazem);
		System.out.println("Quantidade total de veiculos: " + quantidade_total_veiculos);
		System.out.println("Quantidade de tipos de armazens: " + this.quantidade_tipos_armazens);
		for(int i = 0; i < 3;i++) {
			if(tipos_armazens[i] == 1) {
				if(i == 0 ) {
					System.out.println(" ### ARMAZEM PRÓPRIO ###");
					System.out.println("Quantidade total de armazens próprio: " + this.quantidade_total_proprio);
				}
				else if(i == 1) {
					System.out.println(" ### ARMAZEM CONTRATADO ###");
					System.out.println("Quantidade total de armazens contratado: " + this.quantidade_total_contratado);
				}
				else if(i == 2) {
					System.out.println(" ### ARMAZEM TERCEIRIZADO ###");
					System.out.println("Quantidade total de armazens tercerizado: " + this.quantidade_total_terceirizado);
				}
				verificarQuantidadeTotalVeiculoArmazem();
				System.out.println("Quantidade total de veiculos do armazem: " + quantidade_total_veiculos_do_armazem[i]);

		
			}
		}
		System.out.println();
	}

	
	
	
	
	
	
	
}
