import java.util.ArrayList;
import java.util.Random;

										//FOR MINESWEEPER

public class Board {
	static int r = 0;
	static Random rand = new Random();
	static int row;
	static int col;
	public static int numberOfBombs = 0;

	public static Square[][] sqrGrid = { //sqrGrid = square grid
		{new Square(false, 0, 1), new Square(false, 0, 2), new Square(false, 0, 3), new Square(false, 0, 4), new Square(false, 0, 5), new Square(false, 0, 6), new Square(false, 0, 7), new Square(false, 0, 8), new Square(false, 0, 9),},
		{new Square(false, 0, 10), new Square(false, 0, 11), new Square(false, 0, 12), new Square(false, 0, 13), new Square(false, 0, 14), new Square(false, 0, 15), new Square(false, 0, 16), new Square(false, 0, 17), new Square(false, 0, 18),},
		{new Square(false, 0, 19), new Square(false, 0, 20), new Square(false, 0, 21), new Square(false, 0, 22), new Square(false, 0, 23), new Square(false, 0, 24), new Square(false, 0, 25), new Square(false, 0, 26), new Square(false, 0, 27),},
		{new Square(false, 0, 28), new Square(false, 0, 29), new Square(false, 0, 30), new Square(false, 0, 31), new Square(false, 0, 32), new Square(false, 0, 33), new Square(false, 0, 34), new Square(false, 0, 35), new Square(false, 0, 36),},
		{new Square(false, 0, 37), new Square(false, 0, 38), new Square(false, 0, 39), new Square(false, 0, 40), new Square(false, 0, 41), new Square(false, 0, 42), new Square(false, 0, 43), new Square(false, 0, 44), new Square(false, 0, 45),},
		{new Square(false, 0, 46), new Square(false, 0, 47), new Square(false, 0, 48), new Square(false, 0, 49), new Square(false, 0, 50), new Square(false, 0, 51), new Square(false, 0, 52), new Square(false, 0, 53), new Square(false, 0, 54),},
		{new Square(false, 0, 55), new Square(false, 0, 56), new Square(false, 0, 57), new Square(false, 0, 58), new Square(false, 0, 59), new Square(false, 0, 60), new Square(false, 0, 61), new Square(false, 0, 62), new Square(false, 0, 63),},
		{new Square(false, 0, 64), new Square(false, 0, 65), new Square(false, 0, 66), new Square(false, 0, 67), new Square(false, 0, 68), new Square(false, 0, 69), new Square(false, 0, 70), new Square(false, 0, 71), new Square(false, 0, 72),},
		{new Square(false, 0, 73), new Square(false, 0, 74), new Square(false, 0, 75), new Square(false, 0, 76), new Square(false, 0, 77), new Square(false, 0, 78), new Square(false, 0, 79), new Square(false, 0, 80), new Square(false, 0, 81),},
	};
	
