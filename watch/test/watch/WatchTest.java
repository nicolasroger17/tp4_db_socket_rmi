/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package watch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ychabcho
 */
public class WatchTest {

    public WatchTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of a method, of class Watch.
     */
    @Test
    public void testA() {
        System.out.println("a");
        Watch instance = new Watch();
        instance.a();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of b method, of class Watch.
     */
    @Test
    public void testB() {
        System.out.println("b");
        Watch instance = new Watch();
        instance.b();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWatchObserver method, of class Watch.
     */
    @Test
    public void testAddWatchObserver() {
        System.out.println("addWatchObserver");
        WatchObserver watchObserver = null;
        Watch instance = new Watch();
        instance.addWatchObserver(watchObserver);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}