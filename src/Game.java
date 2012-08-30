import java.lang.String;
import java.util.*;


public class Game {
	private ArrayList<Player> players;
	int turns = 6;
	
	public static void main(String argv[])
	{
		try 
		{
			int i = Integer.parseInt(argv[0]);
			new Game(i);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.printf("Couldn't parse arg[1]\n");
			new Game(4);	
		}
	}
	
	public Game(int players)
	{
		System.err.println("BUG!");
		this.players = new ArrayList<Player>();
		for (int i = 0; i < players; i++)
		{
			this.players.add(new Player());
			System.out.printf("Adding player %X: %s\n", i,this.players.get(i).getName());
		}
		
		for (int i = 0; i < turns; i++)
		{
			for (Player p : this.players)
			{
				p.takeTurn();
			}
		}
		Player winner = null;
		for (Player p : this.players)
		{
			try{
				if (winner.dist() > p.dist() && winner.dist() >= 0)
					winner = p;
			}
			catch (Exception e)
			{
				winner = p;
			}
		}
		System.out.printf("Player %s has won with a deviation of %d\n", winner.getName(), winner.dist());
		
	}
	
	public Game()
	{
		this(4);
	}
}
