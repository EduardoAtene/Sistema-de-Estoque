import java.util.HashMap;
import java.util.Map;

public abstract class Armazem {
	private double tamanho;
	private String nome;
	protected int tipo;
	private int quantidade_veiculos = 0;
	private int quantidade_moto = 0;
	private int quantidade_carro = 0;
	private int quantidade_onibus = 0;
	private int quantidade_moto_T = 0;
	private int quantidade_carro_T = 0;
	private int quantidade_onibus_T = 0;	
	Map<String,Veiculo> veiculos = new HashMap<>();
	private double tamanho_ocupado= 0;
	private double tamanho_disponivel= this.tamanho;
	
	public Armazem(String nome, int tipo,double tamanho) {
		super();
		this.tamanho = tamanho;
		this.tipo = tipo;
		this.nome = nome;
	}
	
	
	
	// Getters
	
	public double getTamanho() {
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
	public double getTamanho_ocupado() {
		return tamanho_ocupado;
	}
	public double getTamanho_disponivel() {
		return tamanho_disponivel;
	}
	protected int getQuantidade_moto_T() {
		return quantidade_moto_T;
	}
	protected int getQuantidade_carro_T() {
		return quantidade_carro_T;
	}
	protected int getQuantidade_onibus_T() {
		return quantidade_onibus_T;
	}


	// Funções / Métodos
	public void adicionarMoto(String modelo, int ano, String placa,double preco) {
		Moto moto = new Moto(modelo,ano,placa,preco);
		quantidade_moto++;
		quantidade_moto_T++;
		if(verificarTamanho(moto.vaga)) {
			veiculos.put(placa,moto);
			quantidade_veiculos++;
		}else {
			quantidade_moto--;
			verificarTamanho(moto.vaga);
			System.out.println("Não possui vaga disponível para adicionar este veiculo!!");
		}
	}



	public void adicionarCarro(String modelo, int ano, String placa,double preco) {
		Carro carro = new Carro(modelo,ano,placa,preco);
		quantidade_carro++;
		quantidade_carro_T++;
		if(verificarTamanho(carro.vaga)) {
			veiculos.put(placa,carro);
			quantidade_veiculos++;
		}else {
			quantidade_carro--;
			verificarTamanho(carro.vaga);
			System.out.println("Não possui vaga disponível para adicionar este veiculo!!");
		}
	}
	public void adicionarOnibus(String modelo, int ano, String placa,double preco) {
		Onibus onibus = new Onibus(modelo,ano,placa,preco);
		quantidade_onibus++;
		quantidade_onibus_T++;
		if(verificarTamanho(onibus.vaga)) {
			veiculos.put(placa,onibus);
			quantidade_veiculos++;
		}else {
			quantidade_onibus--;
			verificarTamanho(onibus.vaga);
			System.out.println("Não possui vaga disponível para adicionar este veiculo!!");
		}
	}
	


	public void removerVeiculo(String placa) {
		int tipo_veiculo = veiculos.get(placa).tipo;
		
		if(tipo_veiculo == 1)quantidade_moto--;
		else if(tipo_veiculo == 2)quantidade_carro--;
		else if(tipo_veiculo == 3)quantidade_onibus--;
		verificarTamanho(veiculos.get(placa).vaga);
		veiculos.remove(placa);
		quantidade_veiculos--;
	}
	
	private boolean verificarTamanho(float vaga) {
		this.tamanho_ocupado =(double)((quantidade_moto*0.5) + (quantidade_carro * 2) + (quantidade_onibus*6));
		this.tamanho_disponivel =(this.tamanho - this.tamanho_ocupado);
		float aux_verific = (vaga+(float)tamanho_ocupado);
		if(aux_verific <= this.tamanho)return true;
		return false;
		
	}
	
	public abstract void relatorioArmazem();	

}
