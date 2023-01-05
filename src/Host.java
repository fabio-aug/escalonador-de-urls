import java.util.PriorityQueue;

/**
 * Host
 */
public class Host {
    private PriorityQueue<String> list;

    public Host() {
        Validador vUrl = new Validador();
        this.list = new PriorityQueue<>((a, b) -> {
            if (vUrl.pegarProfundidade(a) >= vUrl.pegarProfundidade(b)) {
                return +1;
            } else {
                return -1;
            }
        });
    }

    public Integer pegarTamanho() {
        return this.list.size();
    }

    public void addUrl(String url) {
        this.list.add(url);
    }

    public String escalona(int quantidade) {
        String retorno = "";

        for (int i = 0; i < quantidade; i++) {
            String url = this.list.poll();
            if (url != null) {
                retorno += url + "\n";
            }
        }

        return retorno;
    }

    public String escalonaTudo() {
        String retorno = "";

        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            String url = this.list.poll();
            if (url != null) {
                retorno += url + "\n";
            }
        }

        return retorno;
    }

    public String verHost() {
        String retorno = "";

        PriorityQueue<String> urls = new PriorityQueue<String>(this.list);
        int size = urls.size();
        for (int i = 0; i < size; i++) {
            String url = urls.poll();
            if (url != null) {
                retorno += url + "\n";
            }
        }

        return retorno;
    }

    public void limparUrls() {
        this.list.clear();
    }
}