package utn.curso.mar71n.ejcalculadora;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    @SmallTest
    public void test_calculadorita2(){
        Calculadorita2 calc = new Calculadorita2();
        calc.ingresar("10", "+");
        calc.ingresar("10","/");
        assertEquals("20.00", calc.sR);
        calc.ingresar("2", "-");
        assertEquals("10.00", calc.sR);
        calc.ingresar("3", "*");
        assertEquals("7.00", calc.sR);
        calc.ingresar("3", "+");
        assertEquals("21.00", calc.sR);
        calc.ingresar("9", "=");
        assertEquals("30.00", calc.sR);
    }
    @SmallTest
    public void test_formatos(){
        String a = String.format("%.2f", 45f);
        String b = "45.00";
        assertEquals(b, a);
        a = String.format("%.3f", 45f);
        b = "45.000";
        assertEquals(b, a);
        a = String.format("%07.2f", 45f);
        b = "0045.00";
        assertEquals(b, a);
        a = String.format("%07.2f", 4.5f);
        b = "0004.50";
        assertEquals(b, a);
        a = String.format("%012.2f", 4.5f);
        b = "000000004.50";
        assertEquals(b, a);
        a = String.format("%012.2f", 2124.53213f);
        b = "000002124.53";
        assertEquals(b, a);
    }
}