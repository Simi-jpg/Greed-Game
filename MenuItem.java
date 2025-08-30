/**
 * CLASS: MenuItem
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: This is the parent class for any choice we have in our menu (start, quit and anything else that can be there) 
 *                     Implements the Selectable interface because a menu item can be selelcted
 */

public abstract class MenuItem implements Selectable {
    
    //the menu item
    private String option;

    public MenuItem() {

    }
    
    public MenuItem (String option) {

        this.option = option;
    }

    /**
     * select
     * 
     * PURPOSE: To check the result of what a user has selected and return the choice with it's boolean value
     * 
     * PARAMETERS: v is a viewable type thatt represents anything that can be viewed (printed to console)
     *                          gl is the logic of the game
     * 
     * RETURNS: a boolean true if the user wishes to carry on in the game; false if otherwise
     */
   public abstract boolean select(Viewable v, GameLogical gl);

    //Getters
    public String getOption() {
        return option;
    }

}
