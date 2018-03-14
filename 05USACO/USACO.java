import java.util.*;
import java.io.*;

public class USACO{
    public static int bronze(String filename){
	int[][] lake;
	int avE;
	int numInstructions;
	try{
	     File f = new File(filename);
	     Scanner in = new Scanner(f);
	     int r = in.nextInt();
	     int c = in.nextInt();
	     avE = in.nextInt();
	     numInstructions = in.nextInt();
	     lake = new int[r][c];
	     in.nextLine();
	     for(int i = 0; i < lake.length; i++){
		 for(int j = 0; j < lake[0].length; j++){
		     lake[i][j] = in.nextInt();
		 }
		 in.nextLine();
	     }
	     //System.out.println(toString(lake));
	     while(numInstructions > 0){
		 int row = in.nextInt() - 1;
		 int col = in.nextInt() - 1;
		 int cut = in.nextInt();
		 int firstRow = row;
		     int firstCol = col;
		 int highEl = 0;
		 for(int i = row; i < row + 3 && i < lake.length; i++){
		     for(int j = col; j < col + 3 && j < lake[0].length; j++){
			 if(lake[i][j] > highEl){
			     firstRow = i;
			     firstCol = j;
			     highEl = lake[i][j];
			 }
		     }
		 }
		 int newEl = highEl - cut;
		 lake[firstRow][firstCol] = newEl;
		 for(int i = row; i < row + 3 && i < lake.length; i++){
                     for(int j = col; j < col + 3 && j < lake[0].length; j++){
                         if(lake[i][j] > newEl){
                            lake[i][j] = newEl;
                         }
                     }
                 }
		 //System.out.println(toString(lake));
		 numInstructions--;
		 if(numInstructions > 0){
		     in.nextLine();
		 }
	     }
	     int depth = 0;
	     for(int i = 0; i < lake.length; i++){
		 for(int j = 0; j < lake[0].length; j++){
		     lake[i][j] = lake[i][j] - avE;
		     if(lake[i][j] < 0){
			 depth += lake[i][j] * -1;
		     } 
		 }
	     }
	     //System.out.println(toStringEnd(lake));
	     return depth * 72 * 72;
	     //System.out.println(row + " " + col + " " + cut );
	}catch(FileNotFoundException e){
	    System.out.println("Yikes");
	}
	return -1;
    }


    public static int silver(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int rows = in.nextInt();
	    int cols = in.nextInt();
	    int T = in.nextInt();
	    in.nextLine();
	    char[][] map = new char[rows][cols];
	    for(int i = 0; i < map.length; i++){
		map[i] = in.nextLine().toCharArray();
	    }
	    int startRow = in.nextInt() - 1;
	    int startCol = in.nextInt() - 1;
	    int endRow = in.nextInt() - 1;
	    int endCol = in.nextInt() - 1;
	    int[][] moves = new int[rows][cols];
	    for(int i = 0; i < moves.length; i++){
                for(int j = 0; j < moves[0].length; j++){
                    moves[i][j] = 0;
                }
            }
	    int[][] moves2 = new int[rows][cols];
	    for(int i = 0; i < moves2.length; i++){
                for(int j = 0; j < moves2[0].length; j++){
                    moves[i][j] = 0;
                }
            }
	    moves[startRow][startCol] = 1;
	    int ret = 0;
	    for(int x = 0; x < T; x++){
		for(int i = 0; i < map.length; i++){
		    for(int j = 0; j < map[0].length; j++){
			if(map[i][j] == '*'){
			    moves[i][j] = 0;
			    moves2[i][j] = 0;
			}else if(x % 2 == 0){
			    if(moves[i][j]!= 0){
				moves2[i][j] = 0;
			    }else{
				int newNum = 0;
				if(i + 1 < map.length){
				    newNum += moves[i + 1][j];
				}
				if(j + 1 < map[0].length){
                                    newNum += moves[i][j + 1];
				}
				if(i - 1 >= 0){
                                    newNum += moves[i - 1][j];
				}
                                if(j - 1 >= 0){
                                    newNum += moves[i][j - 1];
                                }
				moves2[i][j] = newNum;
			    }
			}else{
			    if(moves2[i][j]!= 0){
                                moves[i][j] = 0;
                            }else{
                                int newNum = 0;
                                if(i + 1 < map.length){
                                    newNum += moves2[i + 1][j];
				}
                                if(j + 1 < map[0].length){
                                    newNum += moves2[i][j + 1];
                                }
				if(i - 1 >= 0){
                                    newNum += moves2[i - 1][j];
                                }
                                if(j - 1 >= 0){
                                    newNum += moves2[i][j - 1];
				}
                                moves[i][j] = newNum;
                            }
			}
		    }
		}
		/*if(x % 2 == 1){
		    System.out.println(toString(moves));
		}else{
		System.out.println(toString(moves2));
		}*/
	    }
	    if(T % 2 == 1){
		ret = moves2[endRow][endCol];
	    }else{
		ret = moves[endRow][endCol];
	    }

	    return ret;
	}catch(FileNotFoundException e){
	    System.out.println("Bad File");
	}
	return 0;
    }

    /*    public static String toString(int[][] lake){
        String str = "";
        for(int i = 0; i < lake.length; i++){
            for(int j = 0; j < lake[0].length; j++){
                if(lake[i][j] < 10){
                    str += "  " + lake[i][j];
                }else{
                    str += " " + lake[i][j];
                }
            }
            str+= "\n";
        }
        return str;
    }


    public static String toStringEnd(int[][] lake){
	String str = "";
	for(int i = 0; i < lake.length; i++){
	    for(int j = 0; j < lake[0].length; j++){
		if(lake[i][j] < 0){
		    str += " " + -1 * lake[i][j];
		}else{
		    str += "--";
		}
	    }
	    str+= "\n";
	}
	return str;
	}*/
    public static void main(String[] args){
	System.out.println(silver("ctravel.in"));
	System.out.println(silver("ctravel2.in"));
	System.out.println(silver("ctravel3.in"));
	System.out.println(silver("ctravel4.in"));
	System.out.println(silver("ctravel5.in"));
	System.out.println(silver("ctravel6.in"));
	System.out.println(silver("ctravel7.in"));
	System.out.println(silver("ctravel8.in"));
	System.out.println(silver("ctravel9.in"));
	System.out.println(silver("ctravel10.in"));
	System.out.println(bronze("makelake.in"));
	System.out.println(bronze("makelake2.in"));
	System.out.println(bronze("makelake3.in"));
	System.out.println(bronze("makelake8.in"));
    }

}
