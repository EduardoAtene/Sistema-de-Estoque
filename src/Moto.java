
public class Moto extends Veiculo{
	public Moto(String modelo, int ano, String placa, double preco) {
		super(modelo, ano, placa, preco);
		this.tipo = 1;
		this.vaga = (float) 0.5;
	}
}
