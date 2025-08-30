/**
 * CLASS: Menuable
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: This is an interface that defines a behaviour for anything with a menu. The behaviour it defines is to print a menu message
 */

public interface Menuable extends GameLogical {

    /**
     * Prints a welcome message any time we are in the main menu
     * 
     * PARAMETER: accepts the message as a parameter
     */
    void setMessage(String message);
}