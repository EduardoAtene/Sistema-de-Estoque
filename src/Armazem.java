import java.util.HashMap;
import java.util.Map;

public abstract class Armazem {
	private double tamanho;
	private String nome;
	protected int tipo;
	private int quantidade_veiculos = 0;
	private int quantidade_veiculos_removidos = 0;
	private int quantidade_moto = 0;
	private int quantidade_carro = 0;
	private int quantidade_onibus = 0;
	private int quantidade_moto_T = 0;
	private int quantidade_carro_T = 0;
	private int quantidade_onibus_T = 0;	
	Map<String,Veiculo> veiculos = new HashMap<>();
	Map<String,Veiculo> veiculos_removidos = new HashMap<>();
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
		veiculos_removidos.put(placa, veiculos.get(placa));
		veiculos.remove(placa);
		quantidade_veiculos--;
		quantidade_veiculos_removidos++;
	}
	
	public void recuperarVeiculo(String placa) {
		veiculos.put(placa,veiculos_removidos.get(placa));
		veiculos_removidos.remove(placa);
	}
	
	public void limparRemovidoTotal() {
		veiculos_removidos.clear();
	}
	public void limparRemovidoUnidade(String placa) {
		veiculos_removidos.remove(placa);
	}
	
	private boolean verificarTamanho(float vaga) {
		this.tamanho_ocupado =(double)((quantidade_moto*0.5) + (quantidade_carro * 2) + (quantidade_onibus*6));
		this.tamanho_disponivel =(this.tamanho - this.tamanho_ocupado);
		float aux_verific = (vaga+(float)tamanho_ocupado);
		if(aux_verific <= this.tamanho)return true;
		return false;
		
	}
	
	
	//RELATÓRIOS
	
	public void relatorioVeiculosArmazem(String nomeArmazem) {
		System.out.println("##############################################################");
		System.out.println("RELATÓRIO DETALHADO DE VEICULOS DO ARMAZEM "+nomeArmazem.toUpperCase());
		System.out.println("Quantidade total de veiculos: "+quantidade_veiculos);
		System.out.println("Quantidade total de veiculos removidos: "+quantidade_veiculos_removidos);
		System.out.println("##############################################################\n");
		String moto = "################# MOTO #################\n          Contidos no Armazem\n";
		moto += "________________________________________\n";
		String carro = "################# CARRO ################\n          Contidos no Armazem\n";
		carro += "________________________________________\n";
		String onibus = "################ ONIBUS ################\n          Contidos no Armazem\n";
		onibus += "________________________________________\n";
		for (Map.Entry<String, Veiculo> armazem : veiculos.entrySet()) {
			if(armazem.getValue().tipo == 1) {
				moto += "Placa: " + armazem.getValue().getPlaca() + " | ";
				moto += "Modelo: " + armazem.getValue().getModelo() + " | ";
				moto += "Tipo: Moto \n";
			}
			else if(armazem.getValue().tipo == 2) {
				carro += "Placa: " + armazem.getValue().getPlaca() + " | ";
				carro += "Modelo: " + armazem.getValue().getModelo() + " | ";
				carro += "Tipo: Carro \n";
			}
			else if(armazem.getValue().tipo == 3) {
				onibus += "Placa: " + armazem.getValue().getPlaca() + " | ";
				onibus += "Modelo: " + armazem.getValue().getModelo() + " | ";
				onibus += "Tipo: Onibus \n";
			}

		}	
		moto += "________________________________________\n \n";
		moto += "          Removidos do Armazem\n";
		moto += "________________________________________\n";
		carro += "________________________________________\n \n";
		carro += "          Removidos do Armazem\n";
		carro += "________________________________________\n";
		onibus += "________________________________________\n \n";
		onibus += "          Removidos do Armazem\n";
		onibus += "________________________________________\n";
		for (Map.Entry<String, Veiculo> armazem : veiculos_removidos.entrySet()) {
			if(armazem.getValue().tipo == 1) {
				moto += "Placa: " + armazem.getValue().getPlaca() + " | ";
				moto += "Modelo: " + armazem.getValue().getModelo() + " | ";
				moto += "Tipo: Moto \n";
			}
			else if(armazem.getValue().tipo == 2) {
				carro += "Placa: " + armazem.getValue().getPlaca() + " | ";
				carro += "Modelo: " + armazem.getValue().getModelo() + " | ";
				carro += "Tipo: Carro \n";
			}
			else if(armazem.getValue().tipo == 3) {
				onibus += "Placa: " + armazem.getValue().getPlaca() + " | ";
				onibus += "Modelo: " + armazem.getValue().getModelo() + " | ";
				onibus += "Tipo: Onibus \n";
			}

		}
		moto += "________________________________________\n";
		carro += "________________________________________\n";		
		onibus += "________________________________________\n";
		System.out.println(moto);
		System.out.println(carro);
		System.out.println(onibus);				
	}
	
	public void dadosVeiculos(String nomeArmazem,String placa,int status) {
		// Status = 1 significa que o veiculo está no armazem
		// Status = 2 siginifica que o veiculo foi removido do armazem
		String tipo_veiculo = null;
		String status_aux = null;
		String modelo = null;
		int ano = 0;
		String placa_aux = null;
		double preco = 0;
		double vaga = 0;
		
		if(status == 1) {
			if(veiculos.get(placa).getTipo() == 1)tipo_veiculo = "Moto";
			else if(veiculos.get(placa).getTipo() == 2)tipo_veiculo = "Carro";
			else if(veiculos.get(placa).getTipo() == 3)tipo_veiculo = "Onibus";
			status_aux = "Contido no Amazem";
			modelo = veiculos.get(placa).getModelo();
			ano = veiculos.get(placa).getAno();
			placa_aux = "Placa: "+veiculos.get(placa).getPlaca();
			preco = veiculos.get(placa).getPreco();
			vaga = veiculos.get(placa).getVaga();	
		}
		else if(status ==2) {
			if(veiculos_removidos.get(placa).getTipo() == 1)tipo_veiculo = "Moto";
			else if(veiculos_removidos.get(placa).getTipo() == 2)tipo_veiculo = "Carro";
			else if(veiculos_removidos.get(placa).getTipo() == 3)tipo_veiculo = "Onibus";
			status_aux = "Removido do Amazem";
			modelo = veiculos_removidos.get(placa).getModelo();
			ano = veiculos_removidos.get(placa).getAno();
			placa_aux = "Placa: "+veiculos_removidos.get(placa).getPlaca();
			preco = veiculos_removidos.get(placa).getPreco();
			vaga = veiculos_removidos.get(placa).getVaga();	
		}
		System.out.println("\n##############################################################");
		System.out.println("Armazem: "+nomeArmazem);
		System.out.println("Status: "+status_aux);
		System.out.println("Tipo de veiculo: "+tipo_veiculo);
		System.out.println("Modelo: "+modelo);
		System.out.println("Ano: "+ano);
		System.out.println("Placa: "+placa_aux);
		System.out.println("Preço: "+preco);
		System.out.println("Vaga ocupada: "+vaga);
		System.out.println("##############################################################");
	}
		
	
	public abstract void relatorioArmazem();	

}
