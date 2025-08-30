/**
 * CLASS: GreedGameLogic
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARK: Handles all rules and logic that applies to a greed game. Checks for valid moves, updates the score and checks if the game is over or not
 *                  Extends GameLogic which is a parent class for any game because they all have specific game rules to guide the game
 */

import java.util.ArrayList;

public class GreedGameLogic extends GameLogic {

    private ArrayList <Integer> possible; //array to hold all possible moves

    private final int OFFSET = 48; //used to convert from char to int based on ASCII values

    public GreedGameLogic(GameBoard gb) {

        super(gb);

        possible = new ArrayList<Integer>();

        //check all directions around the player and add the ones that are possible
      fillMoves(gb.getPlayer().getRowPos(), gb.getPlayer().getColPos());
    }

    //print curr score
    public void view() {
      
        System.out.println("Player Score: " +getGameBoard().getPlayer().getScore());
    }

    /**
     * nextState
     * 
     * PURPOSE: It checks the player's input and calls movePlayer from GameBoard which moves the player around the board
     *                  It also fills the array of possible moves with the updated player's position
     * 
     * PARAMETERS: v is a viewable type which is anything that can be printed to console
     * 
     * RETURN: a boolean true if the game has a next state; false otherwise
     */
    public boolean nextState(Viewable v) {

        boolean isNext = true;

        System.out.println("\n\nPossible moves");
        System.out.print(possible + "\t");
        System.out.println("\nEnd of possible moves\n\n");

        //the player's next move
        int choice = getGameBoard().getPlayer().requestMove();

        if(gameOver()) { //game ends

            isNext = false;

        } else { //there are still possible moves

                if(choice == 0) { //player is quitting

                    isNext = false; //Quit the game

                } else if(choice == 5 || !isValidMove(choice)) {

                       System.out.println("Invalid move. Try a different direction.");
                
                } else {

                    getGameBoard().movePlayer(choice); //move the player

                    possible.clear(); //clear the possible moves

                    fillMoves(getGameBoard().getPlayer().getRowPos(), getGameBoard().getPlayer().getColPos()); //fill possible moves
                }
         }

         return isNext;
    }
   

//reset the game logic to it's beginning state. Empty moves array and set score to 0
    public void reset() {

        getGameBoard().getPlayer().setScore(0);

        possible.clear();
    }


    
public ArrayList <Integer> getPossibleMoves() {

        return possible;
    }

    /**
     *PURPOSE: if a move is valid, it it stored in the array so we can check if it contains the choice a player wishes to make
    *          
    *PARAMETERS: takes in the player's choice         
    * RETURNS: True if the move is possible; false otherwise
    */
    public boolean isValidMove(int choice) {

        return possible.contains(choice);
    }


    /**
     * checkUp
     * 
     * PURPOSE: it checks if moving up (8) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */

    private void checkUp(int row, int col) { //DONE

        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) { //check gameBoard type

                board =  ((GreedGameBoard) getGameBoard()).getBoard();

                //if the number up is on the board and not a white space, we can extract the number of moves we will make
                    if(getGameBoard().onBoard(row -1, col) && board[row - 1][col] != ' ') { 

                        int up = (int) board[row-1][col] - OFFSET; //number of moves

                        if(getGameBoard().onBoard(row - up, col)) {  //means the end position is still on the board

                            boolean validMove = true;

                            for(int i = row-1; i >= row - up; i--) {

                                if(board[i][col] == ' ') { //if we encounter a white space, set validMove to false

                                    validMove = false;
                            }
                
                        }

                        if(validMove) { //add to array if validMove is still true

                            possible.add(8);
                        }

                    }
            }
        }

    }

