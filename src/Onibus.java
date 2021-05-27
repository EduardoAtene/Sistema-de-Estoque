public class Onibus extends Veiculo {
	public Onibus(String modelo, int ano, String placa, double preco) {
		super(modelo, ano, placa, preco);
		this.tipo = 3;
		this.vaga = 6;
	}	
}
