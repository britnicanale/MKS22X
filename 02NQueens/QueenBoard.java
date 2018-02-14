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
    private boolean addQueen(int r, int c){
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
    
    private boolean removeQueen(int r, int c){
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
	for (int i = 0; i < board.length; i++) {
	    for (int j =0; j < board[i].length;j++) {
		if (board[i][j] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelp(0);
    }
    private boolean solveHelp(int col){
	if( col == board.length){
	    return true;
	}
	for(int r = 0; r < board.length; r++){
	    if(addQueen(r, col)){

		if(solveHelp(col+1)){

		    return true;
		}
		removeQueen(r, col);
	    }
	}

	return false;
    }

    public int countSolutions(){
	for (int i = 0; i < board.length; i++) {
            for (int j =0; j < board[i].length;j++) {
                if (board[i][j] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
	return countHelp(0);
    }
    private int countHelp(int col){
	int numSols = 0;
	if( col == board.length){
            return 1;
        }
        for(int r = 0; r < board.length; r++){
            if(addQueen(r, col)){
		numSols+= countHelp(col + 1);
                removeQueen(r, col);
            }
        }
        return numSols;

    }

    public static void main(String[] args){
	QueenBoard q = new QueenBoard(8);
	System.out.println(q.countSolutions());
	q.solve();
	System.out.println(q);
	QueenBoard r = new QueenBoard(15);
	System.out.println(r.countSolutions());
	r.solve();
        System.out.println(r);
	QueenBoard w = new QueenBoard(3);
	System.out.println(w.countSolutions());
	w.solve();
        System.out.println(w);
	QueenBoard a = new QueenBoard(25);
	System.out.println(a.countSolutions());
	a.solve();
        System.out.println(a);
    }
}