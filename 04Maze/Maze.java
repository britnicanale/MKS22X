import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;
    
    public Maze(String filename) throws FileNotFoundException{
	int numE = 0;
	int numS = 0;
   
	File f = new File(filename);
	Scanner in = new Scanner(f);
	int numRows = 0;
	int numCols = 0;
	while(in.hasNextLine()){
	    numRows++;
	    in.nextLine();
	}
	Scanner l = new Scanner(f);
	String s = l.nextLine();
	for(int i = 0; i < s.length(); i++){
	    numCols++;
	}
	Scanner m = new Scanner(f);
	maze = new char[numRows][numCols];
	for(int j = 0; m.hasNextLine(); j++){
	    String line = m.nextLine(); 
	    for(int i = 0; i < line.length(); i++){
		if(line.charAt(i) == 'S'){
		    numS ++;
		}
		if(line.charAt(i) == 'E'){
		    numE ++;
		}
		maze[j][i] = line.charAt(i);
	    }
	}
	if(numS != 1 || numE != 1){
	    throw new IllegalStateException();
	}
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

   
    public int solve(){
	for(int i  = 0; i < maze.length; i++){
            for(int j  = 0; j < maze[i].length; j++){
		if(maze[i][j] == 'S'){
		    maze[i][j] = ' ';
		    return solve(i, j, 0);
		}
	    }
	}
	return -1;
    }

    private int solve(int row, int col, int numSteps){
	if(maze[row][col] == 'E'){
	    return numSteps;
	}
	if(maze[row][col] != ' '){
	    return -1;
	}
	maze[row][col] = '@';
        if(animate){
            clearTerminal();
            System.out.println(this);
	    System.out.println(numSteps);
            wait(200);
        }
	if((solve(row, col + 1, numSteps + 1) == -1 && solve(row + 1, col, numSteps + 1) == -1) && (solve(row, col - 1, numSteps + 1) == -1 && solve(row - 1, col, numSteps + 1) == -1)){
	    maze[row][col] = '.';
	    //numSteps--;
	    return -1;
	}
	return numSteps;
    }

    public String toString(){
        String str = "";
        for(int i  = 0; i < maze.length; i++){
            for(int j  = 0; j < maze[i].length; j++){
                str += maze[i][j];
            }
            str += "\n";
        }
        return str;
    }

    public static void main(String[] args){
	try{
	    Maze m = new Maze("data3.dat");
	    //m.setAnimate(true);
	    System.out.println(m.solve());
	    System.out.println(m);
	}catch(FileNotFoundException e){
	    System.out.println("WHAT");
	    System.exit(0);
	}
    }
}
