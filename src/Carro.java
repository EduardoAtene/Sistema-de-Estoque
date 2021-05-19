
public class Carro extends Veiculo implements Garagem {
	private static int carroVendidos;
	private static int totalCarro;
	private int tipo;
	private double bateria;
	private int acento;
	
	public Carro(String iD, int quantidade, String modelo, int ano, float preco,int tipo,int acento) {
		super(iD, quantidade, modelo, ano, preco);
		this.acento = acento;
		this.tipo = tipo;
		if (this.tipo == 2)
			bateria = 0;
		// TODO Auto-generated constructor stub
	}
	
	public static int getCarroVendidos() {
		return carroVendidos;
	}
	public static int getTotalCarro() {
		return totalCarro;
	}
	public int getTipo() {
		return tipo;
	}
	public double getBateria() {
		return bateria;
	}
	public int getAcento() {
		return acento;
	}
	
	@Override
	public boolean carregarBateria() {
		if(this.tipo == 2){
			//BATERIA PRECISA SER CARREGADA?
			if(this.bateria <100) {
				//CARREGAR BATERIA
				this.bateria = 100;
				return true;
			}else {
				// BATERIA JÁ ESTÁ CARREGADA, NÃO PRECISA SER CARREGADA
				return false;
			}
			
		}else {
			System.out.println("O carro não é tipo 2: BATERIA");
			return false;
		}
	}
	@Override
	public void verificarBateria() {
		if(this.tipo == 2) {
			//BATERIA PRECISA SER CARREGADA?
			if(this.bateria <100) {
				//PRECISA CARREGAR BATERIA
				carregarBateria();
			}
			// BATERIA JÁ ESTÁ CARREGADA, NÃO PRECISA SER CARREGADA
	
		}else {
			System.out.println("O carro não é tipo 2: BATERIA");
		}
	}
	@Override
	public void verificaTipo() {
		if(this.tipo==1) {
			System.out.println("Tipo do carro é do tipo 1: Gasolina!");
		}else if (this.tipo==2){
			System.out.println("Tipo do carro é do tipo 2: Bateria!");
		}
	}
}
