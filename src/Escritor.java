import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor {
    private String nomeArquivo;

    public Escritor(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo+"-out";
    }

    public void criaArquivo() throws IOException {
        File resultado = new File(this.nomeArquivo);
        resultado.createNewFile();
    }

    public void complementaArquivo(File resultado,String texto) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(resultado));
        br.write(texto + "\n");
        br.close();
    }
}
