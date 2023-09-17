
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Apps.AparelhoTelefonico;
import Apps.Reprodutor;

public class Smarthphone {

	protected static void Reprodutor() {
		Reprodutor _reprodutor = new Reprodutor();
		_reprodutor.Tocar(0);

	}

	protected void Navegador() {

	}

	protected void Telefonar() {

		AparelhoTelefonico d = new AparelhoTelefonico();
		int id = 0;

		switch (id) {

			case 1:

				d.Ligar(null);

				break;

			case 2:

				d.Ligar(0);
				break;

			case 3:

				d.AdicionarContato(null, 0);
				break;

			case 4:
				d.Atender();
				break;

			case 5:

				d.IniciarCorreioVoz();

				break;

		}

	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";

		System.out.println("Escolha um número para iniciar o aplicativo!");

		while (!str.equals("9")) {

		}

		Reprodutor();

	}

}
