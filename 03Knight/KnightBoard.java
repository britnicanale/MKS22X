public class KnightBoard{
    private int[][] board;
    private int[][] posMoves;
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



    /*private void fillMoves(){
	posMoves = new int[board.length][board[0].length];
	for(int i = 0; i < posMoves.length; i++){
	    for(int j = 0; j < posMoves[0].length; j++){
		posMoves[i][j] = 0;
		if(i - 2 >= 0 && j - 1 >= 0){
		    posMoves[i][j] = posMoves[i][j] + 1;
		}
		if(i - 1 >= 0 && j - 2 >= 0){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
		if(i + 1 < posMoves.length && j - 2 >= 0){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
		if(i + 2 < posMoves.length  &&j - 1 >= 0){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
		if(i + 2 < posMoves.length && j + 1 < posMoves[0].length){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
		if(i + 1 < posMoves.length && j + 2 < posMoves[0].length){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
		if(i - 1 >= 0 && j + 2 < posMoves[0].length){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
		if(i - 2 >= 0 && j + 1 < posMoves[0].length){
                    posMoves[i][j] = posMoves[i][j]+ 1;
		}
	    }
	}
    }
    public boolean solveFast(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0){
            throw new IllegalArgumentException();
        }
	return solveFHelp(startingRow, startingCol, 1);
    }
    private boolean solveFHelp(int row, int col, int level){
	if(level > board.length * board[0].length){
            return true;
        }
        if((row < 0 || row >= board.length)|| (col < 0 || col >= board[0].length)){
            return false;
        }
        if(board[row][col] != 0){
            return false;
        }

	board[row][col] = level;
	changeMoves(row,col);

    }
    private void changeMoves(int row, int col){
	if(i - 2 >= 0 && j - 1 >= 0){
	    posMoves[i][j] = posMoves[i][j] - 1;
	}
	if(i - 1 >= 0 && j - 2 >= 0){
	    posMoves[i][j] = posMoves[i][j] - 1;
	}
	if(i + 1 < posMoves.length && j - 2 >= 0){
	    posMoves[i][j] = posMoves[i][j] - 1;
	}
	if(i + 2 < posMoves.length  &&j - 1 >= 0){
	    posMoves[i][j] = posMoves[i][j]- 1;
	}
	if(i + 2 < posMoves.length && j + 1 < posMoves[0].length){
	    posMoves[i][j] = posMoves[i][j]- 1;
	}
	if(i + 1 < posMoves.length && j + 2 < posMoves[0].length){
	    posMoves[i][j] = posMoves[i][j]- 1;
	}
	if(i - 1 >= 0 && j + 2 < posMoves[0].length){
	    posMoves[i][j] = posMoves[i][j]- 1;
	}
	if(i - 2 >= 0 && j + 1 < posMoves[0].length){
	    posMoves[i][j] = posMoves[i][j]- 1;
	}
	}*/
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
    /*
    public String prntMoves(){
        String str = "";
        for(int i  = 0; i < posMoves.length; i++){
            for(int j  = 0; j < posMoves[i].length; j++){
                if(board[i][j] <  10){
                    str+= " " + posMoves [i][j] + " ";
                }else{
                    str+=  posMoves[i][j] + " ";
                }
            }
            str += "\n";
        }
        return str;
	}*/

    public static void main(String[] args){
	KnightBoard k = new KnightBoard(7, 7);
	//System.out.println(k.countSolutions(0,0));
	k.fillMoves();
	//System.out.println(k.solve(0, 0));
	System.out.println(k.prntMoves());
    }
}