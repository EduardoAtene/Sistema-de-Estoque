import java.util.HashMap;
import java.util.Map;

public abstract class Armazem {
	private float tamanho;
	private String nome;
	protected int tipo;
	private int quantidade_veiculos = 0;
	private int quantidade_moto = 0;
	private int quantidade_carro = 0;
	private int quantidade_onibus = 0;
	Map<String,Veiculo> veiculos = new HashMap<>();
	private float tamanho_ocupado;
	private float tamanho_disponivel;
	
	public Armazem(String nome, String tipo,float tamanho) {
		super();
		this.tamanho = tamanho;
		this.nome = nome;
	}
	
	
	
	// Getters
	
	public float getTamanho() {
		return tamanho;
	}
	public String getNome() {
		return nome;
	}
	public int getTipo() {
		return tipo;
	}
	public int getQuantidade_veiculos() {
		return quantidade_veiculos;
	}
	public int getQuantidade_moto() {
		return quantidade_moto;
	}
	public int getQuantidade_carro() {
		return quantidade_carro;
	}
	public int getQuantidade_onibus() {
		return quantidade_onibus;
	}
	public Map<String, Veiculo> getVeiculos() {
		return veiculos;
	}
	
	
	// Funções / Métodos
	public void adicionarMoto(String modelo, int ano, String placa,float preco) {
		Moto moto = new Moto(modelo,ano,placa,preco);
		verificarTamanho(moto.vaga);
		veiculos.put(placa,moto);
		quantidade_veiculos++;
		quantidade_moto++;
	}
	public void adicionarCarro(String modelo, int ano, String placa,float preco) {
		Carro carro = new Carro(modelo,ano,placa,preco);
		verificarTamanho(carro.vaga);
		veiculos.put(placa,carro);
		quantidade_veiculos++;
		quantidade_carro++;
	}
	public void adicionarOnibus(String modelo, int ano, String placa,float preco) {
		Onibus onibus = new Onibus(modelo,ano,placa,preco);
		verificarTamanho(onibus.vaga);
		veiculos.put(placa,onibus);
		quantidade_veiculos++;
		quantidade_onibus++;
	}
	

	
	public void removerVeiculo(String placa) {
		int tipo_veiculo = veiculos.get(placa).tipo;
		
		if(tipo_veiculo == 1)quantidade_moto--;
		else if(tipo_veiculo == 2)quantidade_carro--;
		else if(tipo_veiculo == 3)quantidade_onibus--;
		veiculos.remove(placa);
		quantidade_veiculos--;
	}
	
	private boolean verificarTamanho(float vaga) {
		this.tamanho_ocupado =(float)((quantidade_moto*0.5) +(quantidade_carro*2) + (quantidade_onibus*6));
		this.tamanho_disponivel =(this.tamanho - this.tamanho_ocupado);
		
	}
	
	public void relatorioArmazem() {
		String tipo = null;
		if (this.tipo == 1)tipo = "Próprio";
		else if (this.tipo == 2)tipo = "Contratado";
		else if (this.tipo == 3)tipo = "Terceirizado";
		
			
		System.out.println("Nome: " + this.nome);
		System.out.println("Tipo: " + tipo);
		if (this.tipo!=3) {
			System.out.println("Tamanho total do armazem: " + this.tamanho);
			System.out.println("Tamanho disponível: " + tamanho_disponivel);
		}
		System.out.println("Tamanho ocupado: " + tamanho_ocupado);

		System.out.println("Quantidade total de veiculos: " + quantidade_veiculos);
		System.out.println("Quantidade de moto:" + quantidade_moto);
		System.out.println("Quantidade de carro: " + quantidade_carro);
		System.out.println("Quantidade de onibus: " + quantidade_onibus);
		
		

}
