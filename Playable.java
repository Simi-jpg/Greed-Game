/**
 * INTERFACE: Playable
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: it is an interface for any playable character of the games. This includes human (console) or a text file with pre determined moves
 */

public interface Playable {

    /**
     * requestMove
     * 
     * PURPOSE: Any playable character has to give in an input for their next move. This method requests
     *                  for the player's next move
     * 
     * RETURN: an int which is the next move
     */
    int requestMove();
}
