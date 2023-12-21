/**
 * Course: TCSS 305 C, Programming Practicum
 * Instructor: Tom Capaul
 * Programming Assignment 3: BookStore
 * This ItemOrderTest class is the Junit test class
 * for the itemOrder class to verify the method.
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Sopheanith Ny
 * @version Autumn 2023
 *
 * Represent the test cases for all the method.
 */
class ItemOrderTest {
    /**
     * private instance for the item.
     */
    private Item myItem;
    /**
     * private instance list for order.
     */
    private ItemOrder myItemOrder;
    /**
     * protected constructor for ItemOrderTest.
     */
    protected ItemOrderTest() {
    }
    /**
     * Create the item name, price, bulk quantity and bulk price.
     */
    @BeforeEach
    void setUp() {
        myItem  = new Item("Hot Wheels", new BigDecimal("30.99"),
                5 , new BigDecimal("55.99"));
        myItemOrder = new ItemOrder(myItem, 3);
    }
    /**
     * Test the creation of the Item with a get item.
     */
    @Test
    void testGetItem() {
        assertEquals(myItem, myItemOrder.getItem());
    }
    /**
     * Test the creation of the Item with quantity.
     */
    @Test
    void testGetQuantity() {
        assertEquals(3, myItemOrder.getQuantity());
    }

    /**
     * Test the creation of the Item with the toString item format.
     */
    @Test
    void testToString() {
        assertEquals("Item: Hot Wheels, $30.99 (5 for $55.99), Quantity: 3",
                myItemOrder.toString());
    }
}
