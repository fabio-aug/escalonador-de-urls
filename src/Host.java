import java.util.PriorityQueue;

/**
 * Host
 */
public class Host {
    private PriorityQueue<String> list;

    public Host() {
        Validador vUrl = new Validador();
        this.list = new PriorityQueue<>((a, b) -> vUrl.pegarProfundidade(a) - vUrl.pegarProfundidade(b));
    }

    public void addUrl(String url) {
        this.list.add(url);
    }

    public String escalona(int quantidade) {
        String retorno = "";

        if (quantidade > this.list.size()) {
            retorno = escalonaTudo();
        } else {
            for (int i = 0; i < quantidade; i++) {
                retorno += this.list.remove() + "\n";
            }
        }

        return retorno;
    }

    public String escalonaTudo() {
        String retorno = "";

        for (int i = 0; i < this.list.size(); i++) {
            retorno += this.list.remove() + "\n";
        }

        return retorno;
    }

    public String verHost() {
        String retorno = "";

        return retorno;
    }

    public void limparUrls() {
    }
}