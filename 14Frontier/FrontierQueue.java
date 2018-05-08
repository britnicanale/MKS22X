import java.util.NoSuchElementException;
//import java.util.Deque;

public class FrontierQueue implements Frontier{
    private MyDeque<Location> locations;

    public FrontierQueue(){
	locations = new MyDeque<>();
    }
    public Location next(){
	return locations.removeFirst();
    }
    public void add(Location next){
	locations.addLast(next);
    }
    public boolean hasNext(){
	try{
	    return locations.getFirst() != null;
	}catch(NoSuchElementException e){
	    return false;
	}
    }
}
