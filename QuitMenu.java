/**
 * CLASS: QuitMenu
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: A subclass of MenuItem which handles if the player wishes to quit from the menu
 */

public class QuitMenu extends MenuItem {
    
    public QuitMenu(String option) {

        super("Quit");
    }
    
    /**
     * select
     * 
     * PURPOSE: determines the next state of the game. False in this case
     * 
     * RETURNS: false since quitting means there is no next state
     */
    public boolean select(Viewable v, GameLogical gl) {

        System.exit(0);
        
        return false;
    }
}
