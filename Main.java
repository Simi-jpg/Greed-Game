/**
 * NAME: SIMI ADENIYI
 * STUDENT NUMBER: 7964063
 * COURSE: COMP 2150
 * INSTRUCTOR: PROF HEATHER MATTHESON
 * ASSIGNMENT: 3 (Greed Game)
 * QUESTION: STAGES 0 - 3
 * 
 * 
 * REMARKS: This is the main class for the Greed Game. It creates the menu, player, game board, game logic, and game objects, and then runs the game.
 */


public class Main {
    public static void main(String[] args) {
        
      //Create all required class instances needed for the game to run
        Menu m = new Menu();

        Player player = new HumanPlayer();

        GameBoard board = new GreedGameBoard(player);

        GameLogic logic = new GreedGameLogic(board);

        Game game = new GreedGame(logic, board, m);

        game.run(); //run the game
    }
}
