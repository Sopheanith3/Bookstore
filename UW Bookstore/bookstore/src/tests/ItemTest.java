/**
 * Course: TCSS 305 C, Programming Practicum
 * Instructor: Tom Capaul
 * Programming Assignment 3: BookStore
 * This ItemTest class is the Junit test class
 * for the item class to verify the method.
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Sopheanith Ny
 * @version Autumn 2023
 *
 * Represent the test cases for all the methods.
 */
class ItemTest {
    /**
     * private instance for the item.
     */
    private Item myItem;
    /**
     * protected empty constructor.
     */
    protected ItemTest() {
    }
    /**
     * Create the item name, item price, and bulk quantity and bulk price.
     */
    @BeforeEach
    void setUp() {
        myItem = new Item("Hot Wheels", new BigDecimal("30.00"),
                5 , new BigDecimal("55.00"));
    }
    /**
     * Test the creation of the Item with a get price.
     */
    @Test
    void testGetPrice() {
        assertEquals(new BigDecimal("30.00"), myItem.getPrice());
    }
    /**
     * Test the creation of the Item with a bulk quantity.
     */
    @Test
    void testGetBulkQuantity() {
        assertEquals(5, myItem.getBulkQuantity());
    }

    /**
     * Test a creation of the Item with the bulk price.
     */
    @Test
    void testGetBulkPrice() {
        assertEquals(new BigDecimal("55.00"), myItem.getBulkPrice());
    }
    /**
     * Test a creation of the Item if the item has bulk price.
     */
    @Test
    void testIsBulk() {
        assertTrue(myItem.isBulk());
    }
    /**
     * Test a creation of the Item with the toString Item format.
     */
    @Test
    void testToString() {
        assertEquals("Hot Wheels, $30.00 (5 for $55.00)", myItem.toString());
    }
    /**
     * Test the equality of the two different Item.
     */
    @Test
    void testEquals() {
        final Item compareItem = new Item("Hot Wheels", new BigDecimal("30.00"),
                        5 , new BigDecimal("55.00"));
        assertEquals(myItem, compareItem);
    }
    /**
     * Test the hashCode method for the item with
     * the same item name and price.
     */
    @Test
    void testHashCode() {
        final Item compareItem = new Item("Hot Wheels", new BigDecimal("30.00"),
                5 , new BigDecimal("55.00"));
        assertEquals(myItem.hashCode(), compareItem.hashCode());
    }
    /**
     * Test the compareTo method for the item and price that
     * item ordered are correct based on their name and price.
     */
    @Test
    void testCompareTo() {
        final Item item1 = new Item("AAA", new BigDecimal("10.99"));
        final Item item2 = new Item("ABC", new BigDecimal("5.99"));
        final Item item3 = new Item("XYZ", new BigDecimal("0.99"));
        assertTrue(item1.compareTo(item2) < 0);
        assertTrue(item2.compareTo(item3) < 0);
    }
    /**
     * Test the order by price method for ordering price.
     */
    @Test
    void testOrderByPrice() {
        final Item item1 = new Item("AAA", new BigDecimal("0.99"));
        final Item item2 = new Item("ABC", new BigDecimal("10.99"));
        final Item item3 = new Item("XYZ", new BigDecimal("0.01"));
        final Item item4 = new Item("XYZ", new BigDecimal("0.99"));
        final Item item5 = new Item("ABC", new BigDecimal("9.99"));

        assertEquals(new BigDecimal("0.99"), item1.orderByPrice());
        assertEquals(new BigDecimal("10.99"), item2.orderByPrice());
        assertEquals(new BigDecimal("0.01"), item3.orderByPrice());
        assertEquals(new BigDecimal("0.99"), item4.orderByPrice());
        assertEquals(new BigDecimal("9.99"), item5.orderByPrice());
    }
}
