public class Contratado extends Armazem implements CalcularMensalidade{
	private float valor_por_unidade = (float)100.00;
	private float valor_total;
	
	public Contratado(String nome, int tipo,double tamanho) {
		super(nome,tipo,tamanho);
		calcularMensalidade();

	}

	@Override
	public void calcularMensalidade() {
		valor_total = (float) (this.getTamanho() * valor_por_unidade);
	}

	
	
	public float getValor_total() {
		return valor_total;
	}
	
	public void relatorioArmazem() {
		String tipo = "Contratado";		
		System.out.println("\nNome: " + this.getNome());
		System.out.println("Tipo do armazem: " + tipo);
		System.out.println("Tamanho total do armazem: " + this.getTamanho());
		System.out.println("Tamanho disponível: " + this.getTamanho_disponivel());

		System.out.println("Tamanho ocupado: " + this.getTamanho_ocupado());

		System.out.println("Quantidade total de veiculos: " + this.getQuantidade_veiculos());
		System.out.println("Quantidade de moto:" + this.getQuantidade_moto());
		System.out.println("Quantidade de carro: " + this.getQuantidade_carro());
		System.out.println("Quantidade de onibus: " + this.getQuantidade_onibus());
		
		System.out.println("Custo total: " + this.valor_total);
		System.out.println("Valor por unidade:" + this.valor_por_unidade);
	}
}
