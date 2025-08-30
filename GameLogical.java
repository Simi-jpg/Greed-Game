/**
 * CLASS: GameLogical
 * AUTHOR: Adeniyi Simi
 * 
 * PURPOSE: The GameLogical interface is used to define the methods that a game must implement to carry out the logical aspects of game play.
 */

public interface GameLogical extends Viewable {
    
    //Methods

    /**
     * Method: nextState
     * 
     * @description: This method is used to determine the next state of the game after each move/ play
     * 
     * @param v is a viewable type. Anything that can be printed to the console is a viewable type.
     * @return boolean - returns false if the game is over or if the player chooses to quit, true otherwise
     */
    boolean nextState(Viewable v);//return of false implies there is no next state

    /**
     * Method: reset
     * 
     * @description: This method is used to reset the game to its initial state.
     */
    void reset();
}

