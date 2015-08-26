

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InventoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InventoryTest
{
    /**
     * Default constructor for test class InventoryTest
     */
    public InventoryTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }
    public void testAddItem(){
        String [] itemnames = {"Kohle", "Faser", "Nagel", "Rostiger Nagel", "?????", "12 Pfund Fleisch"};
        Inventory inv = new Inventory();
       
        Item [] itemsarr = new Item[itemnames.length];
        assertEquals(itemnames.length, itemsarr.length);
        for (int i=0;i<itemsarr.length;i++){
            itemsarr[i] = new Item(itemnames[i]);
            inv.addItem(itemsarr[i]);
        }
         Player p = new Player("InventoryTester", inv);
         p.list_inventory();
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
