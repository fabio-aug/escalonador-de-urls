import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 * Escalonador
 */
public class Escalonador {

    public static void adicionarUrls(Scanner teclado, HashMap<String, Host> hostList, int quantidade) {
        Validador vUrl = new Validador();

        for (int i = 0; i < quantidade; i++) {
            String url = teclado.nextLine();

            // Valida URL (Protocolo e se é site WEB)
            if (vUrl.validaUrl(url)) {

                // Pegar o host
                String host = vUrl.pegarHost(url);

                // Se não existir eu crio o host
                if (!hostList.containsKey(host)) {
                    hostList.put(host, new Host());
                }

                // Trato a url
                String urlTratada = vUrl.tratamentoDeUrl(url);

                // Adiciono no host
                hostList.get(host).addUrl(urlTratada);
            }
        }
    }

    public static void escalonaTudo(HashMap<String, Host> hostList) {
        String escrever = "";

        for (Map.Entry<String, Host> host : hostList.entrySet()) {
            escrever += host.getValue().escalonaTudo();
        }

        System.out.println("Escalonador.escalonaTudo() - " + escrever);
    }

    public static void escalonaHost(HashMap<String, Host> hostList, String host, int quantidade) {
        String escrever = "";

        if (hostList.containsKey(host)) {
            escrever = hostList.get(host).escalona(quantidade);
        }

        System.out.println("Escalonador.escalonaHost() - " + escrever);
    }

    public static void verHost(HashMap<String, Host> hostList, String host) {
    }

    public static void listaHosts(HashMap<String, Host> hostList) {
    }

    public static void limpaHost(HashMap<String, Host> hostList, String host) {
        if (hostList.containsKey(host)) {
            hostList.get(host).limparUrls();
        }
    }

    public static void limpaTudo(HashMap<String, Host> hostList) {
        for (Map.Entry<String, Host> host : hostList.entrySet()) {
            host.getValue().limparUrls();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Host> hostList = new HashMap<String, Host>();

        String nomeArquivo = args[0];
        Scanner teclado = new Scanner(new FileReader(nomeArquivo));
        while (teclado.hasNext()) {
            String entrada = teclado.nextLine();
            String[] e = entrada.split(" ");
            switch (e[0]) {
                case "ADD_URLS":
                    adicionarUrls(teclado, hostList, Integer.parseInt(e[1]));
                    break;
                case "ESCALONA_TUDO":
                    escalonaTudo(hostList);
                    break;
                case "ESCALONA_HOST":
                    escalonaHost(hostList, e[1], Integer.parseInt(e[2]));
                    break;
                case "VER_HOST":
                    verHost(hostList, e[1]);
                    break;
                case "LISTA_HOSTS":
                    listaHosts(hostList);
                    break;
                case "LIMPA_HOST":
                    limpaHost(hostList, e[1]);
                    break;
                case "LIMPA_TUDO":
                    limpaTudo(hostList);
                    break;
            }
        }
    }
}