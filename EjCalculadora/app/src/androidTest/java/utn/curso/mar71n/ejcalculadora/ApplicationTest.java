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
        assertEquals("48.000000",calc.r);
    }

}