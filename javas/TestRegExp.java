import java.util.regex.Pattern;
import java.util.regex.Matcher;

 public class TestRegExp {
    public static void main(String[] args) {
        Pattern p = Pattern.compile(".*DGESYC.*");
        Matcher m = p.matcher("DISPOSICIÓN N.° 149/DGESYC/16");
        boolean b = m.matches();
        System.out.println(b);
        p = Pattern.compile(".*([a-z.]+@[a-z.]+).*");
        m = p.matcher("Hay en este texto un algo@domi.com mail?");
        b = m.matches();
        System.out.println(b);
        System.out.println(m.group());
        System.out.println(m.group(1));
        String linea = "Hay en este texto un algo@domi.com mail o dos algo@domi.com?";
        System.out.println(linea.matches(".*[a-z.]+@[a-z.]+.*"));
    }
 }