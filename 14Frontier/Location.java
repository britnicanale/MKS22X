public class Location{
    private int x, y; 
    private Location previous;

    public Location(int X, int Y, Location prev){
	x = X;
	y = Y;
	previous = prev;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public Location getPrevious(){
	return previous;
    }
}