public int takeTurn(int player, int sticks)
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
