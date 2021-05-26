public abstract class Veiculo {
	
	private String placa;
	private String modelo;
	private int ano;
	private float preco;
	protected int tipo;
	protected float vaga;	
	
	public Veiculo(String modelo, int ano, String placa,float preco) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.preco = preco;
	}
		
	public String getPlaca() {
		return placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	public int getAno() {
		return ano;
	}

	public float getPreco() {
		return preco;
	}

	public int getTipo() {
		return tipo;
	}

	public float getVaga() {
		return vaga;
	}
	
}
