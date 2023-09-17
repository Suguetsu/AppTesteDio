package Objetos;

public class Contato {

	private String numero;

	private String nome;

	public Contato(String nome, String numero) {

		this.nome = nome;
		this.numero = numero;

	}

	public String GetNumero() {
		return numero;
	}

	public String GetNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato [numero=" + numero + ", nome=" + nome + "]";
	}

}
