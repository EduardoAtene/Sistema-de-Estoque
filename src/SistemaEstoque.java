import java.util.Map;
import java.util.HashMap;

public class SistemaEstoque {
	private int quantidade_total_armazem = 0;
	private int quantidade_total_proprio = 0;
	private int quantidade_total_terceirizado = 0;
	private int quantidade_total_contratado = 0;
	Map <String,Armazem> armazens = new HashMap<>();
	
	
	
	
	
	
	
	// CRIAR / REMOVER ARMAZEM
	public void criarArmazemProprio(String nome, String tipo,float tamanho) {
		Propio proprio = new Propio(nome,tipo,tamanho);
		armazens.put(nome, proprio);
		quantidade_total_proprio++;
		quantidade_total_armazem++;
	}
	
	public void criarArmazemTerceirizado(String nome, String tipo,float tamanho) {
		Tercerizado terceirizado = new Tercerizado(nome,tipo);
		armazens.put(nome, terceirizado);
		quantidade_total_terceirizado++;
		quantidade_total_armazem++;
	}
	public void criarArmazemContratado(String nome, String tipo,float tamanho) {
		Contratado contratado = new Contratado(nome,tipo,tamanho);
		armazens.put(nome, contratado);
		quantidade_total_contratado++;
		quantidade_total_armazem++;
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
	
	public void adicionarMoto(String armazem, String modelo, int ano, String placa,float preco ) {
		armazens.get(armazem).adicionarMoto(modelo, ano, placa, preco);
	}
	public void adicionarCarro(String armazem, String modelo, int ano, String placa,float preco ) {
		armazens.get(armazem).adicionarCarro(modelo, ano, placa, preco);
	}
	public void adicionarOnibus(String armazem, String modelo, int ano, String placa,float preco ) {
		armazens.get(armazem).adicionarOnibus(modelo, ano, placa, preco);
	}
	
	public void removerVeiculo(String armazem, String placa) {
		armazens.get(armazem).removerVeiculo(placa);
	}
	
	//
	
	public void relatorioArmazem(String armazem) {
		
	}
	
	public void relatorioTotal(String armazem) {
		
	}
	
		}
		
	}
	
	
	
	
	
	
	
	
}
