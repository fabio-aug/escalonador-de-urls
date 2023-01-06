import java.util.PriorityQueue;

/**
 * classe Host
 * 
 * Descrição:
 * Classe responsável por organizar e manipular Hosts e URLs do mesmo.
 */
public class Host {
    private PriorityQueue<String> list;

    /*
     * Construtor da classe Host()
     * 
     * Descrição:
     * Instância um objeto do tipo validador para pegar profundidade das urls.
     * Instância a lista da classe como uma PriorityQueue<String> (min-heap)
     * organizando pela profundidade.
     * Caso a nova URL seja maior ou igual irá retornar +1, assim ocorrendo a troca
     * de posições,
     * ordenando por profundidade onde a URL mais funda irá para o final e
     * garantindo a ordem de inserção em caso de profundidades equivalentes.
     */
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
        if (!this.list.contains(url)){
            this.list.add(url);
        } 
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