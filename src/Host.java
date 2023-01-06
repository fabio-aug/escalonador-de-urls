import java.util.PriorityQueue;

/**
 * classe Host
 * 
 * Descrição:
 * Classe responsável por organizar e manipular URLs.
 */
public class Host {
    private PriorityQueue<String> list;

    /* 
     * Construtor da classe Host()
     * 
     * Descrição:
     * Instância um objeto do tipo validador para pegar profundidade das urls.
     * Instância a lista da classe como uma PriorityQueue<String> (min-heap) organizando pela profundidade.
     * Caso a nova URL seja maior ou igual irá retornar +1, assim ocorrendo a troca de posições,
     *      ordenando por profundidade onde a URL mais funda irá para o final e
     *      garantindo a ordem de inserção em caso de profundidades equivalentes.
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

    /* 
     * Função pegarTamanho()
     * 
     * Retorno:
     * Interger (Quantidade de URLs)
     * 
     * Descrição:
     * Retorna a quantidade de URLs do host.
     */
    public Integer pegarTamanho() {
        return this.list.size();
    }

    /* 
     * Método addUrl()
     * 
     * Parâmetros:
     * String URL (url a ser adicionada)
     * 
     * Descrição:
     * Adiciona uma nova URL na lista do host.
     */
    public void addUrl(String url) {
        this.list.add(url);
    }

    /*
     * Função escalona()
     * 
     * Parâmetros:
     * Int quantidade (quantidade de URLs que devem ser escalonadas)
     * 
     * Retorno:
     * String (URLs escalonadas)
     * 
     * Descrição:
     * A partir de uma quantidade informada, a função escalona X URLs do host,
     *      retira todas da lista e retorna as mesmas.
    */
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

    /*
     * Função escalonaTudo()
     * 
     * Retorno:
     * String (URLs escalonadas)
     * 
     * Descrição:
     * Escalona todas as URLs do host, retira todas da lista e retorna as mesmas.
    */
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

    /*
     * Função verHost()
     * 
     * Retorno:
     * String (URLs escalonadas)
     * 
     * Descrição:
     * Pega todas as URLs do host.
     * Uma cópia é feita para não afetar a lista original.
    */
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

    /*
     * Método limparUrls()
     * 
     * Descrição:
     * Usando o método clear() da PriorityQueue<String> limpa a lista.
    */
    public void limparUrls() {
        this.list.clear();
    }
}