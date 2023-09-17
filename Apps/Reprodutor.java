package Apps;

import java.util.ArrayList;
import java.util.List;
import Objetos.Musica;

public class Reprodutor {

	private List<Musica> _musica;
	private boolean ispause;
	private boolean isPlaying;

	public Reprodutor() {

		_musica = new ArrayList<>();

		_musica.add(0, new Musica("Bruisers", 0));
		_musica.add(1, new Musica("Devil Eyes", 1));
		_musica.add(2, new Musica("Valley of Death", 2));
		_musica.add(3, new Musica("GTA San Andreas", 3));
		_musica.add(4, new Musica("Riders on the Storm", 4));
		_musica.add(5, new Musica("Enemy", 5));

	}

	public boolean Tocar(int id) {

		// int id = 0;

		if (!isPlaying) {

			_musica.stream()
					.sorted();

			SelecionarMusica();
		} else {

			isPlaying = false;

		}

		return !ispause;

	}

	public boolean Pausar() {
		return false;
	}

	public void SelecionarMusica() {

		_musica.stream()
				.forEach(System.out::println);

		isPlaying = true;

	}

}