/**
 * 
 * CLASS: GameBoard (ABSTRACT CLASS)
 * 
 * AUTHOR Adeniyi Simi
 * 
 * PURPOSE: This class is the abstract class for the GameBoard. This class is the parent class for the GreedGameBoard class. It outlines all basic behaviurs any game with a
 *                     board should have. It also outlines the methods that all game boards should have. This class is abstract because it is not meant to be used
 *                     directly. 
 */

public abstract class GameBoard implements GameBoardable {

    //Instance Variables

    //the dimensions of the board never change
    private final int ROWS = 20; 
    private final int COLS = 80;

    //the player who is playing the game.
   private Player player; 


    public GameBoard (Player p) {

        player = p;

        initializeBoard(); //fill up the board with appropraite tokens based on the game type.
    }


    //prints out the game board to the console.
    public abstract void view();

  /**
    * movePlayer
    * 
    * PURPOSE: This is responsible for moving the player token around the board
    * 
    * PARAMETERS: takes in the int choice which is the direction a player wants to move (or 0 to quit)
    */
    public abstract void movePlayer(int choice);

    //clears the board and resets the game.
    public void reset() {

        clear();

        initializeBoard();
    }
        
        
    //clears the board and replaces the tokens with empty spaces.
    public abstract void clear();

   //fill up the board with appropraite tokens based on the game type.
    public abstract void initializeBoard();

    
    /**
     * onBoard
     * 
     * PURPOSE: checks if a position is within the bounds of the board
     * 
     * PARAMETERS: takes in the indices we are trying to check
     * 
     * RETURN: true if [row][col] is within the dimensions of the board, false otherwise
     */
    public boolean onBoard(int row, int col) {

            int maxRows = getRows();
            int maxCols = getColumn();

            return (0 <= row) && (row < maxRows) && (0 <= col) && (col < maxCols);
    }


    //getters
    public int getRows() {
        return ROWS;
    }

    public int getColumn() {
      
        return COLS;
    }
    
    public Player getPlayer() {

        return player;
    }
}
