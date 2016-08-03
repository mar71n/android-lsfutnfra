import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
// import java.io.BufferedInputStream;

public class WGetBO {

    public static void main(String[] args) {
        if (args.length > 0){
            System.setProperty("http.proxyHost", args[0]);
            System.setProperty("http.proxyPort", args[1]);
        }
        String nbo = "4933";
        String[] nbos = {"4936","4935","4934","4933","4932","4931","4930"};
        try{
            for (String ibo : nbos){
                System.out.println("B.O.: " + ibo);
                URL url = new URL("http://boletinoficial.buenosaires.gob.ar//?c=Boletin&a=descargarBoletin&numero=" + ibo);
                getAsByteArray(url, ibo);
                // String comando = "pasar.sh";
                // Process proceso = Runtime.getRuntime().exec(comando);
                // InputStream inputstream = proceso.getInputStream();
                // BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            }
        }catch (Exception ex){
            System.err.println("error " + ex.getMessage() + "\n" + ex.toString());
        }
    }    

    public static void getAsByteArray(URL url, String nbo) throws IOException {
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
            tmpOut = new ByteArrayOutputStream(1024*1024*3); // Pick some appropriate size
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
        FileOutputStream fos = new FileOutputStream("BO" + nbo + ".pdf");
        fos.write(array);
        fos.close();

        //return ByteBuffer.wrap(array);
    }
}