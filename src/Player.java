import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Player {
	private String name;
	private Dice d;
	private int score;
	private int goal;
	private boolean inGame = true;
	
	public Player()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		d = new Dice();
		
		try {
			System.out.printf("I can haz name?\n");
			this.name = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			this.name = "Frits!";
		}

		System.out.printf("I can haz target?\n");
		try {
			this.goal = Integer.parseInt(in.readLine());
			if (this.goal < 16)
				throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				Random r = new Random();
				this.goal = r.nextInt(20);
				this.goal += 16;
				System.out.printf("Error: setting goal to %d\n", this.goal);
			}
			catch (Exception ee)
			{
				System.err.printf("Something went wrong\n");
				ee.printStackTrace();
				System.exit(-1);
			}
		}
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean finishedGame()
	{
		if (score >= goal)
			return true;
		else
			return false;
	}
	
	public int dist()
	{
		return goal - score;
	}
	
	public void takeTurn()
	{
		if (finishedGame() || !inGame)
			return;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("player: %s\nScore: %d\ntarget: %d\n", name, score, goal);
		System.out.printf("%s, Do you want to throw the dice?(YES/no)\n", name);
		String ans = "";
		try {
			ans = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		if (ans.compareTo("no") == 0)
			inGame = false;
		else
		{
			int diceRoll = d.throwDice();
			score += diceRoll;
			System.out.printf("Dice: %d\n", diceRoll);
			if (score > goal)
				System.out.printf("You're out of the game!\n");
		}
	}
}
