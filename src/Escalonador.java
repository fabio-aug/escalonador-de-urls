import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.FileReader;import java.util.Scanner;
/**
 * Escalonador
 */
public class Escalonador {
    public static void main(String[] args) throws FileNotFoundException {
        String nomeArquivo = args[0];
        Scanner teclado = new Scanner(new FileReader(nomeArquivo));
        while (teclado.hasNext()) {
            String entrada = teclado.nextLine();
            String[] e = entrada.split(" ");
            switch(e[0]){
                case "ADD_URLS":
                    for(int i = 0; i < Integer.parseInt(e[1]); i++){
                        validaUrl(teclado.nextLine());
                    }
                    break;
                case "ESCALONA_TUDO":
                    break;
                case "ESCALONA_HOST":
                    System.out.println("escalona host");
                    break;
                case "VER_HOST":
                    System.out.println("ver host");
                    break;
                case "LISTA_HOSTS":
                    break;
                case "LIMPA_HOST":
                    break;
                case "LIMPA_TUDO":
                    break;
            }
        }
    }
    public static boolean validaUrl(String url){
        if (validaProtocolo(url)){

        }
        return true;
    }

    public static boolean validaProtocolo(String url){
        String[] protocolo = url.split(":");
        if(protocolo[0].equals("http")){
            return true;
        } else {
            return false;
        }
    }
}