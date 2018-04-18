import java.util.LinkedList;

public class Stack{
    private LinkedList<Double> ll;

    public Stack(){
	ll = new LinkedList<Double>();
    }

    public void push(Double element){
	ll.add(element);
    }

    public Double pop(){
       return ll.remove(ll.size() - 1);
    }

    public Double peek(){
	return ll.get(ll.size() - 1);
    }
    public String toString(){
	return ll.toString();
    }
}
