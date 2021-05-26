import java.util.HashMap;
import java.util.Map;

public abstract class Armazem {
	private float tamanho;
	private String nome;
	private String tipo;
	private int quantidade_veiculos = 0;
	private int quantidade_moto = 0;
	private int quantidade_carro = 0;
	private int quantidade_onibus = 0;
	
	Map<String,Veiculo> veiculos = new HashMap<>();
	
	public Armazem(String nome, String tipo,float tamanho) {
		super();
		this.tamanho = tamanho;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	
	
	// Getters
	
	public float getTamanho() {
		return tamanho;
	}
	public String getNome() {
		return nome;
	}
	public String getTipo() {
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
		veiculos.put(placa,moto);
		quantidade_veiculos++;
		quantidade_moto++;
	}
	public void adicionarCarro(String modelo, int ano, String placa,float preco) {
		Carro carro = new Carro(modelo,ano,placa,preco);
		veiculos.put(placa,carro);
		quantidade_veiculos++;
		quantidade_carro++;
	}
	public void adicionarOnibus(String modelo, int ano, String placa,float preco) {
		Onibus onibus = new Onibus(modelo,ano,placa,preco);
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
}