	public static String[][] grid = { //char grid that represents the 2D array of squares
			{" ", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ",},
			{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
			{"1", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"2", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"3", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"4", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"5", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"6", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"7", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"8", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"9", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
	};
	
	public static String[][] testGrid = { //char grid that represents the 2D array of squares
		{" ", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ",},
		{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
		{"1", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"2", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"3", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"4", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"5", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"6", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"7", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"8", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"9", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
};
	
	public static ArrayList<Square> checked = new ArrayList<Square>();//used to put squares that have been checked
	
	public static void fillBoard()//puts down bombs
	{
		for(int i = 0; i < 10; i++)
		{
			row = rand.nextInt(9);
			col = rand.nextInt(9);
			sqrGrid[row][col].makeBomb();
		}
		for(int rows = 0; rows < sqrGrid.length; rows++){
			for(int cols = 0; cols < sqrGrid[0].length; cols++){
				if(sqrGrid[rows][cols].bombCheck() == true){
					numberOfBombs++;
				}
			}
		}
	}
	
	public void test(){//testing to make sure pathfinding works. This is so I can look at the Squares not near bombs
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				if(sqrGrid[x][y].bombCheck() == true){
					testGrid[x+2][y+2] = "X";
				}
			}
		}
		for(int x = 2; x < 11; x++){
			for(int y = 2; y < 11; y++){
				if(sqrGrid[x-2][y-2].bombCheck() == false){
					testGrid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				}
				
			}
		}
		for(int rows = 0; rows < Board.testGrid.length; rows++){
			System.out.println(" ");
			for(int columns = 0; columns < Board.testGrid[0].length; columns++){
				System.out.print(Board.testGrid[rows][columns] +" ");
			}
		}
	}
	
	
	public static void pathfind(int row, int col){ //to find Squares next to bombs. row-1 and col-1 are to make up the offset (same for row+1 and col+1)
		
		//to fix the problem of there being holes in the recursion, I had to get rid of .bombCheck() == false in the bottom else because the square that is going to be checked is 
		//put into checked before the recursion is done on it, so if it's the last square and all the squares around it are checked, and it itself is in checked,
		//it won't meet any of the conditions, and therefore won't appear on the grid
		
		if(sqrGrid[row-1][col-1].bombCheck() == false && sqrGrid[row-1][col-1].getBombNum() == 0){
			if((col < 10 && col > 1 && row < 10 && row > 0) && (checked.contains(sqrGrid[row-1][col-2]) == false) && !(grid[row+1][col+1].equals("F"))){//square directly left
				checked.add(sqrGrid[row-1][col-2]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row, col-1);//must be relative to the parameter intake
			}
			if((col < 10 && col > 1 && row < 9 && row > 0) && (checked.contains(sqrGrid[row][col-2]) == false) && !(grid[row+1][col+1].equals("F"))){//diagonally down left
				checked.add(sqrGrid[row][col-2]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row+1, col-1);
			}
			if((col < 10 && col > 0 && row < 9 && row > 0) && (checked.contains(sqrGrid[row][col-1]) == false) && !(grid[row+1][col+1].equals("F"))){//directly down
				checked.add(sqrGrid[row][col-1]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row+1, col);
			}
			if((col < 9 && col > 0 && row < 9 && row > 0) && (checked.contains(sqrGrid[row][col]) == false) && !(grid[row+1][col+1].equals("F"))){//diagonally down right
				checked.add(sqrGrid[row][col]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row+1, col+1);
				
			}
			if((col < 9 && col > 0 && row < 10 && row > 0) && (checked.contains(sqrGrid[row-1][col]) == false) && !(grid[row+1][col+1].equals("F"))){//directly right
				checked.add(sqrGrid[row-1][col]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row, col+1);
					
			}
			if((col < 9 && col > 0 && row < 10 && row > 1) && (checked.contains(sqrGrid[row-2][col]) == false) && !(grid[row+1][col+1].equals("F"))){//diagonally up right
				checked.add(sqrGrid[row-2][col]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row-1, col+1);
				
			}
			if((col < 10 && col > 0 && row < 10 && row > 1) && (checked.contains(sqrGrid[row-2][col-1]) == false) && !(grid[row+1][col+1].equals("F"))){//directly up
				checked.add(sqrGrid[row-2][col-1]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row-1, col);
				
			}
			if((col < 10 && col > 1 && row < 10 && row > 1) && (checked.contains(sqrGrid[row-2][col-2]) == false) && !(grid[row+1][col+1].equals("F"))){//diagonally up left
				checked.add(sqrGrid[row-2][col-2]);
				grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
				pathfind(row-1, col-1);
					
			}
			else{
				if((col < 10 && col > 0 && row < 10 && row > 0) && !(grid[row+1][col+1].equals("F"))){
					checked.add(sqrGrid[row-1][col-1]);
					grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
					}
				}
			}
		else if(sqrGrid[row-1][col-1].bombCheck() == false && sqrGrid[row-1][col-1].getBombNum() > 0 && !(grid[row+1][col+1].equals("F"))){
			grid[row+1][col+1] = Integer.toString(sqrGrid[row-1][col-1].getBombNum());
		}
	}

	
	void printChecked(){
		for(int i = 0; i < checked.size(); i++){//temporary
			System.out.println(checked.get(i));
		}
	}
	
	boolean checkClick(int row, int col){//checks to see if a click input was a bomb
		if((col < 10 && col > 0 && row < 10 && row > 0) && sqrGrid[row-1][col-1].isBomb == true){
			return true; // means you've lost
		}
		else{
			return false; 
		}
	}
}



