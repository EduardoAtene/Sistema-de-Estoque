package Estoque;

public abstract class Veiculo {
	
	private String ID;
	private int quantidade;
	private String modelo;
	private int ano;
	private float preco;
	
	
	public Veiculo(String iD, int quantidade, String modelo, int ano, float preco) {
		setID(iD);
		setQuantidade(quantidade);
		setModelo(modelo);
		setAno(ano);
		setPreco(preco);
	}
	
	
	public String getID() {
		return ID;
	}
	private void setID(String iD) {
		ID = iD;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getModelo() {
		return modelo;
	}
	private void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	private void setAno(int ano) {
		this.ano = ano;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void retirarVeiculo() {
		quantidade--;
	}
	
	public void adicionarVeiculo() {
		quantidade++;
	}
	
	public void aumentarPreco() {
		preco++;
	}
	
	public void diminuirPreco() {
		preco--;
	}
}
