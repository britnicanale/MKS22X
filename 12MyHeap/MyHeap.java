import java.util.Arrays;
import java.util.Random;


public class MyHeap{

    private String[] data;
    private int size;
    private boolean isMax;

    public MyHeap(){
	data = new String[10];
	size = 0;
	isMax = true;
    }

    public MyHeap(boolean max){
	data = new String[10];
        size = 0;
        isMax = max;
    }
    public void add(String s){
	if(size == data.length){
	    resize();
	}
	data[size] = s;
	size++;
	pushup(size - 1);
    }
    public String remove(){
	String top = data[0];
	data[0] = data[size-1];
	size--;
	pushdown(0);
	return top;
    }
    public String peek(){
	return data[0];
    }
    public int size(){
	return size;
    }

    private void resize(){
	String[] n = new String[data.length*2];
	for(int i = 0; i < size; i++){
	    n[i] = data[i];
	}
	data = n;
    }
    private void pushup(int index){
	if(isMax && data[index].compareTo(data[(index - 1) / 2]) > 0){
	    String temp = data[(index -1) / 2];
	    data[(index -1) / 2] = data[index];
	    data[index] = temp;
	    pushup((index -1) / 2);
	}else if(!isMax && data[index].compareTo(data[(index -1) / 2]) < 0){
	    String temp = data[(index -1) / 2];
	    data[(index -1) / 2] = data[index];
	    data[index] = temp;
	    pushup((index -1) / 2);
	}
    }


    private void pushdown(int index){
	if(2 * index + 1 < size){
	    if(isMax && data[2 * index + 2].compareTo(data[index]) > 0 || data[2 * index + 1].compareTo(data[index]) > 0){
		if(2*index + 2 < size){
		    if(data[2 * index + 2].compareTo(data[2*index + 1]) > 0){
			String temp = data[2 * index + 2];
			data[2 * index + 2] = data[index];
			data[index] = temp;
			pushdown(2 * index + 2);
		    }else {
			String temp = data[2 * index + 1];
			data[2 * index + 1] = data[index];
			data[index] = temp;
			pushdown(2 * index + 1);
		    }
		}else if(2*index + 2 < size){
		    String temp = data[2 * index + 1];
		    data[2 * index + 1] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 1);
		}
	    }else if(!isMax && data[2 * index + 2].compareTo(data[index]) < 0 || data[2 * index + 1].compareTo(data[index]) < 0){
		if(2*index + 2 < size){
		    if(data[2 * index + 2].compareTo(data[2*index + 1]) < 0){
			String temp = data[2 * index + 2];
			data[2 * index + 2] = data[index];
			data[index] = temp;
			pushdown(2 * index + 2);
		    }else {
			String temp = data[2 * index + 1];
			data[2 * index + 1] = data[index];
			data[index] = temp;
			pushdown(2 * index + 1);
		    }
		}else if(2*index + 2 < size){
		    String temp = data[2 * index + 1];
		    data[2 * index + 1] = data[index];
		    data[index] = temp;
		    pushdown(2 * index + 1);
		}
	    }
	}
    }
    public String toString(){
	return Arrays.toString(data);

    }
    public static void main(String[] args){
	MyHeap m = new MyHeap();
	String a = "";
	Random r = new Random();
	for(int i = 0; i < (int)Integer.parseInt(args[0]); i++){
	    m.add("" + r.nextInt(10000));
	    a+= i;
	    //System.out.println(m);

	}
	for(int i = 0; i < (int)Integer.parseInt(args[0]); i++){
            System.out.println(m.remove());
            a+= i;

	    }
	String b = "1230";
	String c = "123";
	System.out.println(b.compareTo(a));

    }

}