
/**
 * Write a description of class Crunch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * Code for "fake clearing" the terminal was based on an idea from the thread: http://stackoverflow.com/questions/2979383/java-clear-the-console
 */

import java.util.Scanner;
public class Crunch
{

    public static void playCrunch()
    {
                Scanner k = new Scanner(System.in);
        String response = "y";
        int player1 = 1;
        int player2 = 0;
        do
        {
            System.out.print("Would you like to go first? ");
            response = k.nextLine();
            if (response.equals("y"))
            {
                player1 = 0;
                player2 = 1;
            }
            else 
            {
                player1 = 1;
                player2 = 0;
            }
        } while (!response.equals("y") && !response.equals("n");

        boolean stillPlaying = true;
        while (stillPlaying)
        {
            int turnNum = 0;
            int sticksRemaining = 21;
            while (sticksRemaining > 0)
            {
                turnNum++;
                System.out.println("TURN #" + turnNum + " ===========================================");
                System.out.println("There are " + sticksRemaining + " sticks remaining.");
                System.out.println();
                for (int i = 0; i < sticksRemaining; i++) System.out.print("| ");
                System.out.println();
                System.out.println();
                if (turnNum % 2 == 1)   sticksRemaining -= takeTurn(player1, sticksRemaining);
                else                                    sticksRemaining -= takeTurn(player2, sticksRemaining);
                System.out.println("===================================================");
            }
            if (turnNum % 2 == 1)   System.out.println("Player 2 wins!");
            else                    System.out.println("Player 1 wins!");
            System.out.println("Do you want to play again? (y/n)");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            if (s.equals("y"))      stillPlaying = true;
            else                    stillPlaying = false;
        }
        System.out.print("Goodbye!");
    }

    public static int takeTurn(int player, int sticks)
    {
        if (player == 0)
        {
            int s = 99;
            boolean invalidNumber = true;
            while (invalidNumber)
            {
                System.out.print("\tHow many sticks do you want to take?\t");
                Scanner scan = new Scanner(System.in);
                s = scan.nextInt();
                if (s <= sticks && s < 3 && s > 0)    invalidNumber = false;
            }
            System.out.println();
            return s;
        }
        else
        {
            int s = 0;
            if (sticks < 2) s = 1;
            else  s = 1 + (int)(Math.random() + 0.5);
            System.out.print("\tThe computer takes " + s + " stick");
            if (s == 1) System.out.print(".");
            else        System.out.print("s.");
            System.out.println();
            System.out.println();
            return s;
        }
    }

}
