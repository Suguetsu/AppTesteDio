package Apps;

import java.util.Map;
import java.util.TreeMap;

import Objetos.Contato;

public class AparelhoTelefonico {

    private Map<String, Contato> mapContato;
    private boolean isAppSelected;
    // private List<Mensagens> msn;

    public AparelhoTelefonico() {

        this.mapContato = new TreeMap<>();
        isAppSelected =false;
    }

    public boolean isAppSelected() {
        return isAppSelected;
    }

    public void setAppSelected(boolean isAppSelected) {
        this.isAppSelected = isAppSelected;
    }

    /**
     * Cadastrar Cliente!
     * 
     * @param nome
     * @param telefone
     */
    public void AdicionarContato(String nome, String telefone) {

        mapContato.put(nome, new Contato(nome, telefone));

        System.out.println("Cliente: " + nome + " Cadastrado");

    }

    /**
     * Digite o nome para encotrar o contatdo
     * 
     * @param nome
     * @return
     */
    public String Ligar(String nome) {

        if (!mapContato.isEmpty())

            return mapContato.get(nome).GetNome();

        System.out.println("Cadastre um contato");

        return "Contato não encontrado!";

    }

    public String LigarNumero(String numero) {

        if (!mapContato.isEmpty())

            for (Contato c : mapContato.values()) {

                if (c.GetNumero().equals(numero))
                    return "Ligando para " + c.GetNome();

            }

        return "Contato não cadastrado, ligando para: " + numero;

    }

    public boolean Atender() {
        return false;
    }

    public void IniciarCorreioVoz() {

        System.out.println("Correio de Voz iniciado!");

    }

}
