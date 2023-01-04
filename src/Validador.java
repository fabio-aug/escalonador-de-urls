public class Validador {
    public Integer pegarProfundidade(String url) {
        return url.length();
    }

    public String tratamentoDeUrl(String url) {
        return url;
    }

    public String pegarHost(String url) {
        return url;
    }

    public boolean validaUrl(String url) {
        return true;
    }

    public static boolean validaProtocolo(String url) {
        String[] protocolo = url.split(":");
        if (protocolo[0].equals("http")) {
            return true;
        } else {
            return false;
        }
    }
}