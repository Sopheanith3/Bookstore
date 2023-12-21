/**
 * Course: TCSS 305 C, Programming Practicum
 * Instructor: Tom Capaul
 * Programming Assignment 3: BookStore
 * This ItemOrder class is store the information
 * about item order purchase for an item.
 */
package model;
/**
 * @author Sopheanith Ny
 * @version Autumn 2023
 * 
 * Represent the item information and quantity of the item order.
 */
public final class ItemOrder {
    /**
     * private instance for the item.
     */
    private final Item myItem;
    /**
     * private instance for the quantity of the item.
     */
    private final int myQuantity;
    /**
     * Constructor for the ItemOrder.
     *
     * @param theItem The item of the item order.
     * @param theQuantity the quantity of the item order.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if (theItem == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        this.myItem = theItem;
        if (theQuantity < 0) {
            throw new IllegalArgumentException("The quantity cannot be less than 0");
        }
        this.myQuantity = theQuantity;
    }
    /**
     * Get the item of the item order.
     *
     * @return the item in this order.
     */
    public Item getItem() {
        return myItem;
    }
    /**
     * Get the quantity of the item order.
     *
     * @return the quantity of the item order.
     */
    public int getQuantity() {
        return myQuantity;
    }

    /**
     * Representation of the itemOrder information in the format
     * item name and quantity.
     *
     * @return a string representative of the item order.
     */
    @Override
    public String toString() {
        return "Item: " + myItem + ", " + "Quantity: " + myQuantity;
    }
}
