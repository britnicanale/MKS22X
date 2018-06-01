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
	if(val == null){
	    throw new NullPointerException();
	}
	if(size() == 0){
	    start = (start - 1 + data.length) % data.length;
	    data[start] = val;
	}
	else{
	    if(size() == data.length){
		resize();
	    }
	    if(data[(start - 1 + data.length) % data.length] == null){
		start = (start -1 + data.length) % data.length;
		data[start] = val;
	    }
	}
	size++;
    }

    public void addLast(E val){
	if(val == null){
            throw new NullPointerException();
	}
	if(size() == 0){
	    end = (end + 1) % data.length;
            data[end] = val;
	}else{
	    if(size() == data.length){
		resize();
	    }
	    if(data[(end + 1) % data.length ] == null){
		end = (end + 1) % data.length;
		data[end] = val;
	    }
	}
	size++;
    }

    public E removeFirst(){
	if(data[start] == null){
	    throw new NoSuchElementException();
	}
	E ret = data[start];
	data[start] = null;
	start = (start + 1 + data.length) % data.length;
	size--;
	return ret;
    }
    public E removeLast(){
        if(data[end] == null){
            throw new NoSuchElementException();
        }
        E ret = data[end];
        data[end] = null;
        end = (end - 1 + data.length) % data.length;
	size--;
        return ret;
    }
    public E getFirst(){
	if(data[start] == null){
            throw new NoSuchElementException();
        }
	return data[start];
    }
    public E getLast(){
	if(data[end] == null){
            throw new NoSuchElementException();
	}
        return data[end];
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
}