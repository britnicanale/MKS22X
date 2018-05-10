public class FrontierPriorityQueue implements Frontier{

    private MyHeap<Location> pq;

    public FrontierPriorityQueue(){
	pq = new MyHeap<>(false);
    }

    public void add(Location l){
	pq.add(l);
    }

    public Location next(){
	return pq.remove();
    }

    public boolean hasNext(){
	return pq.size()>0;
    }
}