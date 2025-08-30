/**
 * CLASS: GamePiece
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: This is the parent class for any player type. It defines any player's common attributes like their score, position on the board and
 *                      the method that collect stheir next move.
 */

public abstract class Player implements Playable {
    //Instance Variables

    //player's position
    private int rowPos;
    private int colPos;

    //player's token
    private char token;

    //player's score
    private int score;


    public Player() {

        this.rowPos = 0;
        this.colPos = 0;

        score = 0;
    }

    /**
     * requestMove
     * 
     * PURPOSE: This method collects a player's next choice. It reads in user input either through the console or from  a text file
     *                  depending on what kind of player is in the game
     * 
     * RETURNS: The player's next move (int)
     */

    public abstract int requestMove();


    //Getters and Setters
    public int getRowPos() {
        return rowPos;
    }

    public int getColPos() {
        return colPos;
    }

    public char getToken() {
        return token;
    }

    public int getScore() {
        return score;
    }

    public void setPosition(int rowPos, int colPos) {

        this.rowPos = rowPos;
        this.colPos = colPos;

    }
    public void setToken(char token) {
        this.token = token;
    }

    public void setScore(int score) {

        this.score = score;
    }
}
