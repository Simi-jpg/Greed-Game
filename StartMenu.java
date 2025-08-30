/**
 * CLASS: StartMenu
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: A subclass of MenuItem which handles if the player wishes to start a game from the menu
 */

 public class StartMenu extends MenuItem {
    
    public StartMenu(String option) {
        
        super("Start Game");
    }


/**
     * select
     * 
     * PURPOSE: determines the next state of the game. True in this case
     * 
     * RETURNS: true since starting a game means there is a next state
     */

    public boolean select(Viewable v, GameLogical gl) {
        
        return true;
    }
}
