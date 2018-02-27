public class KnightBoard{
    private int[][] board;
    public KnightBoard(int row, int col){

	if(row < 0 || col < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[row][col];
        for(int i  = 0; i < board.length; i++){
            for(int j  = 0; j < board[i].length; j++){
                board[i][j] = 0;
            }
        }
    }
    public boolean solve(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0){
	    throw new IllegalArgumentException();
	}
	return solveHelp(startingRow, startingCol, 1);
    }
 
    private boolean solveHelp(int startingRow, int startingCol, int level){
	if(level > board.length * board[0].length){
	    //board[startingRow][startingCol] = level;
	    return true;
	}
	if((startingRow < 0 || startingRow >= board.length)|| (startingCol < 0 || startingCol >= board[0].length)){
	    return false;
	}
	if(board[startingRow][startingCol] != 0){
	    return false;
	}
	board[startingRow][startingCol] = level;
        boolean isSolved =  (((solveHelp(startingRow - 2, startingCol - 1, level + 1) || solveHelp(startingRow - 1, startingCol - 2, level + 1))||
			      (solveHelp(startingRow + 1, startingCol - 2, level + 1) || solveHelp(startingRow + 2, startingCol - 1, level + 1)))||
			     ((solveHelp(startingRow + 2, startingCol + 1, level + 1) || solveHelp(startingRow + 1, startingCol + 2, level + 1))||
			      (solveHelp(startingRow - 1, startingCol + 2, level + 1) || solveHelp(startingRow - 2, startingCol + 1, level + 1))));
	if(!isSolved){
	    board[startingRow][startingCol]=0;
	}
	return isSolved;
    }
    public int countSolutions(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0){
	    throw new IllegalArgumentException();
	}
	return countHelp(startingRow, startingCol, 1);
    }
    private int countHelp(int startingRow, int startingCol, int level){
	if((startingRow < 0 || startingRow >= board.length)|| (startingCol < 0 || startingCol >= board[0].length)){
            return 0;
        }
        if(board[startingRow][startingCol] != 0){
            return 0;
	}
	if(level == board.length * board[0].length){
            return 1;
        }

	board[startingRow][startingCol] = level;
	int sols =  (((countHelp(startingRow - 2, startingCol - 1, level + 1) + countHelp(startingRow - 1, startingCol - 2, level + 1))+
		      (countHelp(startingRow + 1, startingCol - 2, level + 1) + countHelp(startingRow + 2, startingCol - 1, level + 1)))+
		     ((countHelp(startingRow + 2, startingCol + 1, level + 1) + countHelp(startingRow + 1, startingCol + 2, level + 1))+
		      (countHelp(startingRow - 1, startingCol + 2, level + 1) + countHelp(startingRow - 2, startingCol + 1, level + 1))));
	if(level == 0){
	}
	board[startingRow][startingCol] = 0;
	return sols;
    }



    public String toString(){
	String str = "";
	for(int i  = 0; i < board.length; i++){
            for(int j  = 0; j < board[i].length; j++){
                if(board[i][j] <  10){
		    str+= " " + board [i][j] + " ";
		}else{
		    str+=  board [i][j] + " ";
		}
	    }
	    str += "\n";
	}
	return str;
    }
    public static void main(String[] args){
	KnightBoard k = new KnightBoard(7, 7);
	System.out.println(k.countSolutions(0,0));
	//System.out.println(k.solve(0, 0));
	System.out.println(k);
    }
}