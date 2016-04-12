package utn.curso.mar71n.ejcalculadora;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    @SmallTest
    public void test_calculadorita(){
        Calculadorita calc = new Calculadorita();
        calc.ingresar("10");
        calc.ingresar("+");
        calc.ingresar("20");
        assertEquals("30.000000", calc.r);
        calc.ingresar("-");
        calc.ingresar("14");
        assertEquals("16.000000", calc.r);
        calc.ingresar("*");
        calc.ingresar("3");
        assertEquals("48.000000", calc.r);
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