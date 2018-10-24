package Cadastros;

public class CalcularDuracaoMinutos {
	Viagem viagem;
	int duracaoMinutos;
	
	public CalcularDuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int ComputarMinutos() {
		if (verificarMinutosTerminoEhMaiorMinutoInicio()) 
			duracaoMinutos = calcularTempoDecorrido();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}

	private int calcularTempoDecorrido() {
		return viagem.getMinutosTermino() - viagem.getMinutoInicio();
	}

	private boolean verificarMinutosTerminoEhMaiorMinutoInicio() {
		return viagem.getMinutosTermino() > viagem.getMinutoInicio();
	}

}
