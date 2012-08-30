import java.util.Random;


public class Dice {
	int dice_max;
	private Random d;
	
	public Dice(int max)
	{
		d = new Random();
		this.dice_max = max;
	}
	
	public Dice()
	{
		this(6);
	}
	
	public int throwDice()
	{
		return d.nextInt(dice_max)+1;
	}
}
