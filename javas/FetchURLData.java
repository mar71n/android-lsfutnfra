import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
* @author Crunchify.com
*/

public class FetchURLData {
    public static void main(String[] args) {
        try {
            System.setProperty("http.proxyHost", "proxy.dgeyc");
            System.setProperty("http.proxyPort", "3128");
            URL url = new URL("http://www.metrovias.com.ar//Subterraneos//Estado?site=Metrovias");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                System.out.println(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.toString());
        }
    }
}
