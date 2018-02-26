
public class minesweeperMain {
	public static void main(String[] args){
		Board.fillBoard();
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
	}
}
