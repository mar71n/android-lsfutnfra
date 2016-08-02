import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

/**
* @author Crunchify.com
*/

public class FetchURLData {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", args[0]);
        System.setProperty("http.proxyPort", args[1]);
        //leerUrl();
        //leerUrlbin();
        try{
            URL url = new URL("http://boletinoficial.buenosaires.gob.ar//?c=Boletin&a=descargarBoletin&numero=4934");
            getAsByteArray(url);
        }catch (Exception ex){
            System.err.println("error " + ex.getMessage() + "\n" + ex.toString());
        }
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

    public static void getAsByteArray(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        // Since you get a URLConnection, use it to get the InputStream
        InputStream in = connection.getInputStream();
        // Now that the InputStream is open, get the content length
        int contentLength = connection.getContentLength();

        // To avoid having to resize the array over and over and over as
        // bytes are written to the array, provide an accurate estimate of
        // the ultimate size of the byte array
        ByteArrayOutputStream tmpOut;
        if (contentLength != -1) {
            tmpOut = new ByteArrayOutputStream(contentLength);
        } else {
            tmpOut = new ByteArrayOutputStream(16384); // Pick some appropriate size
        }

        byte[] buf = new byte[512];
        while (true) {
            int len = in.read(buf);
            if (len == -1) {
                break;
            }
            tmpOut.write(buf, 0, len);
        }
        in.close();
        tmpOut.close(); // No effect, but good to do anyway to keep the metaphor alive

        byte[] array = tmpOut.toByteArray();

        //Lines below used to test if file is corrupt
        FileOutputStream fos = new FileOutputStream("abc.pdf");
        fos.write(array);
        fos.close();

        //return ByteBuffer.wrap(array);
   }
}
