package Objetos;

public class Browser {

	private String nome;

	private int id;

	public Browser(String nome, int id) {

		this.nome = nome;
		this.id = id;

	}

	public String GetNome() {
		return nome;
	}

	public int GetId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Browser other = (Browser) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Browser [nome=" + nome + " Aba " + id;
	}

}
