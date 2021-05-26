
public class Carro extends Veiculo {
	public Carro(String modelo, int ano, String placa, float preco) {
		super(modelo, ano, placa, preco);
		this.tipo = 2;
		this.vaga = 2;
	}
	
}
