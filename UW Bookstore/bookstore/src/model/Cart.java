/**
 * Course: TCSS 305 C, Programming Practicum
 * Instructor: Tom Capaul
 * Programming Assignment 3: BookStore
 * This Cart class is stores information about the
 * customer overall purchase.
 */
package model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Sopheanith Ny
 * @version Autumn 2023
 *
 * Represent item the list of the items,
 * membership, overall item purchase, get the
 * cart size and remove all items in the cart,
 */
public class Cart {
    /**
     * private instance for the list of the item order.
     */
    private final List<ItemOrder> myItems;
    /**
     * private instance for membership.
     */
    private boolean myMembership;
    /**
     * Constructor for an empty shopping cart.
     */
    public Cart() {
        this.myItems = new ArrayList<>();
        this.myMembership = false;
    }
    /**
     * Adds an order to the shopping cart and replacing
     * the previous order for an equivalent item with the new
     * order.
     *
     * @param theOrder The item order to add to the cart.
     */
    public void add(final ItemOrder theOrder) {
        for (int i = 0; i < myItems.size(); i++) {
            if (myItems.get(i).getItem().equals(theOrder.getItem())) {
                myItems.set(i, theOrder);
                return;
            }
        }
        myItems.add(theOrder);
    }

    /**
     * Sets whether is trye if customer for this shopping cart has
     * a store membership.
     *
     * @param theMembership Return true if the customer has a membership.
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }
    /**
     * Check if the customer has membership.
     *
     * @return true customer has the membership.
     */
    public boolean hasMembership() {
        return myMembership;
    }
    /**
     * Calculates and return the total cost of the item in the shopping
     * cart.
     *
     * @return The total cost as a Big Decimal round half even.
     */
    public BigDecimal calculateTotal() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (final ItemOrder item : myItems) {
            totalCost = totalCost.add(item.getItem().getPrice().
                    multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return totalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    /**
     * Remove all order items from the cart.
     */
    public void clear() {
        myItems.clear();
    }
    /**
     * Get the number of the current item order in the cart.
     *
     * @return the number of the item order in the cart.
     */
    public int getCartSize() {
        return myItems.size();
    }
    /**
     * Representative of the shopping cart, including the list of item
     * in the cart and the total of the item cost in the cart.
     *
     * @return a string representing the shopping carts.
     */
    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder();
        string.append("Cart: \n");
        for (final ItemOrder item : myItems) {
            string.append(item + "\n");
        }
        string.append("Total: " + calculateTotal());
        return string.toString();
    }

}
