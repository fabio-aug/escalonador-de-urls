/**
 * Validador
 */
public class Validador {
    public Integer pegarProfundidade(String url) {
        String auxString = url.replace("http://", "");

        int profundidade = auxString.split("/").length;

        if (profundidade > 0) {
            profundidade--;
        }

        return profundidade;
    }

    public String tratamentoDeUrl(String url) {
        String urlTratata = url.replace("www.", "");
        urlTratata = urlTratata.split("#")[0];

        if (urlTratata.endsWith("/")) {
            urlTratata = urlTratata.substring(0, urlTratata.length() - 1);
        }

        return urlTratata;
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
        if (url.contains(".jpg")) {
            return true;
        }
        if (url.contains(".gif")) {
            return true;
        }
        if (url.contains(".mp3")) {
            return true;
        }
        if (url.contains(".avi")) {
            return true;
        }
        if (url.contains(".doc")) {
            return true;
        }
        if (url.contains(".pdf")) {
            return true;
        }

        return false;
    }
}