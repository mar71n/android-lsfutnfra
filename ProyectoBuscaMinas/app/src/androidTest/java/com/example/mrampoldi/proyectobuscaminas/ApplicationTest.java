package com.example.mrampoldi.proyectobuscaminas;

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
    public void test_Sector_incCuantos(){
        SectorMinado sm = new SectorMinado();
        assertEquals(sm.getCuantos(),0);
        sm.incCuantos();
        assertEquals(sm.getCuantos(), 1);
    }

    @SmallTest
    public void test_Campo_crear(){
        CampoMinado cm = new CampoMinado(5,5);
        SectorMinado sm = cm.getSM(1,2);
        sm.incCuantos();
        sm.incCuantos();
        sm.incCuantos();
        assertEquals(sm.getCuantos(), 3);
    }
}