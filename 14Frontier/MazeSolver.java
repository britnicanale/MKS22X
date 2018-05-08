public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }
    public boolean solve(){
	return solve(0);
    }
    public boolean solve(int mode){
	if(mode == 0){
	    frontier = new FrontierQueue();
	}else{
	    frontier = new FrontierStack();
	}
	Location[] f = maze.getNeighbors(maze.getStart());
	for(int i = 0; i < f.length && f[i] != null; i ++){
	    frontier.add(f[i]);
	}
	while(frontier.hasNext()){
	    System.out.println(maze.toStringColor(5));
	    Location next = frontier.next();
	    maze.set(next.getX(), next.getY(), '.');
	    Location[] neighbors = maze.getNeighbors(next);
	    /*	    if(neighbors[0] == null){
		maze.set(next.getX(), next.getY(), '.');
		}*/
	    for(int i = 0; i < neighbors.length && neighbors[i] != null; i ++){
		if(neighbors[i].getX() == maze.getEnd().getX() && neighbors[i].getY() == maze.getEnd().getY()){
		    Location curr = neighbors[i].getPrevious();
		    while(curr.getPrevious().getX() != maze.getStart().getX() && curr.getPrevious().getY() != maze.getStart().getY()){
			System.out.println(maze.toStringColor(10));
			maze.set(curr.getX(), curr.getY(), '@');
			curr = curr.getPrevious();
		    }
		    return true;
		}
		frontier.add(neighbors[i]);
		maze.set(neighbors[i].getX(), neighbors[i].getY(), '?');
	    }
	    
	    //maze.set(next.getX(), next.getY(), '.');
	}
	return false;
    }
    public static void main(String[] args){
	MazeSolver i = new MazeSolver("input.txt");
	i.solve(1);
    }
}