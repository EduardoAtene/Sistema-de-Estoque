public class Onibus extends Veiculo {
	private static int onibusVendidos;
	private static int totalOnibus;
	private int acento;
	
	public Onibus(String iD, int quantidade, String modelo, int ano, float preco,int acento) {
		super(iD, quantidade, modelo, ano, preco);
		this.acento = acento;
		// TODO Auto-generated constructor stub
	}	
	
	//Getters
	public static int getOnibusVendidos() {
		return onibusVendidos;
	}
	public static int getTotalOnibus() {
		return totalOnibus;
	}
	public int getAcento() {
		return acento;
	}

	
}
