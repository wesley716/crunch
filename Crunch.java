/**
 * Game of Crunch
 * 
 * @author Wesley Kuo & Amrit Rau (Period 4) 
 * @version 20 November 2015
 */

import java.util.Scanner;
public class Crunch
{

    public static void playCrunch(int numberOfSticks, int minSticks, int maxSticks)
    {
        int player1 = 0;
        int player2 = 1;
        if (!getYesNoResponse("Do you want to go first? (y/n)\t"))
        {
            player1 = 1;
            player2 = 0;
        }

        boolean stillPlaying = true;
        do
        {
            int turnNum = 0;
            int sticksRemaining = numberOfSticks;
            while (sticksRemaining > 0)
            {
                turnNum++;
                System.out.println("TURN #" + turnNum + " ===========================================");
                System.out.println("There are " + sticksRemaining + " sticks remaining.");
                System.out.println();
                for (int i = 0; i < sticksRemaining; i++) System.out.print("| ");
                System.out.println();
                System.out.println();
                if (turnNum % 2 == 1)   sticksRemaining -= takeTurn(player1, sticksRemaining, minSticks, maxSticks);
                else                                    sticksRemaining -= takeTurn(player2, sticksRemaining, minSticks, maxSticks);
                System.out.println("===================================================");
            }
            if (turnNum % 2 == 1)   System.out.println("Player 2 wins!");
            else                    System.out.println("Player 1 wins!");

        } while (getYesNoResponse("Do you want to play again? (y/n) \t"));
        System.out.print("Goodbye!");
    }

    public static int takeTurn(int player, int sticks, int minSticks, int maxSticks)
    {
        if (player == 0)
        {
            return getIntResponse(minSticks, Math.min(maxSticks, sticks));
        }
        else
        {
            int s = 0;
            if (sticks < maxSticks) s = minSticks;
            else  s = minSticks + (int)(Math.random() * ((maxSticks - minSticks) + 1));
            System.out.print("\tThe computer takes " + s + " stick");
            if (s == 1) System.out.print(".");
            else        System.out.print("s.");
            System.out.println();
            System.out.println();
            return s;
        }
    }

    public static boolean getYesNoResponse(String prompt)
    {
        boolean waiting = true;
        do
        {
            System.out.print (prompt);
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            if (s.equals("y"))      return true;
            else if (s.equals("n")) return false;
            else                    waiting = true;
        } while(waiting);
        return false;
    }

    public static int getIntResponse(int min, int max)
    {
        boolean invalidNumber = true;
        int response = 0;
        do 
        {
            System.out.print("\tHow many sticks do you want to take?\t");
            Scanner scan = new Scanner(System.in);
            try
            {
                response = scan.nextInt();
                if (response <= max && response >= min)    invalidNumber = false;
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
                invalidNumber = true;
            }

        } while (invalidNumber);
        System.out.println();
        return response;
    }

}
