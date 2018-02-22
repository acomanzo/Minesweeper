import java.util.ArrayList;
import java.util.Random;

										//FOR MINESWEEPER

public class Board {
	int r = 0;
	Random rand = new Random();
	int x;
	int y;
	//public ArrayList<Square> grid = new ArrayList<Square>();
	//public static Square[][] grid = new Square[9][9];//perhaps i need to specify each sqaure for constructor to work
	public static Square[][] grid = {
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
		{new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0), new Square(false, 0, 0),},
	};
	public void fillBoard()//puts down bombs
	{
		for(int i = 0; i < 10; i++)
		{
			x = rand.nextInt(9)+1;
			y = rand.nextInt(9)+1;
			grid[x][y] = new Square(true,0,0);//need to find way to set the individual square number
												//maybe set it in array?
		}
	}
}

