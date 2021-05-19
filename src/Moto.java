
public class Moto extends Veiculo implements Garagem {
	private static int motoVendidos;
	private static int totalMoto;
	private int tipo;
	private double bateria;
	
	// incluir tipo de moto no construtor
	
	public static int getMotoVendidos() {
		return motoVendidos;
	}
	public static int getTotalMoto() {
		return totalMoto;
	}
	public int getTipo() {
		return tipo;
	}
	public double getBateria() {
		return bateria;
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
