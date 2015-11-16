public static void playCrunch()
{
	//Ask if player wants to go first
	int player1 = 0;
	int player2 = 1;
	boolean stillPlaying = true;
	while (stillPlaying)
	{
		int turnNum = 0;
		int sticksRemaining = 21;
		while (sticksRemaining > 0)
		{
			turnNum++;
			if (turnNum % 2 == 1)	sticksRemaining -= takeTurn(player1, sticksRemaining);
			else									sticksRemaining -= takeTurn(player2, sticksRemaining);
		}
		if (turnNum % 2 == 1)	System.out.print("Player 2 wins!");
		else									System.out.print("Player 1 wins!");
		System.out.print("Do you want to play again? (y/n)");
  	Scanner scan = new Scanner(System.in);
  	c = scan.nextChar();
		if (c == 'y')	stillPlaying = true;
		else					stillPlaying = false;
	}
}

public static int takeTurn(int player, int sticks)
{
	if (player == 0)
	{
	  int s = 99;
	  while (s > sticks)
	  {
  	  System.out.println("How many sticks do you want to take?");
  	  Scanner scan = new Scanner(System.in);
  	  s = scan.nextInt();
	  }
	  return s;
	}
	else
	{
	    if (sticks < 2) return 1;
	    else  return 1 + (int)(Math.random() + 0.5);
	}
}
