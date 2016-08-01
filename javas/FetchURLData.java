import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* @author Crunchify.com
*/

public class FetchURLData {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", args[0]);
        System.setProperty("http.proxyPort", args[1]);
        //leerUrl();
        leerUrlbin();
    }

    private static void leerUrl(){
        try {
            URL url = new URL("http://www.metrovias.com.ar//Subterraneos//Estado?site=Metrovias");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                System.out.print(strTemp);
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

    private static void leerUrlbin(){
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        try {
            fos = new FileOutputStream("boletin.pdf");
            salida = new DataOutputStream(fos);
            URL url = new URL("http://boletinoficial.buenosaires.gob.ar//?c=Boletin&a=descargarBoletin&numero=4934");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            int intTemp;
            while (-1 != (intTemp = br.read())) {
                char chrTemp = (char) intTemp;
                //System.out.println(chrTemp);
                salida.writeByte((byte)intTemp);
                
            }
        }catch (java.net.UnknownHostException ex){
            System.err.println("No se puede encontrar : " + ex.getMessage());
            //ingresarProxy();
        }catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.toString());
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
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
        //leerUrl();
        leerUrlbin();
    }
}
