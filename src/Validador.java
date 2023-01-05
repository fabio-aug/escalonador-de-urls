/**
 * Validador
 */
public class Validador {
    public Integer pegarProfundidade(String url) {
        String auxString = url.replace("http://", "");

        int profundidade = auxString.split("/").length;

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
        String[] arquivosProibidas = {
                ".mp3", ".mp4", ".avi",
                ".png", ".jpg", ".jpeg", ".gif",
                ".txt", ".doc", ".docx", ".pdf"
        };

        for (String arquivos : arquivosProibidas) {
            if (url.contains(arquivos)) {
                return true;
            }
        }

        return false;
    }
}