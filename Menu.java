/**
 * CLASS: Menu
 * 
 * AUTHOR: Simi Adeniyi
 * 
 * REMARKS: Displayed at the start of the program and requests input in order to start a game or end (quit)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Menuable{

    //Instance Variables
    private ArrayList<MenuItem>commands; //the possible menu items
    String welcomeMessage; //printed at the beginning of each menu prompt

    public Menu() {

        commands = new ArrayList<MenuItem>();
        addMenuItem();
    }

    /**
     * nextState
     * 
     * PURPOSE: asks th eplayer to pick a menu option which will determine if there is a next state
     * 
     * PARAMETERS: v is a viewable item which is anything we that can be printed. 
     * 
     * RETURNS: a boolean true if there is a next state, false otherwise
     */
    public boolean nextState(Viewable v) {
    
        Scanner sc = new Scanner(System.in);

        boolean isNext = false; //representing the next state 

            System.out.println("Enter your choice:");

                int choice = sc.nextInt(); //the user's option

                while(!(choice >= 1 && choice <=commands.size())) { //user did  not enter 1 or 2

                    System.out.println("Invalid choice, please enter a valid number");
                    
                    view(); //print the menu
                    
                    choice = sc.nextInt();

               }

                isNext = commands.get(choice-1).select(this, this); //either true or false depending on the option chosen

        return isNext;

    }

    //print out the welcome message
    public void reset() {

        System.out.println(welcomeMessage);
    }

    /**
     * view
     * 
     * PURPOSE: prints out the menu
     */
    public void view() {

        for (int i = 0; i < commands.size(); i++) {

            System.out.println("Option " + (i +1) + ": " + commands.get(i).getOption());
        }

    }

    public void setMessage(String message) {

      welcomeMessage = message;
    }

    private void addMenuItem() {

        MenuItem start = new StartMenu("Start Game");
        MenuItem quit = new QuitMenu("Quit");

        commands.add(start);
        commands.add(quit);
        
    }
    
}
