/**
 * CLASS: GameLogic.java
 * 
 * AUTHOR: Adeniyi Simi

 REMARKS: This class is the abstract class for any game with a game logic. It implements the GameLogical interface. which all gametypes will inherit to implement
                    their logic.
 */


public abstract class GameLogic implements GameLogical {

    private GameBoard gameBoard;

    public GameLogic(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
    /**
     * Inherits nextState(), reset() and view() from GameLogical interface.
     * 
     * a game logic should process each player input and return the next state of the game.
     * reset should put the game to its initial state
     * view prints the game state to the console.
     */
}
