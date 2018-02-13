public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	board = new int[size][size];
	for(int i  = 0; i < board.length; i++){
	    for(int j  = 0; j < board[i].length; j++){
		board[i][j] = 0;
	    }
	}
    }
    public boolean addQueen(int r, int c){
	if(board[r][c] != 0){
	    return false;
	}
	board[r][c] = -1;
	for(int j = c + 1; j < board[r].length; j++){
	    board[r][j] += 1;
	}
	for(int i = 1; r + i < board.length && c + i < board.length; i++){
	    board[r+i][c+i] += 1;
	}
	for(int i = 1; r - i >= 0  && c + i < board.length; i++){
            board[r-i][c+i] += 1;
	}
	return true;
    }
    
    public boolean removeQueen(int r, int c){
	if(board[r][c] != -1){
            return false;
        }
        board[r][c] = 0;
        for(int j = c + 1; j < board[r].length; j++){
            board[r][j] -= 1;
        }
        for(int i = 1; r + i < board.length && c + i < board.length; i++){
            board[r+i][c+i] -= 1;
        }
        for(int i = 1; r - i >= 0  && c + i < board.length; i++){
            board[r-i][c+i] -= 1;
        }
        return true;
    }

    

    public String toString(){
	String str = "";
	for(int i  = 0; i < board.length; i++){
            for(int j  = 0; j < board[i].length; j++){
                if(board[i][j] == -1){
		    str += "Q ";
		}else{
		    str+= "_ ";
		}
            }
	    str += "\n";
        }
	return str;
    }
    public boolean solve(){
	return solveHelp(0, 0, 0, true);
}
    private boolean solveHelp(int col, int row, int n, boolean forward){
	if(col== 0 && row == board.length){
	    return false;
	}
	if(col == board.length){
	    return solveHelp(col - 1, 0, n, false);
	}	
	if(n == board.length){
	    return true;
	}
	if(row == board.length){
	    return solveHelp(col - 1, 0, n, false);
	}
	if(!forward){
            while(!removeQueen(row, col)){
                row++;
                if(row == board.length){
                    return solveHelp(col - 1, 0, n, false);
                }
            }
            return solveHelp(col, row + 1, n - 1, true);
        }
	while(!addQueen(row, col)){
            row++;
            if(row == board.length){
                return solveHelp(col - 1, 0, n, false);
            }
        }
        return solveHelp(col + 1, 0, n + 1, true);

    }

    public int countSolutions(){
	return countHelp(0, 0, 0, true, 0);
    }
    private int countHelp(int col, int row, int n, boolean forward, int numSol){
	if(col== 0 && row == board.length){
            return numSol;
        }
        if(n == board.length && col == board.length){
            return countHelp(col - 1, 0, n, false, numSol + 1);

        }
	if(col == board.length){
            return countHelp(col - 1, 0, n, false, numSol);
        }
        if(row == board.length){
            return countHelp(col - 1, 0, n, false, numSol);
        }
        if(!forward){
            while(!removeQueen(row, col)){
		row++;
		if(row == board.length){
		    return countHelp(col - 1, 0, n, false, numSol);
		}
            }
	    return countHelp(col, row + 1, n - 1, true, numSol);
	}
        while(!addQueen(row, col)){
	    row++;
	    if(row == board.length){
		return countHelp(col - 1, 0, n, false, numSol);
	    }
        }
        return countHelp(col + 1, 0, n + 1, true, numSol);
    }

    public static void main(String[] args){
	QueenBoard q = new QueenBoard(8);
	System.out.println(q.countSolutions());
	q.solve();
	System.out.println(q);
	QueenBoard r = new QueenBoard(8);
	System.out.println(r.countSolutions());
	//r.solve();
        System.out.println(r);
	QueenBoard w = new QueenBoard(3);
	System.out.println(w.countSolutions());
	w.solve();
        System.out.println(w);

	QueenBoard a = new QueenBoard(5);
	System.out.println(a.countSolutions());
	a.solve();
        System.out.println(a);
    }
}