public class Square{
	boolean isBomb;
	int bombNum; //number of bombs touching tile
	int num; //number of that individual square
	
	public Square(boolean a, int b, int c){ //constructor
		isBomb = a;
		bombNum = b;
		num = c;
	}
	
	public boolean bombCheck(Object obj){ //accessor to see if square is a bomb
		return isBomb;
		//what's the difference between doing object.bombCheck() vs bombCheck(object)??????
	}
	
	public void setBombNum(){ //bombNum modifier
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				if(bombCheck(Board.sqrGrid[x-1][y-1]) == true){ //top left corner
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x][y-1]) == true){ //on top
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x+1][y-1]) == true){ //top right corner
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x-1][y]) == true){ //left
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x+1][y]) == true){ //right
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x-1][y+1]) == true){ //bottom left corner
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x][y+1]) == true){ //on bottom
					bombNum++;
				}
				if(bombCheck(Board.sqrGrid[x+1][y+1]) == true){ //bottom right corner
					bombNum++;
				}
			}
		}
	}
	
	public boolean makeBomb(){ //modifier that makes isBomb true
		return isBomb = true;
	}
	
	@Override //to look at actually values of the squares/debug
	public String toString(){
		return "(isBomb = " + isBomb + "; bombNum = " + bombNum + "; num = " + num +")";
	}
}
