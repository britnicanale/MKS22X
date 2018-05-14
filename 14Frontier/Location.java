public class Location implements Comparable<Location>{
    private double distance, distTraveled;
    private int x, y; 
    private Location previous;
    private boolean aStar;

    public Location(int X, int Y, Location prev, double d, double dT, boolean aS){
	distance = d;
	x = X;
	y = Y;
	previous = prev;
	distTraveled = dT;
	aStar = aS;
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
    public double distanceTraveled(){
	return distTraveled;
    }
    public int compareTo(Location l){
	if(aStar){
	    if((this.distance + this.distTraveled) - (l.getDistance()+ l.distanceTraveled()) > 0){
		return 1;
	    }else if(((this.distance + this.distTraveled) - (l.getDistance() + l.distanceTraveled()) < 0)){
                return -1;
	    }else{
		return 0;
	    }
	}else{   
	    if(this.distance - l.getDistance() > 0){
		return 1;
	    }else if((this.distance - l.getDistance() < 0)){
		return -1;
	    }else{
		return 0;
	    }
	}
    }
}