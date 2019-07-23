/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.junit.samouczekprogramisty;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Michał Walaszczyk
 */
public class BasketTest {

    private Basket basket;
    private Map<Item, Integer> expectedOrderedItemMap;
    private Basket expectedBasket;
    private Item itemWorthTwoPointFifty;
    private Item itemWorthTwelvePointFifty;

    public BasketTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.basket = new Basket();
        this.expectedOrderedItemMap = new HashMap();
        this.expectedBasket = new Basket();
        this.itemWorthTwoPointFifty = new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN.");
        this.itemWorthTwelvePointFifty = new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN.");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldAddItemToEmptyBasket() {
        this.expectedOrderedItemMap.put(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."), 1);
        this.expectedBasket.setOrderedItems(this.expectedOrderedItemMap);
        this.basket.addItemToOrderedItems(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."));
        Assert.assertEquals(this.expectedBasket.getOrderedItems().size(), this.basket.getOrderedItems().size());
        Assert.assertTrue(this.basket.getOrderedItems().containsKey(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN.")));
        Assert.assertTrue(this.basket.getOrderedItems().containsValue(this.expectedBasket.getOrderedItems().get(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."))));
        Assert.assertEquals(this.basket, this.expectedBasket);
    }

    @Test
    public void shouldAddTwoItems() {
        this.expectedOrderedItemMap.put(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."), 1);
        this.expectedOrderedItemMap.put(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 4);
        this.expectedBasket.setOrderedItems(this.expectedOrderedItemMap);
        this.basket.addItemToOrderedItems(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."));
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 4);
        Assert.assertEquals(this.expectedBasket.getOrderedItems().size(), this.basket.getOrderedItems().size());
        Assert.assertTrue(this.basket.getOrderedItems().containsKey(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN.")));
        Assert.assertTrue(this.basket.getOrderedItems().get(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."))
                .equals(this.expectedBasket.getOrderedItems().get(new Item(BigDecimal.valueOf(12.50), "Item worth 12.50 PLN."))));
        Assert.assertTrue(this.basket.getOrderedItems().get(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."))
                .equals(this.expectedBasket.getOrderedItems().get(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."))));
        Assert.assertEquals(this.basket, this.expectedBasket);
    }

    @Test
    public void shouldAddMultipleItemsOfSameTime() {
        this.expectedOrderedItemMap.put(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 4);
        this.expectedBasket.setOrderedItems(this.expectedOrderedItemMap);
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 4);
        Assert.assertEquals(this.expectedBasket.getOrderedItems().size(), this.basket.getOrderedItems().size());
        Assert.assertTrue(this.basket.getOrderedItems().get(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."))
                .equals(this.expectedBasket.getOrderedItems().get(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."))));
        Assert.assertEquals(this.basket, this.expectedBasket);
    }

    @Test
    public void shouldProveEquality() {
        Assert.assertEquals(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."),
                new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToAddNegativeNumberOfItems() {
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), -2);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowDeteleItemFromEmptyBasket() {
        this.basket.addItemToOrderedItems(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."));
        this.basket.removeItem(new Item(BigDecimal.valueOf(5.50), "Item worth 5.50 PLN."));
    }

    @Test
    public void shouldDeleteItem() {
        this.basket.addItemToOrderedItems(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."));
        this.basket.removeItem(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."));
    }

    @Test
    public void shouldDeleteMultipleItems() {
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 5);
        this.basket.removeItemMultipleTimes(this.itemWorthTwoPointFifty, 4);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToDeleteNegativeNumberOfItems() {
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 5);
        this.basket.removeItemMultipleTimes(this.itemWorthTwoPointFifty, -1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowToDeleteMoreItemsThanItIsInTheBasket() {
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(BigDecimal.valueOf(2.50), "Item worth 2.50 PLN."), 5);
        this.basket.removeItemMultipleTimes(this.itemWorthTwoPointFifty, 6);
    }

    @Test
    public void shouldCheckValueOfTheOrder() {
        this.basket.addItemToOrderedItemsMultipleTimes(this.itemWorthTwoPointFifty, 3);
        this.basket.addItemToOrderedItemsMultipleTimes(this.itemWorthTwelvePointFifty, 1);
        Assert.assertEquals(this.basket.computeTotalPriceOfAllItemsInTheBasket(), new BigDecimal("20.0"));
    }
    
    @Test
    public void shouldCheckToString() {
        this.basket.addItemToOrderedItemsMultipleTimes(new Item(new BigDecimal(11), "Kebab"), 2);
        System.out.println(this.basket.toString());
        Assert.assertEquals("0. - Kebab - 11 PLN x 2 szt = 22 PLN", this.basket.toString());
    }

//    @Test
//    public void shouldImplementComparableInterface() {
//    }
}
