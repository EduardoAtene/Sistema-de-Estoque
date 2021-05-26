
public class Tercerizado extends Armazem implements CalcularMensalidade {
	private float valor_por_unidade_moto = (float)100.00;
	private float valor_por_unidade_carro = (float)200.00;
	private float valor_por_unidade_onibus = (float)600.00;
	private float valor_total_moto;
	private float valor_total_carro;
	private float valor_total_onibus;
	private float valor_total;
	
	
	public Tercerizado(String nome, String tipo, float tamanho) {
		super(nome, tipo, tamanho);
	}

	
	@Override
	public void calcularMensalidade() {
		valor_total_moto = this.getQuantidade_moto() * valor_por_unidade_moto;
		valor_total_carro = this.getQuantidade_carro() * valor_por_unidade_carro;
		valor_total_onibus = this.getQuantidade_onibus() * valor_por_unidade_onibus;
		this.valor_total = valor_total_moto + valor_total_carro + valor_total_onibus;
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

}
