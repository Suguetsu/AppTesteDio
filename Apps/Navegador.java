package Apps;

import java.util.ArrayList;
import java.util.List;

import Objetos.Browser;

public class Navegador {

	private List<Browser> _navegador;
	private boolean isPageOn = false;
	private int novaPagina = 0;

	public Navegador() {
		this._navegador = new ArrayList<>();

	}

	public void ExibirPagina() {

		if (!isPageOn) {

			novaPagina++;
			_navegador.add(novaPagina, new Browser("Firefox", novaPagina));
		}

		isPageOn = true;

		System.out.println("Pagina já criada!");

	}

	public void AdicionarNovaAba() {

		if (isPageOn) {

			novaPagina++;
			_navegador.add(0, new Browser("Firefox", 0));

			System.out.println("Aba adicionada, numero de abas: " + novaPagina);
		} else
			System.out.println("Precisa exibir a pagina antes!");

	}

	public void AtualizarPagina() {

		System.out.println("Pagina atualizada!");

	}

}
