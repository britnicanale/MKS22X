import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class RunningMedian{
    private MyHeap<Double> lower, higher;
    private Double median;
    private int size;

    public RunningMedian(){
	lower = new MyHeap<>(true);
	higher = new MyHeap<>(false);
	median = null;
	size = 0;
    }

    public void add(Double value){
	if(size == 0){
	    lower.add(value);
	    median = value;
	}else{
	    if(value < median){
		lower.add(value);
	    }else{
		higher.add(value);
	    }
	    if(higher.size() - lower.size() == 2){
		lower.add(higher.remove());
	    }
	    if(lower.size() - higher.size() == 2){
		higher.add(lower.remove());
	    }
	    if(lower.size() < higher.size()){
		median = higher.peek();
	    }else if (higher.size() < lower.size()){
		median = lower.peek();
	    }else{
		median = (higher.peek() + lower.peek())/2;
	    }
	}
	size++;
    }
    public Double getMedian(){
	return median;
    }

    public int size(){
	return size;
    }

    public static void main(String[] args){
	Random r = new Random();
	ArrayList<Double> d = new ArrayList<>();
        RunningMedian m = new RunningMedian();
	for(int i = 0; i < (int)Integer.parseInt(args[0]); i++){
	    Double n = Double.valueOf(r.nextInt(10000));
            m.add(n);
	    d.add(n);
	    System.out.println(d);
	    System.out.println(m.getMedian());
	}
    }
}