
public class Moto extends Veiculo{
	public Moto(String modelo, int ano, String placa, float preco) {
		super(modelo, ano, placa, preco);
		this.tipo = 1;
		this.vaga = (float) 0.5;
	}
}
