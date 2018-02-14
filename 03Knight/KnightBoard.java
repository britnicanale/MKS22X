public class KnightBoard{
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
