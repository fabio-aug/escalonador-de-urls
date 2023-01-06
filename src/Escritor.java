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
    private Boolean firstWriter;

    public Escritor(String nomeArquivo) {
        this.arquivo = new File(criarNomeArquivo(nomeArquivo));
        this.firstWriter = true;
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

            if (this.firstWriter) {
                this.firstWriter = false;
            } else {
                texto = "\n" + texto;
            }

            if (texto.endsWith("\n")) {
                texto = texto.substring(0, texto.length() - 1);
            }

            bw.append(texto);
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}