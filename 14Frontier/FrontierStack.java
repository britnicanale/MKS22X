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
        return locations.getFirst() != null;
    }
}
