 public class Square{
	boolean isBomb;
	int bombNum; //number of bombs touching tile
	int num; //number of that individual square
	
	public Square(boolean a, int b, int c){ //constructor
		isBomb = a;
		bombNum = b;
		num = c;
	}
	
	public boolean bombCheck(){ //accessor to see if square is a bomb
		return isBomb;
		//what's the difference between doing object.bombCheck() vs bombCheck(object)??????
	}
	
	public boolean makeBomb(){ //modifier that makes isBomb true
		return isBomb = true;
	}
	
	public void setBombNum(int x, int y){ //bombNum modifier //does weird thing that counts the squares that aren't bombs i think
		
		if((x != 0 && y != 0) && Board.sqrGrid[x-1][y-1].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //top left corner
			Board.sqrGrid[x][y].bombNum++;
		}
		if((y != 0) && Board.sqrGrid[x][y-1].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //on top
			Board.sqrGrid[x][y].bombNum++;
		}
		if((x != 8 && y != 0) && Board.sqrGrid[x+1][y-1].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //top right corner
			Board.sqrGrid[x][y].bombNum++;
		}
		if((x != 0) && Board.sqrGrid[x-1][y].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //left
			Board.sqrGrid[x][y].bombNum++;
		}
		if((x != 8) && Board.sqrGrid[x+1][y].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //right
			Board.sqrGrid[x][y].bombNum++;
		}
		if((x != 0 && y != 8) && Board.sqrGrid[x-1][y+1].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //bottom left corner
			Board.sqrGrid[x][y].bombNum++;
		}
		if((y != 8) && Board.sqrGrid[x][y+1].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //on bottom
			Board.sqrGrid[x][y].bombNum++;
		}
		if((x != 8 && y != 8) && Board.sqrGrid[x+1][y+1].bombCheck() == true && Board.sqrGrid[x][y].bombCheck() == false){ //bottom right corner
			Board.sqrGrid[x][y].bombNum++;
		}
	}
	
	public int getBombNum(){
		return bombNum;
	}
	
	@Override //to look at actually values of the squares/debug
	public String toString(){
		return "(isBomb = " + isBomb + "; bombNum = " + bombNum + "; num = " + num +")";
	}
}
