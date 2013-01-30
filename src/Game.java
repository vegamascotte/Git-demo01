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

import java.lang.String;
import java.util.*;


public class Game {
	public static final int EXIT_SUCCESS =  0;
	public static final int EXIT_ERROR   = -1;
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
			System.err.printf("Argument not an integer value\n");
			System.exit(EXIT_ERROR);
		}
		System.exit(EXIT_SUCCESS);
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
				if (p.dist() >= 0)
					winner = p;
			}
		}
		if (winner != null)
			System.out.printf("Player %s has won with a deviation of %d\n", winner.getName(), winner.dist());
		else
			System.out.printf("Nobody has won!\n");
	}
	
	public Game()
	{
		this(4);
	}
}
