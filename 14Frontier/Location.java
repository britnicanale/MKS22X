public class Location implements Comparable<Location>{
    private double distance;
    private int x, y; 
    private Location previous;

    public Location(int X, int Y, Location prev, double d){
	distance = d;
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
    public double getDistance(){
	return distance;
    }
    public Location getPrevious(){
	return previous;
    }
    public int compareTo(Location l){
	if(this.distance - l.getDistance() > 0){
	    return 1;
	}else if((this.distance - l.getDistance() < 0)){
		return -1;
	}else{
	    return 0;
	}

    }
}