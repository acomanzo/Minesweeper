import java.util.Scanner;

public class minesweeperMain {
	public static void main(String[] args){
		Board.fillBoard();
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				Board.sqrGrid[x][y].setBombNum(x, y);
			}
		}
		for(int rows = 0; rows < 9; rows++){
			for(int columns = 0; columns < 9; columns++){
				System.out.println(Board.sqrGrid[rows][columns]);
			}
		}
		
		for(int rows = 0; rows < Board.grid.length; rows++){
			System.out.println(" ");
			for(int columns = 0; columns < Board.grid[0].length; columns++){
				System.out.print(Board.grid[rows][columns] +" ");
			}
		}
		
		Board flat = new Board();
		flat.test();
		
		//when doing pathfinding/recursion, have to take out the Squares you've checked already
		System.out.println("\n");
		Scanner kbReader = new Scanner(System.in);
		System.out.println("Welcome to Minesweeper. Enter coordinates to check for bombs.");
		//System.out.println("Do you want to click or place a flag?");
		System.out.println("Awaiting an x-coordinate.");
		int xCoord = kbReader.nextInt() + 1;
		System.out.println("Awaiting a y-coordinate.");
		int yCoord = kbReader.nextInt() + 1;
		
	}
}



