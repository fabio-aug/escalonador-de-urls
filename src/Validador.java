/**
 * classe Validador
 * 
 * Descrição:
 * Classe responsável por validar e manipular URLs.
 */
public class Validador {

    public Integer pegarProfundidade(String url) {
        String auxString = url.replace("http://", "");

        int profundidade = auxString.split("/").length;

        return profundidade;
    }

    public String tratamentoDeUrl(String url) {
        String urlTratada = url.replace("www.", "");
        urlTratada = urlTratada.split("#")[0];

        if (urlTratada.endsWith("/")) {
            urlTratada = urlTratada.substring(0, urlTratada.length() - 1);
        }

        return urlTratada;
    }

    public String pegarHost(String url) {
        String path = url.split("://")[1];
        String host = path.split("/")[0];
        host = host.replace("www.", "");

        return host;
    }

    public boolean validaUrl(String url) {
        if (!urlHttp(url)) {
            return false;
        }

        if (urlArquivo(url)) {
            return false;
        }

        return true;
    }

    public static boolean urlHttp(String url) {
        String[] protocolo = url.split("://");
        return protocolo[0].equals("http");
    }

    public static boolean urlArquivo(String url) {
        String[] arquivosProibidos = {
                ".mp3", ".mp4", ".avi",
                ".png", ".jpg", ".jpeg", ".gif",
                ".txt", ".doc", ".docx", ".pdf"
        };

        for (String arquivo : arquivosProibidos) {
            if (url.contains(arquivo)) {
                return true;
            }
        }

        return false;
    }
}