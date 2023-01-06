import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * classe Escritor
 * 
 * Descrição:
 * Classe responsável por criar, limpar e escrever em arquivos.
 */
public class Escritor {
    private File arquivo;

    public Escritor(String nomeArquivo) {
        this.arquivo = new File(criarNomeArquivo(nomeArquivo));
        criaArquivo();
    }

    private void criaArquivo() {
        try {
            if (!this.arquivo.createNewFile()) {
                FileWriter fw = new FileWriter(this.arquivo, false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String criarNomeArquivo(String nomeArquivo) {
        String[] partes = nomeArquivo.split("\\.");
        String nome = partes[0] + "-out." + partes[1];

        return nome;
    }

    public void escrever(String texto) {
        try {
            FileWriter fw = new FileWriter(this.arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(texto);
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}