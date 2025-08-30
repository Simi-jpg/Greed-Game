/**
 * NAME: SIMI ADENIYI
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
