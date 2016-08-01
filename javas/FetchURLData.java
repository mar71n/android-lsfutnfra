import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
* @author Crunchify.com
*/

public class FetchURLData {
    public static void main(String[] args) {
        leerUrl();
    }

    private static void leerUrl(){
        try {
            URL url = new URL("http://www.metrovias.com.ar//Subterraneos//Estado?site=Metrovias");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                System.out.println(strTemp);
            }
        }catch (java.net.UnknownHostException ex){
            System.err.println("No se puede encontrar : " + ex.getMessage());
            ingresarProxy();
        }catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.toString());
            System.err.println(ex.getMessage());
        }
    }

    private static void ingresarProxy(){
        System.out.println ("Por favor introduzca http.proxyHost:");

        String proxyHost = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        proxyHost = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("Entrada recibida por teclado es: \"" + proxyHost +"\"");
        System.out.println ("Por favor introduzca http.proxyPort:");

        String proxyPort = "";
        proxyPort = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("Entrada recibida por teclado es: \"" + proxyPort +"\"");
        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);
        leerUrl();
    }
}
