# Minesweeper
Minesweeper game for AP CompSci

public class Square{
	boolean isBomb;
	int bombNum; //number of bombs touching tile
	int num; //number of that individual square
	
	public Square(boolean a, int b, int c){
		isBomb = a;
		bombNum = b;
		num = c;
	}
	
	@Override //overrides .equals()
	public boolean equals(Object obj){
	
	}
	
	@Override //overrides hashCode
	public int hashCode(){
	
	}
	
	public void setBombNum(){ //sets square that aren't bombs
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				if(Board.grid[x-1][y-1].equals((true, 0, 0))){
					bombNum++;
				}
			}
		}
	}
}
