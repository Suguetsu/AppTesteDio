
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MaskFormatter;

import Apps.AparelhoTelefonico;
import Apps.Navegador;
import Apps.Reprodutor;

public class Smarthphone {

	private static List<String> _appsList;
	private static boolean isAppSelected = false;
	private static boolean isEntryInfo = false;
	private static boolean isInsideApp = false;

	private static AparelhoTelefonico _discador;
	private static Reprodutor _reprodutor;
	private static Navegador _navegador;

	private static String nome = " ";
	private static String numero = " ";

	protected static void Aplicativos() {

		_navegador = new Navegador();
		_reprodutor = new Reprodutor();
		_discador = new AparelhoTelefonico();

		_appsList = new ArrayList<>();

		_appsList.add("Navegador");
		_appsList.add("Reprodutor");
		_appsList.add("Discador");

		for (int i = 0; i < _appsList.size(); i++)
			PrintSout(i + " - " + _appsList.get(i));

		PrintSout(9 + " - " + "SAIR");

	}

	protected static String FormatterTelefone(String telefone) {

		MaskFormatter formatter = null;

		try {
			formatter = new MaskFormatter("####-####");
			telefone = formatter.getPlaceholder();

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return telefone;
	}

	public static void PrintSout(String info) {
		System.out.println(info);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String info = "";

		PrintSout("Escolha um número para iniciar o aplicativo!");

		Aplicativos();

		while (!str.equals("Sair")) {

			if (!isEntryInfo)
				str = br.readLine();
			else
				info = br.readLine();

			int localId = Integer.parseInt(str);

			AplicativoSeletor(str, localId);

			Navegador(localId, info);
			Reprodutor(localId, info);
			Telefonar(localId, info);

		}

	}

	private static void AplicativoSeletor(String str, int localId) {

		switch (localId) {

			case 0:

				if (!isAppSelected) {

					isAppSelected = true;

					_navegador.setAppSelected(isAppSelected);

				}

				break;

			case 1:

				if (!isAppSelected) {

					isAppSelected = true;

					_reprodutor.setAppSelected(isAppSelected);
				}

				break;

			case 2:

				if (!isAppSelected) {

					isAppSelected = true;

					_discador.setAppSelected(isAppSelected);

				}

				break;

			default:

				if (!isAppSelected)
					PrintSout("Entrada inválida, sabe ler não, filho?! " + localId);
				else if (str == "SAIR") {

					PrintSout(str + "Trocar de aplicativo");
					isAppSelected = false;

				}

				break;

		}
	}

	protected static void Reprodutor(int id, String info) {

		if (!_reprodutor.isAppSelected())
			return;
		else {
			PrintSout("Escolha uma das opções abaixo! \n");

			PrintSout("0 - Ligar por nome! \n");
			PrintSout("1 - Discar número! \n");
			PrintSout("2 - Adicionar Contato! \n");
			PrintSout("3 - Atender Chamada! \n");
			PrintSout("4 - Iniciar Correio de voz! \n");

			PrintSout("Digite: 'SAIR',para voltar! ");

		}

		_reprodutor.Tocar(0);

	}

	protected static void Navegador(int id, String info) {

		if (!_navegador.isAppSelected())
			return;
		else {

			PrintSout("Escolha uma das opções abaixo! \n");

			PrintSout("0 - Ligar por nome! \n");
			PrintSout("1 - Discar número! \n");
			PrintSout("2 - Adicionar Contato! \n");
			PrintSout("3 - Atender Chamada! \n");
			PrintSout("4 - Iniciar Correio de voz! \n");

			PrintSout("Digite: 'SAIR',para voltar! ");
			;

		}

	}

	protected static void Telefonar(int id, String info) {

		if (!_discador.isAppSelected())
			return;
		else if (!isInsideApp) {

			PrintSout("Escolha uma das opções abaixo! \n");

			PrintSout("0 - Ligar por nome! \n");
			PrintSout("1 - Discar número! \n");
			PrintSout("2 - Adicionar Contato! \n");
			PrintSout("3 - Atender Chamada! \n");
			PrintSout("4 - Iniciar Correio de voz! \n");

			PrintSout("Digite: '9',para voltar! ");

		}

		switch (id) {

			case 0:
				isInsideApp = true;

				if (!nome.isBlank()) {

					PrintSout("Digite o Nome! \n");

					isEntryInfo = true;
					nome = info;

				} else {

					_discador.Ligar(nome);
					isEntryInfo = false;
					isInsideApp = false;

					nome = " ";
					numero = " ";

				}

				break;

			case 1:

				isInsideApp = true;

				if (numero.isBlank()) {

					PrintSout("Digite o telefone! \n");

					isEntryInfo = true;
					numero = info;

				} else if (!numero.isBlank()) {

					_discador.LigarNumero(FormatterTelefone(numero));

					isEntryInfo = false;
					isInsideApp = false;

					nome = " ";
					numero = " ";

				}

				break;

			case 2:
				isInsideApp = true;

				if (nome.isBlank()) {

					PrintSout("Digite o nome! ");
					isEntryInfo = true;

					nome = info;

					return;

				} else if (numero.isBlank()) {

					PrintSout("Digite o telefone! ");

					numero = info;

					return;
				} else {

					isEntryInfo = false;
					isInsideApp = false;

					_discador.AdicionarContato(nome, FormatterTelefone(numero));

					nome = " ";
					numero = " ";
				}

				break;

			case 3:
				isInsideApp = true;

				_discador.Atender();
				break;

			case 4:
				isInsideApp = true;

				_discador.IniciarCorreioVoz();

				break;

			case 9:
				isEntryInfo = false;
				isInsideApp = false;
				break;

		}

	}

}
