/**
 * Course: TCSS 305 C, Programming Practicum
 * Instructor: Tom Capaul
 * Programming Assignment 3: BookStore
 * This Item class is where the object store
 * the information of the individual item.
 */
package model;
import java.math.BigDecimal;
import java.util.Objects;
/**
 * @author Sopheanith Ny
 * @version Autumn 2023
 *
 * Represent item name, price, bulk quantity
 * and bulk price.
 */
public final class Item implements Comparable<Item> {
    /**
     * private instance for the name of the item.
     */
    private final String myItemName;
    /**
     * private instance for the price of the item.
     */
    private final BigDecimal myItemPrice;
    /**
     * private instance for the bulk quantity.
     */
    private int myBulkQuantity;
    /**
     * private instance for the bulk price.
     */
    private BigDecimal myBulkPrice;

    /**
     * Constructor for the Item name and the single item price.
     *
     * @param theName  The name of the item.
     * @param thePrice The price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty and cannot be null.");
        }
        this.myItemName = theName;
        if (thePrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0.");
        }
        this.myItemPrice = thePrice;
    }

    /**
     * Constructor for the item with item name, price, bulk price
     * and bulk quantity.
     *
     * @param theName The name of the item.
     * @param thePrice The price of the item.
     * @param theBulkQuantity The bulk quantity of the item.
     * @param theBulkPrice The bulk price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        this.myItemName = theName;
        this.myItemPrice = thePrice;
        if (theBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The Bulk Price cannot be less than 0.");
        }
        this.myBulkQuantity = theBulkQuantity;
        if (theBulkQuantity <= 0) {
            throw new IllegalArgumentException("Invalid bulk quantity.");
        }
        this.myBulkPrice = theBulkPrice;
    }
    /**
     * Get the single item of the item.
     *
     * @return The single item price as a Big Decimal.
     */
    public BigDecimal getPrice() {
        return myItemPrice;
    }
    /**
     * Get the bulk quantity for the item.
     *
     * @return the bulk quantity item.
     */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }
    /**
     * Get the bulk price of the item.
     *
     * @return the bulk price as a Big Decimal.
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }
    /**
     * Check if the item has bulk price.
     *
     * @return true if the item has bulk price. Otherwise,
     * it will turn false if its null.
     */
    public boolean isBulk() {
        return myBulkQuantity > 0 && myBulkPrice != null;
    }
    /**
     *  Representation of the item information in format. If the item does
     *  have a bulk price, it will return name, price bulk quantity and bulk
     *  price. Otherwise, it will just return name and price.
     *
     * @return a string represents this item with the following format:
     * "name, $price (bulkQuantity for $bulkPrice)".
     */
    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder();
        string.append(myItemName).append(", ").
                append("$").append(myItemPrice);
        if (isBulk()) {
            string.append(" (").append(myBulkQuantity).append(" for $").
                    append(myBulkPrice).append(")");
        }
        return string.toString();
    }

    /**
     * Check if the other object is equal to the current item.
     *
     * @param theOther The object with which to compare.
     * @return It returns true if the specified object is equivalent
     * to this item, otherwise, it will return false.
     */
    @Override
    public boolean equals(final Object theOther) {
        if (getClass() != theOther.getClass()) {
            return false;
        }
        final Item otherItem = (Item) theOther;
        return myItemName.equals(otherItem.myItemName)
                && myItemPrice.equals(otherItem.myItemPrice)
                && Objects.equals(myBulkPrice, otherItem.myBulkPrice)
                && Objects.equals(myBulkQuantity, otherItem.myBulkQuantity);
    }
    /**
     * Generate the hash code for the item to inherit from the object.
     *
     * @return an integer hash code computed that based on name,
     * price, bulk quantity and bulk price.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myItemName, myItemPrice, myBulkQuantity, myBulkPrice);

    }
    /**
     * Compared this item to the other item by name and price.
     *
     * @param theOther the object to be compared.
     * @return compare the name and the price by the name and price.
     */
    @Override
    public int compareTo(final Item theOther) {
        final int compare = myItemName.compareTo(theOther.myItemName);
        if (compare != 0) {
            return compare;
        }
        return myItemPrice.compareTo(theOther.myItemPrice);
    }

    /**
     * Compare the other by price.
     *
     * @return the item price
     */
    public BigDecimal orderByPrice() {
        return myItemPrice;
    }
}
