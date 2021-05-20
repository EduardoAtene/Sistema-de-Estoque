public abstract class Veiculo {
	
	private String ID;
	private String modelo;
	private int ano;
	private float preco;
	protected int vaga;	
	
	public Veiculo(String ID, String modelo, int ano, float preco) {
		this.ID = ID;
		this.modelo = modelo;
		this.ano = ano;
		this.preco = preco;
	}
		
	public int getVaga() {
		return vaga;
	}

	public abstract void setVaga();


	public String getID() {
		return ID;
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
}
