/**
 * Course: TCSS 305 C, Programming Practicum
 * Instructor: Tom Capaul
 * Programming Assignment 3: BookStore
 * This CartTest class is the Junit test class
 * for the cart class to verify the method.
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import model.Cart;
import model.Item;
import model.ItemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Sopheanith Ny
 * @version Autumn 2023
 *
 * Represent the test cases for all the methods.
 */
class CartTest {
    /**
     * private instance field for the cart.
     */
    private Cart myCart;
    /**
     * private instance field for item 1.
     */
    private Item myItem1;
    /**
     * private instance field for item 2.
     */
    private Item myItem2;
    /**
     * protect default constructor.
     */
    protected CartTest() {
    }
    /**
     * Create the item name, price, bulk quantity and bulk price.
     * Add the all item into the cart.
     */
    @BeforeEach
    void setUp() {
        myCart = new Cart();
        myItem1 = new Item("Hot Wheels ", new BigDecimal("10.00"),
                5, new BigDecimal("45.00"));
        myItem2 = new Item("Hot Wheels Exclusive ", new BigDecimal("20.00"));

        myCart.add(new ItemOrder(myItem1, 3));
        myCart.add(new ItemOrder(myItem2, 2));
    }
    /**
     * Test the creation of the Item that adds to the cart.
     */
    @Test
    void testAdd() {
        myCart.add(new ItemOrder(myItem1, 5));
        assertEquals(2, myCart.getCartSize());
    }
    /**
     * Test the creation of the member make sure the member
     * has a membership.
     */
    @Test
    void testSetMembership() {
        myCart.setMembership(true);
        assertTrue(myCart.hasMembership());
    }
    /**
     * Test the creation of the calculation of the total
     * item in the cart.
     */
    @Test
    void testCalculateTotal() {
        assertEquals(new BigDecimal("70.00"), myCart.calculateTotal());
    }
    /**
     * Test the creation of the item that should be clear
     * the item in the cart.
     */
    @Test
    void testClear() {
        myCart.clear();
        assertEquals(0, myCart.getCartSize());
    }
    /**
     * Test the creation of the cart that get all the item
     * in the cart.
     */
    @Test
    void testGetCartSize() {
        assertEquals(2, myCart.getCartSize());
    }
    /**
     * Test the creation of the cart toString format.
     */
    @Test
    void testToString() {
        assertEquals("Cart: \nItem: Hot Wheels , $10.00 (5 for $45.00), "
                + "Quantity: 3\nItem: Hot Wheels Exclusive , $20.00, Quantity: 2"
                + "\nTotal: 70.00", myCart.toString());
    }
}
