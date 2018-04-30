import java.util.Arrays;
import java.util.Random;


public class MyHeap<T extends Comparable<T>>{

    private T[] data;
    private int size;
    private boolean isMax;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[]) new Comparable[10];
	size = 0;
	isMax = true;
    }


    @SuppressWarnings("unchecked")
    public MyHeap(boolean max){
	data = (T[]) new Comparable[10];
        size = 0;
        isMax = max;
    }

    public void add(T s){
	if(size == data.length){
	    resize();
	}
	data[size] = s;
	size++;
	pushup(size - 1);
    }
    public T remove(){
	T top = data[0];
	data[0] = data[size-1];
	size--;
	pushdown(0);
	return top;
    }
    public T peek(){
	return data[0];
    }
    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	T[] n = (T[]) new Comparable[data.length*2];
	for(int i = 0; i < size; i++){
	    n[i] = data[i];
	}
	data = n;
    }
    private void pushup(int index){
	if(isMax && data[index].compareTo(data[(index - 1) / 2]) > 0){
	    T temp = data[(index -1) / 2];
	    data[(index -1) / 2] = data[index];
	    data[index] = temp;
	    pushup((index -1) / 2);
	}else if(!isMax && data[index].compareTo(data[(index -1) / 2]) < 0){
	    T temp = data[(index -1) / 2];
	    data[(index -1) / 2] = data[index];
	    data[index] = temp;
	    pushup((index -1) / 2);
	}
    }


    private void pushdown(int index){
	if(2*index+2 < size){
	    if(isMax && (data[2 * index + 2].compareTo(data[index]) > 0 || data[2 * index + 1].compareTo(data[index]) > 0)){
		if(data[2 * index + 2].compareTo(data[2*index + 1]) > 0){
		    T temp = data[2 * index + 2];
		    data[2 * index + 2] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 2);
		}else {
		    T temp = data[2 * index + 1];
		    data[2 * index + 1] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 1);
		}
	    }else if(!isMax && (data[2 * index + 2].compareTo(data[index]) < 0 || data[2 * index + 1].compareTo(data[index]) < 0)){
		if(data[2 * index + 2].compareTo(data[2*index + 1]) < 0){
		    T temp = data[2 * index + 2];
		    data[2 * index + 2] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 2);
		}else {
		    T temp = data[2 * index + 1];
		    data[2 * index + 1] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 1);
		}
	    }
	}else if(2* index + 1 < size){
	    if(isMax && data[2 * index + 1].compareTo(data[index]) > 0){
		T temp = data[2 * index + 1];
		data[2 * index + 1] = data[index];
		data[index] = temp;
		pushdown(2 * index + 1);
	    }else if(!isMax && data[2 * index + 1].compareTo(data[index]) < 0){
		T temp = data[2 * index + 1];
		data[2 * index + 1] = data[index];
		data[index] = temp;
		pushdown(2 * index + 1);
	    }
	}
    }
    /*
	if(2 * index + 1 < size){
	    if(isMax && (data[2 * index + 2].compareTo(data[index]) > 0 || data[2 * index + 1].compareTo(data[index]) > 0)){
		if(2*index + 2 < size){
		    if(data[2 * index + 2].compareTo(data[2*index + 1]) > 0){
			T temp = data[2 * index + 2];
			data[2 * index + 2] = data[index];
			data[index] = temp;
			pushdown(2 * index + 2);
		    }else {
			T temp = data[2 * index + 1];
			data[2 * index + 1] = data[index];
			data[index] = temp;
			pushdown(2 * index + 1);
		    }
		}else if(2*index + 2 < size){
		    T temp = data[2 * index + 1];
		    data[2 * index + 1] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 1);
		}
	    }else if(!isMax && (data[2 * index + 2].compareTo(data[index]) < 0 || data[2 * index + 1].compareTo(data[index]) < 0)){
		if(2*index + 2 < size){
		    if(data[2 * index + 2].compareTo(data[2*index + 1]) < 0){
			T temp = data[2 * index + 2];
			data[2 * index + 2] = data[index];
			data[index] = temp;
			pushdown(2 * index + 2);
		    }else {
			T temp = data[2 * index + 1];
			data[2 * index + 1] = data[index];
			data[index] = temp;
			pushdown(2 * index + 1);
		    }
		}else if(2*index + 2 < size){
		    T temp = data[2 * index + 1];
		    data[2 * index + 1] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 1);
		}
	    }
	}
    }
    */
    public String toString(){
	String ret = "";
	int nodesPassed = 0;
	for(int numNodes = 1; numNodes < size; numNodes*=2){
	    for(int i = 0; i < numNodes && i + nodesPassed < size; i++){
		ret += data[nodesPassed + i] + " ";
	    }
	    nodesPassed += numNodes;
	    ret += "\n";
	}

	return ret;

    }


    public T get(int index){
	return data[index];
    }
    public static void main(String[] args){
	MyHeap m = new MyHeap(false);
	//String a = "";
	Random r = new Random();
	for(int i = 0; i < (int)Integer.parseInt(args[0]); i++){
	    m.add(Integer.valueOf(r.nextInt(10000)));
	    //a+= i;
	    //System.out.println(m);

	}
	boolean isgood = true;
	for(int i = 0; i < m.size(); i++){
	    if((2*i + 2 < m.size() && m.get(2 * i +2) != null) && (m.get(i).compareTo(m.get(2 * i + 1))<0 || m.get(i).compareTo(m.get(2 * i +2)) < 0)){
		isgood = false;
	    }
	    System.out.println(isgood);
	}
	System.out.println(m);
	for(int i = 0; i < (int)Integer.parseInt(args[0]); i++){
            System.out.println(m.remove());
            //a+= i;

	    }
	String b = "1230";
	String c = "123";
	System.out.println(b.compareTo(c));

    }

}