import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;
    
    public Maze(String filename) throws FileNotFoundException{
	int numE = 0;
	int numS = 0;
	File f = new File(fileName);
	Scanner in = new Scanner(f);
	for(int j = 0; in.hasNext(); j++){
	    String line = in.next();
	    for(int i = 0; i < line.length(); i++){
		if(line.charAt(i) == 'S'){
		    numS ++;
		}
		if(line.charAt(i) == 'E'){
		    numE ++;
		}
		maze[j][i] == line.charAt(i);
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
    }

    private int solve(int row, int col){

        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        return -1;
    }
    public static void main(String[] args){
	Maze m = new Maze(data1.dat);
    }
}
