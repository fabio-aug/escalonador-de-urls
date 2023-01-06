import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.io.FileNotFoundException;

/**
 * classe Escalonador
 * 
 * Descrição:
 * Classe responsável por ler o arquivo de entrada e chamas as devidas funções.
 */
public class Escalonador {
    public static void adicionarUrls(Scanner teclado, LinkedHashMap<String, Host> hostList, int quantidade) {
        Validador vUrl = new Validador();

        for (int i = 0; i < quantidade; i++) {
            String url = teclado.nextLine();

            // Valida URL (Protocolo e Arquivo)
            if (vUrl.validaUrl(url)) {

                // Pega o host
                String host = vUrl.pegarHost(url);

                // Se não existir, cria o host
                if (!hostList.containsKey(host)) {
                    hostList.put(host, new Host());
                }

                // Trata a url
                String urlTratada = vUrl.tratamentoDeUrl(url);

                // Adiciona no host
                hostList.get(host).addUrl(urlTratada);
            }
        }
    }

    public static void escalonaTudo(Escritor escritor, LinkedHashMap<String, Host> hostList) {
        String escrever = "";

        for (Map.Entry<String, Host> host : hostList.entrySet()) {
            escrever += host.getValue().escalonaTudo();
        }

        escritor.escrever(escrever);
    }

    public static void escalonaHost(Escritor escritor, LinkedHashMap<String, Host> hostList, String host, int quantidade) {
        String escrever = "";

        if (hostList.containsKey(host)) {
            escrever += hostList.get(host).escalona(quantidade);
        }

        escritor.escrever(escrever);
    }

    public static void escalona(Escritor escritor, LinkedHashMap<String, Host> hostList, int quantidade) {
        String escrever = "";

        for (Map.Entry<String, Host> host : hostList.entrySet()) {
            int hostSize = host.getValue().pegarTamanho();
            if (hostSize > quantidade) {
                escrever += host.getValue().escalona(quantidade);
                break;
            } else {
                escrever += host.getValue().escalona(hostSize);
                quantidade -= hostSize;
            }
        }

        escritor.escrever(escrever);
    }

    public static void verHost(Escritor escritor, LinkedHashMap<String, Host> hostList, String host) {
        String escrever = "";

        if (hostList.containsKey(host)) {
            escrever = hostList.get(host).verHost();
        }
        escritor.escrever(escrever);
    }

    public static void listaHosts(Escritor escritor, LinkedHashMap<String, Host> hostList) {
        String escrever = "";

        for (Map.Entry<String, Host> host : hostList.entrySet()) {
            escrever += host.getKey() + "\n";
        }

        escritor.escrever(escrever);
    }

    public static void limpaHost(LinkedHashMap<String, Host> hostList, String host) {
        if (hostList.containsKey(host)) {
            hostList.get(host).limparUrls();
        }
    }

    public static void limpaTudo(LinkedHashMap<String, Host> hostList) {
        hostList.clear();
    }

    public static void main(String[] args) throws FileNotFoundException {
        LinkedHashMap<String, Host> hostList = new LinkedHashMap<String, Host>();

        String nomeArquivo = args[0];
        Escritor escritor = new Escritor(nomeArquivo);
        Scanner teclado = new Scanner(new FileReader(nomeArquivo));
        while (teclado.hasNext()) {
            String entrada = teclado.nextLine();
            String[] e = entrada.split(" ");
            switch (e[0]) {
                case "ADD_URLS":
                    adicionarUrls(teclado, hostList, Integer.parseInt(e[1]));
                    break;
                case "ESCALONA_TUDO":
                    escalonaTudo(escritor, hostList);
                    break;
                case "ESCALONA_HOST":
                    escalonaHost(escritor, hostList, e[1], Integer.parseInt(e[2]));
                    break;
                case "ESCALONA":
                    escalona(escritor, hostList, Integer.parseInt(e[1]));
                    break;
                case "VER_HOST":
                    verHost(escritor, hostList, e[1]);
                    break;
                case "LISTA_HOSTS":
                    listaHosts(escritor, hostList);
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