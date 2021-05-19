
public class Carro extends Veiculo implements Garagem {
	private static int carroVendidos;
	private static int totalCarro;
	private int tipo;
	private double bateria;
	private int acento;
	
	// incluir tipo e acento do carro no construtor
	
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
				// BATERIA J� EST� CARREGADA, N�O PRECISA SER CARREGADA
				return false;
			}
			
		}else {
			System.out.println("O carro n�o � tipo 2: BATERIA");
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
			// BATERIA J� EST� CARREGADA, N�O PRECISA SER CARREGADA
	
		}else {
			System.out.println("O carro n�o � tipo 2: BATERIA");
		}
	}
	@Override
	public void verificaTipo() {
		if(this.tipo==1) {
			System.out.println("Tipo do carro � do tipo 1: Gasolina!");
		}else if (this.tipo==2){
			System.out.println("Tipo do carro � do tipo 2: Bateria!");
		}
	}
}
