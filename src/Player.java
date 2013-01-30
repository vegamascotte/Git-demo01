/*
 *  Git-demo01
 *  Copyright (C) 2013  Bart Kuivenhoven
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
				System.exit(Game.EXIT_ERROR);
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
			System.exit(Game.EXIT_ERROR);
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
