import java.util.Scanner;

public class minesweeperMain {
	public static void main(String[] args){
		int bombsFlagged = 0;
		int col = 0;
		int row = 0;
		boolean end1 = false;
		boolean end2 = false;
		boolean bombClicked = false;
		String choice = "";
		Board.fillBoard();
		
		
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				Board.sqrGrid[x][y].setBombNum(x, y); //puts bombs on board
			}
		}
		
		/*for(int rows = 0; rows < 9; rows++){
			for(int columns = 0; columns < 9; columns++){
				System.out.println(Board.sqrGrid[rows][columns]);
			}
		}*/
		
		
		Board flat = new Board();
		flat.test(); //shows the board with all the bombs and numbers
		System.out.print("\n");
		
		Scanner kbReader = new Scanner(System.in);
		System.out.println("Welcome to Minesweeper. Enter coordinates to check for bombs.");
		//System.out.println(bombsFlagged);
		//System.out.println(Board.numberOfBombs);
		
		for(int rows = 0; rows < Board.grid.length; rows++){
			System.out.println(" ");
			for(int columns = 0; columns < Board.grid[0].length; columns++){
				System.out.print(Board.grid[rows][columns] +" ");
			}
		}
		
		while(bombsFlagged < Board.numberOfBombs && bombClicked == false){
			String input = "";
			while(true){
				System.out.println("\nAwaiting an x-coordinate.");
				input = kbReader.next();
				if(input.matches("[a-zA-Z]")){
					System.out.println("Enter a number.");
				}
				else{
					if(Integer.parseInt(input) > 9 || Integer.parseInt(input) < 1){
						System.out.println("Enter a number 1-9.");
					}
					else{
						col = Integer.parseInt(input);
						end1 = true;
					}
				}
				if(end1 == true){
					break;
				}
			}
			while(true){
				
				System.out.println("Awaiting a y-coordinate.");
				input = kbReader.next();
				if(input.matches("[a-zA-Z]")){
					System.out.println("Enter a number.");
				}
				else{
					if(Integer.parseInt(input) > 9 || Integer.parseInt(input) < 1){
						System.out.println("Enter a number 1-9.");
					}
					else{
						row = Integer.parseInt(input);
						end2 = true;
					}
				//if(col > 9 || col < 1 || row > 9 || col < 1 || Integer.toString(col).matches("a-zA-Z") || Integer.toString(row).matches("a-zA-Z")){
				//if(Integer.toString(col).matches("^1-9") || Integer.toString(row).matches("^1-9")){
				//	System.out.println("Enter a number 1 - 9.");
				//}
				
				//System.out.println(col);
				//System.out.println(row);
				}
				if(end2 == true){
					break;
				}
			}
			
			System.out.println("Do you want to click the board, flag a bomb, or remove a flag? \n" +
					"Click: 'c'\n" +
					"Flag: 'f'\n" +
					"Unflag: 'u'");
			choice = kbReader.next();
			if(choice.equals("c")){
				if(Board.grid[row+1][col+1].equals("F")){
					System.out.println("Unflag the square before you click.");
				}
				else{
					if(flat.checkClick(row, col) == true){
						System.out.println("You lose!");
						Board.grid[row+1][col+1] = "X";
						/*for(int rows = 0; rows < Board.grid.length; rows++){
							System.out.println(" ");
							for(int columns = 0; columns < Board.grid[0].length; columns++){
								System.out.print(Board.grid[rows][columns] +" ");
							}
						}*/
						bombClicked = true;
					}
				}
				flat.pathfind(row, col);
				//flat.printChecked(); //print the array list with all the squares
			}
			else if(choice.equals("f")){
				if(Board.grid[row+1][col+1] == " ")
				{
					Board.grid[row+1][col+1] = "F";
					if(Board.sqrGrid[row-1][col-1].bombCheck() == true){
						bombsFlagged++;
					}
				}
				else{
					System.out.println("You cannot flag a numbered tile.");
				}
			}
			else if(choice.equals("u")){
				if(Board.grid[row+1][col+1] != "F"){
					System.out.println("You can only un-flag a flagged spot.");
				}
				else{
					Board.grid[row+1][col+1] = " ";
					if(Board.sqrGrid[row-1][col-1].bombCheck() == true){
						bombsFlagged--;
					}
				}
			}
			for(int rows = 0; rows < Board.grid.length; rows++){
				System.out.println(" ");
				for(int columns = 0; columns < Board.grid[0].length; columns++){
					System.out.print(Board.grid[rows][columns] +" ");
				}
			}
		}
		System.out.println("\n");
		if(bombsFlagged == Board.numberOfBombs){
			System.out.println("You win!");
		}
	}
	}



