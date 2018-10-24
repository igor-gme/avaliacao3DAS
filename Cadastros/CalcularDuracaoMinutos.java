package Cadastros;

public class CalcularDuracaoMinutos {
	Viagem viagem;
	int duracaoMinutos;
	
	public CalcularDuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int ComputarMinutos() {
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) 
			duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}

}
