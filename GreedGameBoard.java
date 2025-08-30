/**
 * CLASS: GreedGameBoard
 * 
 *AUTHOR: Adeniyi Simi
 * 
 * REMARKS: This class is a child class of the GameBoard class. It is responsible for creating the board for this specific greed game type
 */

import java.util.Random;

public class GreedGameBoard extends GameBoard{

    //the game board variable
    private char[][] board;
    private final int OFFSET = 48; //used to convert from char to int based on ASCII values


    public GreedGameBoard( Player p ) {

        super(p);
    }

    /**
     * view
     * 
     * PURPOSE: prints out the content of the current game board's state
     */
    public void view() {
     
        for(int i = 0; i < getRows(); i++) {

            for (int j = 0; j < getColumn(); j++) {

                System.out.printf("%2c", board[i][j]);
            }

            System.out.println(); //new line after each column
        }

    }

    /**
     * nextState
     * 
     * PURPOSE: determines the next state of the board
     * 
     * PARAMETER: v is a Viewable object that is passed in to determine the next state of the board.
     * RETURN: true if there is a change in the board state. False if there is no change in the board state.
     */


    /**
     * initializeBoard
     * 
     * PURPOSE: initializes the board for the game by filling it with random numbers from 1 - 9 inclusive
     */

    public void initializeBoard() {
      
        
        int rows = getRows();
        int column = getColumn();

        board = new char[rows][column]; //initialize the board array with the given rows and columns

         Random randNum = new Random();

        for(int i = 0; i < rows; i++) {

            for (int j = 0; j < column; j++) {

                board[i][j] = (char) ('1' + randNum.nextInt(9)); //fill with random numbers from 1-9
            }
        }

       
        board[rows/2][column/2] = '@'; //set the middle of the board to '@' for the player's start position

        getPlayer().setPosition(rows/2, column/2); //set the player's position to the middle of the board
    }
    
    /**
         * clear
         * 
         * PURPOSE: clears the board by setting all cells to "."
         */
        public void clear() {
    
            for (int i = 0; i < getRows(); i++) {  
    
                for (int j = 0; j < getColumn(); j++) {
    
                    board[i][j] = '.'; 
                }
            }
            
        }

        /**
         * movePlayer
         * 
         * PURPOSE: This is responsible for moving the player token around the board
         * 
         * PARAMETERS: takes in the int choice which is the direction a player wants to move (or 0 to quit)
         */
    public void movePlayer(int choice) {

        //get the player's position
        int currPlayerRow = this.getPlayer().getRowPos();
        int currPlayerCol = this.getPlayer().getColPos();

        //number of steps we move depending on the direction
        int numSteps = 0;

        //the game board
        char[][]  board = getBoard();

            
        if(choice == 1) { // down left direction

            //goind down left means row increases and column decreases


            //the number of steps is one index down, one index to the left. Subtract OFFSET to get the integer value
            numSteps = (int) board[currPlayerRow+1][currPlayerCol-1] - OFFSET;

            int j = currPlayerCol; 

            //loop through the row and go to the left each step
            for(int i = currPlayerRow; i < currPlayerRow + numSteps; i++) {
                  
                    board[i][j] =  ' '; //replace with space

                     j--;

            }

            this.getPlayer().setPosition(currPlayerRow + numSteps, currPlayerCol - numSteps); //update the player's position

            } else if(choice == 2) { //down

                //going down means we increase the row

            //the number of steps is one index down. Subtract OFFSET to get the integer value
            numSteps = (int) board[currPlayerRow + 1][currPlayerCol] - OFFSET;
         
                for(int i = currPlayerRow; i < currPlayerRow + numSteps ; i++) {
            
                    board[i][currPlayerCol] =  ' ';
                    
                }

            this.getPlayer().setPosition(currPlayerRow + numSteps, currPlayerCol); //update the player's position



            } else if(choice == 3) { //down right

            //going down right means row increase, column increases. 

            //the number of steps is one index down, one index to the left. Subtract OFFSET to get the integer value
            numSteps = (int) board[currPlayerRow+1][currPlayerCol+1] - OFFSET;

                int j = currPlayerCol;

                //loop through the row and go right with each step
                for(int i = currPlayerRow; i < currPlayerRow + numSteps; i++) {

                    board[i][j] = ' ';
                    j++;

                }

                this.getPlayer().setPosition(currPlayerRow + numSteps, currPlayerCol + numSteps); //update the player's position

            } else if(choice == 4) { //left

                //going left means the column decreases
                
                //the number of steps is one index to the left. Subtract OFFSET to get the integer value
                numSteps = (int) board[currPlayerRow][currPlayerCol-1] - OFFSET;

                for(int i = currPlayerCol ; i >= currPlayerCol - numSteps; i --) {

                    board[currPlayerRow][i] = ' ';
                }


                this.getPlayer().setPosition(currPlayerRow, currPlayerCol - numSteps); //update player's position

            } else if(choice == 6) { //right

                //going right means column increases

                //the number of steps is one index to the right. Subtract OFFSET to get the integer value
                numSteps = (int) board[currPlayerRow][currPlayerCol+1] - OFFSET;

                for(int i = currPlayerCol; i < currPlayerCol + numSteps; i++) {

                    board[currPlayerRow][i] = ' ';
                }

                this.getPlayer().setPosition(currPlayerRow, currPlayerCol + numSteps); //update the player's position
                
            } else if(choice == 7) { //up left

                //going up left means row decreases and column decrease

                //the number of steps is one index up, and one index to the left. Subtract OFFSET to get the integer value
                numSteps = (int) board[currPlayerRow-1][currPlayerCol-1] - OFFSET;

                int j = currPlayerCol;

                //loop through the row and go left with each step
                for(int i = currPlayerRow; i >= currPlayerRow - numSteps; i --) {

                    
                    board[i][j] = ' ';

                    j--;
                }

                this.getPlayer().setPosition(currPlayerRow - numSteps, currPlayerCol - numSteps); //update the player's position
                
            } else if(choice == 8) { //up

                //going up means row decreases

                //the number of steps is one index up. Subtract OFFSET to get the integer value
                numSteps = (int) board[currPlayerRow - 1][currPlayerCol] - OFFSET;
         
                for(int i = currPlayerRow; i >= currPlayerRow - numSteps ; i--) {
            
                    board[i][currPlayerCol] =  ' ';
                    
                }

            this.getPlayer().setPosition(currPlayerRow - numSteps, currPlayerCol); //update the player's position
        
            } else if(choice == 9) { //up right

                //going up right means row decreases, and column increase

                //the number of steps is one index up, and one index to the right. Subtract OFFSET to get the integer value
                numSteps = (int) board[currPlayerRow - 1][currPlayerCol + 1] - OFFSET;

                int j = currPlayerCol;

                //loop through the row and go left with each step
                for(int i = currPlayerRow; i >= currPlayerRow - numSteps; i --) {

                    board[i][j] = ' ';

                    j++;
                }

                this.getPlayer().setPosition(currPlayerRow - numSteps, currPlayerCol + numSteps); //update the player's position
                
            }


        //update the at sign to represent where the player is currently
        board[this.getPlayer().getRowPos()][this.getPlayer().getColPos()] = '@';

        //update the score
        int newScore =  this.getPlayer().getScore() + numSteps ;

        //set the player's score
        this.getPlayer().setScore(newScore);
    }

    
  
    //SETTERS AND GETTERS

    public void setCharAt(int r, int c, char tok) {
     
        board[r][c] = tok;
    }

    public char getCharAt(int r, int c) {

        return board[r][c];
     }

     public char[][] getBoard() {

        return board;
    }
    
}
