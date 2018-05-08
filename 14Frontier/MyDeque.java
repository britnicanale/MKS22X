import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.ArrayList;

public class MyDeque<E>{

    private E[] data;
    private int start, end, size;

    @SuppressWarnings("unchecked")    

    public MyDeque(){
	data = (E[]) new Object[10];
	start = 5;
	end = 4;
	size = 0;
    }

    @SuppressWarnings("unchecked")

    public MyDeque(int cap){
	data = (E[])new Object[cap];
	start = data.length/2;
	end = data.length/2 - 1;
	size = 0;
    }

    public int size(){
	return size;
    }

    public void addFirst(E val){
	System.out.println(size());
	System.out.println(start + ", " + end); 
	if(val == null){
	    throw new NullPointerException();
	}
	if(size() == 0){
	    start = start - 1;
	    data[start] = val;
	}
	else{
	    if(size() == data.length){
		resize();
	    }
	    if(data[(start - 1 + data.length) % data.length] == null){
		start = start -1;
		data[(start + data.length) % data.length] = val;
	    }
	}
	size++;
    }

    public void addLast(E val){
	if(val == null){
            throw new NullPointerException();
	}
	if(size() == 0){
	    end = end + 1;
            data[end] =val;
	}
        else{
	    if(size() == data.length){
		resize();
	    } 
	    if(data[(end + 1 + data.length) % data.length] == null){
		end = end + 1;
		data[(end + data.length) % data.length] = val;
	    }
	}
	size++;
    }

    public E removeFirst(){
	if(data[(start + data.length) % data.length] == null){
	    throw new NoSuchElementException();
	}
	E ret = data[(start + data.length) % data.length];
	data[(start + data.length) % data.length] = null;
	start = start + 1;
	size--;
	return ret;
    }
    public E removeLast(){
        if(data[(end + data.length) % data.length] == null){
            throw new NoSuchElementException();
        }
        E ret = data[(end + data.length) % data.length];
        data[(end + data.length) % data.length] = null;
        end = end - 1;
	size--;
        return ret;
    }
    public E getFirst(){
	if(data[(start + data.length) % data.length] == null){
            throw new NoSuchElementException();
        }
	return data[(start + data.length) % data.length];
    }
    public E getLast(){
	if(data[(end + data.length) % data.length] == null){
            throw new NoSuchElementException();
	}
        return data[(end + data.length) % data.length];
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] n = (E[])new Object[data.length * 2];
	for(int i = 0; i < size(); i++){
	    n[i] = data[(start + i + data.length) % data.length];
	}
	int e = size() - 1;
	data = n;
	start = 0;
	end = e;
    }


    public String toString(){
	return Arrays.toString(data);
    }
    public static void main(String[] args){
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
}