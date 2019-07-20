/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.junit.samouczekprogramisty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Michał Walaszczyk
 */
public class Basket {

    Map<Item, Integer> orderedItems;

    public Basket() {
        this.orderedItems = new HashMap<>();
    }

    public Basket(Map<Item, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Map<Item, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<Item, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public void addItemToOrderedItems(Item item) {
        if (!this.orderedItems.isEmpty() && this.orderedItems.containsKey(item)) {
            this.orderedItems.compute(item, (k, v) -> ++v);
        } else {
            this.orderedItems.put(item, 1);
        }
    }

    public void addItemToOrderedItemsMultipleTimes(Item item, Integer numberOfItems) {
        if (numberOfItems < 1) {
            throw new IllegalArgumentException("Ilosc elementow w koszyku nie może być mniejsza niż 1.");
        }
        if (!this.orderedItems.isEmpty() && this.orderedItems.containsKey(item)) {
            this.orderedItems.compute(item, (k, v) -> v += numberOfItems);
        } else {
            this.orderedItems.put(item, numberOfItems);
        }
    }
    
    public void removeItem(Item item) {
        if (!this.orderedItems.isEmpty() && this.orderedItems.containsKey(item)) {
            this.orderedItems.remove(item);
        } else {
            throw new IllegalStateException("Kosztyk jest pusty lub nie posiada elementu, którego nastąpiła próba usunięcia.");
        }
    }
    
    public void removeItemMultipleTimes(Item item, Integer numberOfItems) {
        if (numberOfItems < 1) {
            throw new IllegalArgumentException("Ilosc elementow do usunięcia nie może być mniejsza niż 1.");
        }
        if (!this.orderedItems.isEmpty() && this.orderedItems.containsKey(item) && this.orderedItems.get(item) >= numberOfItems) {
            this.orderedItems.remove(item);
        } else {
            throw new IllegalStateException("Kosztyk jest pusty lub nie posiada elementów w ilości, w której nastąpiła próba usunięcia.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Basket other = (Basket) obj;
        if (!Objects.equals(this.orderedItems, other.orderedItems)) {
            return false;
        }
        return true;
    }
}
