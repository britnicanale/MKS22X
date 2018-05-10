public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	animate = false;
    }

    public MazeSolver(String mazeText, boolean ani){
	maze = new Maze(mazeText);
        animate= ani;
    }

    public void switchAnimate(boolean ani){
	animate = ani;
    }

    public boolean solve(){
	return solve(0);
    }
    public boolean solve(int mode){
	if(mode == 0){
	    frontier = new FrontierQueue();
	}else if(mode == 1){
	    frontier = new FrontierStack();
	}else{
	    frontier = new FrontierPriorityQueue();
	}
	Location[] f = maze.getNeighbors(maze.getStart());
	for(int i = 0; i < f.length && f[i] != null; i ++){
	    frontier.add(f[i]);
	}
	while(frontier.hasNext()){
	    if(animate){
		System.out.println(maze.toStringColor(50));
	    }
	    Location next = frontier.next();
	    maze.set(next.getX(), next.getY(), '.');
	    Location[] neighbors = maze.getNeighbors(next);
	    for(int i = 0; i < neighbors.length && neighbors[i] != null; i ++){
		if(neighbors[i].getX() == maze.getEnd().getX() && neighbors[i].getY() == maze.getEnd().getY()){
		    Location curr = neighbors[i].getPrevious();
		    while(curr.getX() != maze.getStart().getX() || curr.getY() != maze.getStart().getY()){
			maze.set(curr.getX(), curr.getY(), '@');
			if(animate){
			    System.out.println(maze.toStringColor(10));
			}
			curr = curr.getPrevious();
		    }
		    return true;
		}
		frontier.add(neighbors[i]);
		maze.set(neighbors[i].getX(), neighbors[i].getY(), '?');
	    }	    
	}
	return false;
    }
    public static void main(String[] args){
	MazeSolver i = new MazeSolver("data3.dat");

	i.switchAnimate(true);
	i.solve(2);
    }
}