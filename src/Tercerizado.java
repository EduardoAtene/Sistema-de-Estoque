
public class Tercerizado extends Armazem implements CalcularMensalidade {
	private float valor_por_unidade_moto = (float)100.00;
	private float valor_por_unidade_carro = (float)200.00;
	private float valor_por_unidade_onibus = (float)600.00;
	private float valor_total_moto = 0;
	private float valor_total_carro = 0;
	private float valor_total_onibus = 0;
	private float valor_total = 0;
	
	
	public Tercerizado(String nome, int tipo) {
		super(nome, tipo,1000); 

	}


	//GETTERS
	public float getValor_por_unidade_moto() {
		return valor_por_unidade_moto;
	}


	public float getValor_por_unidade_carro() {
		return valor_por_unidade_carro;
	}


	public float getValor_por_unidade_onibus() {
		return valor_por_unidade_onibus;
	}


	public float getValor_total_moto() {
		return valor_total_moto;
	}


	public float getValor_total_carro() {
		return valor_total_carro;
	}


	public float getValor_total_onibus() {
		return valor_total_onibus;
	}


	public float getValor_total() {
		calcularMensalidade();
		return valor_total;
	}
	
	// MÉTODOS DA CLASSE | INTERFACE
	
	@Override
	public void calcularMensalidade() {
		valor_total_moto = this.getQuantidade_moto_T() * valor_por_unidade_moto ;
		valor_total_carro = this.getQuantidade_carro_T() * valor_por_unidade_carro;
		valor_total_onibus = this.getQuantidade_onibus_T() * valor_por_unidade_onibus;
		this.valor_total = valor_total_moto + valor_total_carro + valor_total_onibus;
	}
	
	
	public void relatorioArmazem() {
		calcularMensalidade();
		String tipo = "Tercerizado";
		System.out.println("\nNome: " + this.getNome());
		System.out.println("Tipo do armazem: " + tipo);

		System.out.println("Tamanho ocupado: " + this.getTamanho_ocupado());

		System.out.println("Quantidade total de veiculos: " + this.getQuantidade_veiculos());
		System.out.println("Quantidade de moto:" + this.getQuantidade_moto());
		System.out.println("Quantidade de carro: " + this.getQuantidade_carro());
		System.out.println("Quantidade de onibus: " + this.getQuantidade_onibus());
		System.out.println("Custo total: " + this.valor_total);
		System.out.println("Custo do moto: " + this.valor_total_moto);
		System.out.println("Custo do carro: " + this.valor_total_carro);
		System.out.println("Custo do onibus: " + this.valor_total_onibus);
	}
	
}

