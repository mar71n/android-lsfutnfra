import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileInputStream;

/**
* @author Crunchify.com
*/

public class BuscarTXT {

    public static void main(String[] args) {
        if (args.length > 0){
            System.setProperty("http.proxyHost", args[0]);
            System.setProperty("http.proxyPort", args[1]);
        }
        String nbo = "4933";
        String[] nbos = {"4936","4935","4934","4933","4932","4931","4930"};
        for (String ibo : nbos){
        System.out.println("txt B.O.: " + ibo);
        buscar(ibo);
        }
    }

    public static boolean buscar(String ibo) {
        String fromFile = "BO" + ibo + ".txt";
        String toFile = "logEncontrados.txt";
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                // We use a buffer for the copy (Usamos un buffer para la copia).
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    String s = new String(buf);
                    System.out.println(s);
                    Pattern p = Pattern.compile(".*DGESYC.*");
                    Matcher m = p.matcher(s);
                    if (m.matches()){
                        System.out.println(m.matches());
                        out.write(buf, 0, len);
                    }
                }
                in.close();
                out.close();
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
