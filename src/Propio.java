public class Propio extends Armazem {

	public Propio(String nome, int tipo, float tamanho) {
		super(nome, tipo, tamanho);
	}

	@Override
	public void relatorioArmazem() {
		String tipo = "Próprio";		
		System.out.println("\nNome: " + this.getNome());
		System.out.println("Tipo do armazem: " + tipo);
		if (this.tipo!=3) {
			System.out.println("Tamanho total do armazem: " + this.getTamanho());
			System.out.println("Tamanho disponível: " + this.getTamanho_disponivel());
		}
		System.out.println("Tamanho ocupado: " + this.getTamanho_ocupado()); 

		System.out.println("Quantidade total de veiculos: " + this.getQuantidade_veiculos());
		System.out.println("Quantidade de moto:" + this.getQuantidade_moto());
		System.out.println("Quantidade de carro: " + this.getQuantidade_carro());
		System.out.println("Quantidade de onibus: " + this.getQuantidade_onibus());
		
	}

}
