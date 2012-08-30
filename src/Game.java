import java.lang.String;
import java.util.*;


public class Game {
	private ArrayList<Player> players;
	
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
		this.players = new ArrayList<Player>();
		for (int i = 0; i < players; i++)
		{
			this.players.add(new Player());
			System.out.printf("Adding player %X: %s\n", i,this.players.get(i).getName());
		}
	}
	
	public Game()
	{
		this(4);
	}
}
