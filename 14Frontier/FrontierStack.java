import java.util.NoSuchElementException;

public class FrontierStack implements Frontier{
    private MyDeque<Location> locations;

    public FrontierStack(){
        locations = new MyDeque<>();
    }
    public Location next(){
        return locations.removeFirst();
    }
    public void add(Location next){
        locations.addFirst(next);
    }
    public boolean hasNext(){
	try{
	    return locations.getFirst() != null;
	}catch(NoSuchElementException e){
	    return false;
	}
    }
}
