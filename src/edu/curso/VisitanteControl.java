package edu.curso;

public class VisitanteControl {
	private Visitante[] lista = new Visitante[100];
	private int indice = 0;

	public void adicionar(Visitante v) {
		lista[indice++] = v;

	}

	public Visitante pesquisar(String nome) {
		for (int i = 0; i < indice; i++) {
			Visitante v = lista[i];
			if (v != null && v.getNomeVisitante() != null && v.getNomeVisitante().contains(nome)) {
				return v;
			}
		}
		return new Visitante();
	}

}
