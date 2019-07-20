/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.junit.samouczekprogramisty;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author micmark
 */
public class ItemTest {
    
    private Item itemWorthTwoPointFifty;
    
    public ItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.itemWorthTwoPointFifty = new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN.");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void shouldCheckEqualityOfItems() {
        Item item1 = new Item(new BigDecimal(1), "item1");
        Item item2 = new Item(new BigDecimal(1), "item1");
        System.out.println(item1 == item2); //false
        System.out.println(item1.equals(item2)); //true
        assertEquals(item1, item2);
    }
}
