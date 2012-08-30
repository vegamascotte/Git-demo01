import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Player {
	private String name;
	private int score;
	private int goal;
	
	public Player()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
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
	
	public boolean wonGame()
	{
		if (score == goal)
			return true;
		else
			return false;
	}
}
