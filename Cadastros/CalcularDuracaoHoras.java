package Cadastros;

public class CalcularDuracaoHoras {
	
	Viagem viagem;
	int duracaoHoras;
	
	public CalcularDuracaoHoras(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int ComputarHoras() {		
		if (verificaHoraTerminoIgualHoraInicio())
			duracaoHoras = 0;
		if (verificaHoraTerminoMaiorHoraInicio()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (verificaMinutoTerminoMenorMinutoInicio())  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (duracaoHorasPassadas() > 2) //
					duracaoHoras = duracaoHorasPassadas();
				else if (duracaoHorasPassadas() == 2 &&   //certamente menos de duas horas  
						 verificaMinutoTerminoMenorMinutoInicio())    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (verificaHoraTerminoMenorHoraInicio()) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}

	private boolean verificaHoraTerminoMenorHoraInicio() {
		return viagem.getHoraTermino() < viagem.getHoraInicio();
	}

	private int duracaoHorasPassadas() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}

	private boolean verificaMinutoTerminoMenorMinutoInicio() {
		return viagem.getMinutosTermino() < viagem.getMinutoInicio();
	}

	private boolean verificaHoraTerminoMaiorHoraInicio() {
		return viagem.getHoraTermino() > viagem.getHoraInicio();
	}

	private boolean verificaHoraTerminoIgualHoraInicio() {
		return viagem.getHoraTermino() == viagem.getHoraInicio();
	}

}