/**
     * checkDown
     * 
     * PURPOSE: it checks if moving down (2) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkDown(int row, int col) {

        char [][] board = null;

                if(getGameBoard() instanceof GreedGameBoard) {

                        board = ((GreedGameBoard) getGameBoard()).getBoard();

                        //if the number down is on the board and not a white space, we can extract the number of moves we will make
                        if(getGameBoard().onBoard(row +1, col) && board[row+1][col] != ' ') {

                            int down = (int) board[row+1][col] -OFFSET; //number of moves

                            if(getGameBoard().onBoard(row + down, col)) {  //means the end position is still on the board

                                boolean validMove = true;
                                
                                    for(int i = row+1; i <= row + down; i++) {

                                        if(board[i][col] == ' ') {//means the end position is still on the board

                                            validMove = false;
                                    }
                                }

                                    if(validMove) { //add to array if validMove is still true

                                        possible.add(2);
                                    }

                            }
                        }
                }
    }
/**
     * checkLeft
     * 
     * PURPOSE: it checks if moving left (4) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkLeft(int row, int col) {
        
        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) {

                board = ((GreedGameBoard) getGameBoard()).getBoard();

                //if the left number is on the board and not a white space, we can extract the number of moves we will make
                if(getGameBoard().onBoard(row, col-1) && board[row][col-1] != ' ') {

                int left = (int) board[row][col - 1] - OFFSET; //number of moves

                    if(getGameBoard().onBoard(row, col - left)) {  //means the end position is still on the board

                            boolean validMove = true;

                            for(int i = col-1; i >= col - left; i --) {

                                if(board[row][i] == ' ') { 

                                    validMove = false;
                                }
                            }

                            if(validMove) {  //add to array if validMove is still true

                            possible.add(4);
                        }

                    }
                }
        }
    }

    /**
     * checkRight
     * 
     * PURPOSE: it checks if moving right (6) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkRight(int row, int col) {
        
        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) {

                board = ((GreedGameBoard) getGameBoard()).getBoard();

                //if the right number is on the board and not a white space, we can extract the number of moves we will make
                if(getGameBoard().onBoard(row, col + 1) && board[row][col+1] != ' ') {

                    int right = (int) board[row][col+1] - OFFSET; //number of moves

                    if(getGameBoard().onBoard(row, col + right)) { //means the end position is still on the board

                        boolean validMove = true;

                        for(int i = col+1; i <= right+ col; i++) {


                            if(board[row][i] == ' ') {

                                validMove = false;
                            }
                        }


                        if(validMove) {//add to array if validMove is still true

                            possible.add(6);
                        }

                    }
            }
        }
    }
    
/**
     * checkUpRight
     * 
     * PURPOSE: it checks if moving up then right (9) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkUpRight(int row, int col) {

        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) {

            board = ((GreedGameBoard) getGameBoard()).getBoard();

                //if the number up and to the right is on the board and not a white space, we can extract the number of moves we will make
                if(getGameBoard().onBoard(row -1, col + 1) && board[row - 1][col+1] != ' ') {

                    int upRight = (int) board[row-1][col+1] - OFFSET; //number of moves

                    if(getGameBoard().onBoard(row-upRight, col+ upRight)) { //means the end position is still on the board

                                boolean validMove = true;
                                int j = col+1;

                                for(int i = row-1; i >= row - upRight; i --) {

                                    if(board[i][j] == ' ') {

                                        validMove = false;
                                    }
                                            j++;
                                }

                                if(validMove) { //add to array if validMove is still true

                                possible.add(9);
                                }
                    }
                }
       }
    }

    /**
     * checkUpLeft
     * 
     * PURPOSE: it checks if moving up then left (7) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkUpLeft(int row, int col) {
        
        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) {

                    board = ((GreedGameBoard) getGameBoard()).getBoard();

                //if the number up and to the left is on the board and not a white space, we can extract the number of moves we will make
                if(getGameBoard().onBoard(row -1, col - 1) && board[row-1][col-1] != ' ') {

                        int upLeft = (int) board[row-1][col-1] - OFFSET;//number of moves

                        if(getGameBoard().onBoard(row-upLeft, col-upLeft)) { //means the end position is still on the board

                                boolean validMove = true;
                                int j = col - 1;

                                for(int i = row-1; i >= row - upLeft; i--) {

                                    if(board[i][j] == ' ') {

                                        validMove = false;

                                    }

                                            j--;
                                }

                                if(validMove) { //add to array if validMove is still true

                                possible.add(7);
                                 }
                        }
            }
        }
    }

    /**
     * checkDownRight
     * 
     * PURPOSE: it checks if moving down then right (3) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkDownRight(int row, int col) {
        
        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) {

            board = ((GreedGameBoard) getGameBoard()).getBoard();

                //if the number down and to the right is on the board and not a white space, we can extract the number of moves we will make
                if(getGameBoard().onBoard(row +1, col+1)&& board[row+1][col+1] != ' ') {

                int downRight = (int) board[row+1][col+1] - OFFSET;//number of moves

                if(getGameBoard().onBoard(row + downRight, col + downRight)) { //means the end position is still on the board

                    boolean validMove = true;
                    int j = col + 1;

                    for(int i = row+1; i <= downRight + row; i++) {
        
                        if(board[i][j] == ' ') {

                            validMove = false;
                        }
                                j++;

                    }
        
                    if(validMove) { //add to array if validMove is still true
        
                        possible.add(3);
                     }

                }
            }
        }
    }

    /**
     * checkDownLeft
     * 
     * PURPOSE: it checks if moving down then left (1) is valid or not. Valid means the end position after moving is within the game board 
     *                  and there is no white space between the player's start and end position
     * 
     * PARAMETERS: row and column which represents the player's position
     * 
     */
    private void checkDownLeft(int row, int col) {
        
        char [][] board = null;

        if(getGameBoard() instanceof GreedGameBoard) {

                board = ((GreedGameBoard) getGameBoard()).getBoard();

                //if the number down and to the left is on the board and not a white space, we can extract the number of moves we will make
                if(getGameBoard().onBoard(row +1, col-1) && board[row+1][col-1] != ' ') {

                    int downLeft = (int) board[row+1][col-1] - OFFSET; //number of moves

                    if(getGameBoard().onBoard(row+downLeft, col- downLeft)) { //means the end position is still on the board

                        boolean validMove = true;
                        int j = col - 1;

                        for(int i = row + 1; i <= downLeft + row; i++) {
            
                            if(board[i][j] == ' ') {

                                validMove = false;
                            }

                                    j--;
                        }
            
                        if(validMove) { //add to array if validMove is still true
            
                        possible.add(1);
                    }

                    }
            }
         }
    }

/**
 * fillMoves
 * 
 * PURPOSE: calls all the check direction functions so we can fill the possible moves array
 * 
 * PARAMETERS: row, col is the player's current position
 * 
 */
    private void fillMoves(int row, int col) {

        //input will be player's position
             
                    //row--, col-- for down left (1)
                    checkDownLeft(row, col);

                    //row--, col for down (2)
                    checkDown(row, col);

                    //row--, col++ for down right (3)
                    checkDownRight(row, col);

                    //row, col-- for left (4)
                    checkLeft(row, col);

                    //row, col++ for right (6)
                    checkRight(row, col);

                    //row++, col-- for up left (7)
                   checkUpLeft(row, col);

                    //row++, col for up (8)
                    checkUp(row, col);

                    //row++, col++ for up right (9)
                    checkUpRight(row, col);

    }

    /**
     * gameOver
     * 
     * PURPOSE: it checks if our array of possible moves is empty to declare a game over state 
     * 
     * RETURNS: true if moves array is empty; false otherwise
     */
    private boolean gameOver() {

        return possible.isEmpty();
    }
}