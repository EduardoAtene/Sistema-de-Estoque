public class Contratado extends Armazem implements CalcularMensalidade{
	private float valor_por_unidade = (float)100.00;
	private float valor_total;
	
	public Contratado(String nome, String tipo,float tamanho) {
		super(nome,tipo,tamanho);
		calcularMensalidade();
		this.tipo = 2;

	}

	@Override
	public void calcularMensalidade() {
		valor_total = this.getTamanho() * valor_por_unidade;
	}

	
	
	public float getValor_total() {
		return valor_total;
	}
	
	
}
