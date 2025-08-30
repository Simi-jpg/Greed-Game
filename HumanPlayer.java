/**
 * CLASS: HumanPlayer
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: Defines the type of game piece or player, human, who makes moves using the console. It is a subclass of GamePiece.
 */


import java.util.Scanner;

public class HumanPlayer extends Player{

    //Instance Variables

    private Scanner scanner; //collects input from the console

    public HumanPlayer() {

        super();

        scanner = new Scanner(System.in);
    } 

     /**
     * requestMove
     * 
     * PURPOSE: This method collects a player's next choice. It reads in user input through the console
     * 
     * RETURNS: The player's next move (int)
     */
    public int requestMove() {
        
        System.out.println("Enter move option (0 to go back to menu): ");

        while(!scanner.hasNextInt()) { //keep asking for input if the player does not give an integer type
            
            System.out.println("Invalid input. Please enter a valid move.");

            scanner.next();
        }

        return scanner.nextInt(); //return the next move
    }

  

}
