package Objetos;

public class Musica {

	private String nome;

	private int index;

	public Musica(String nome, int index) {
		this.nome = nome;
		this.index = index;

	}

	public String GetNome() {

		System.out.println("Musica: " + nome);
		return nome;
	}

	public int GetID() {
		return index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " " + index + " - " + nome + ".";

	}

}
