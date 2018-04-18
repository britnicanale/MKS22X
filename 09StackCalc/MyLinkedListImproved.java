import java.util.*;
import java.util.Iterator;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{

    private Node start, end;
    private int size;

    public MyLinkedListImproved(){
        int size = 0;
    }

    public void clear(){
        start = null;
        end = null;
        size = 0;
    }

    public boolean add(T value){
        Node n = new Node(value);
        if(size == 0){
            start = n;
            end = n;
            size++;
            return true;
        }
        end.setNext(n);
        n.setPrev(end);
        end = n;
        size++;
        return true;
    }

    public boolean add(int index, T value){
        if(index > size  || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            add(value);
            return true;
        }
        Node n = new Node(value);
        if(index == 0){
            n.setNext(start);
            start.setPrev(n);
            start = n;
            size++;
            return true;
        }
        n.setNext(getNode(index));
        n.setPrev(getNode(index - 1));
        getNode(index - 1).setNext(n);
        getNode(index).setPrev(n);
	size++;
        return true;
    }

    public T remove(int index){
        if(index >= size  || index < 0){
            throw new IndexOutOfBoundsException();
        }
        T ret = getNode(index).getValue();
        Node prev = getNode(index - 1);
        Node next = getNode(index + 1);
        if(prev != null){
            prev.setNext(next);
        }
        if(next != null){
            next.setPrev(prev);
        }
        size--;
        if(index == 0){
            start = start.getNext();
        }
        if(index == size - 1){
            end = end.getPrev();
        }
        return ret;

    }


    public boolean remove(T value){
        if(size == 0){
            return false;
        }
        Node current = start;
        while(!current.getValue().equals(value)){
            if(current.getNext()== null){
                return false;
            }
            current = current.getNext();
        }
        Node prev = current.getPrev();
        Node next = current.getNext();
        if(prev != null){
            prev.setNext(next);
        }
        if(next != null){
            next.setPrev(prev);
        }
        size--;
        if(prev == null){
            start = start.getNext();
        }
        if(next == null){
            end = end.getPrev();
        }
        return true;
    }
    public int size(){
        return size;
    }

    public String toString(){
        if(size == 0){
            return "[]";
        }
        String ret = "[";
        for(int i = 0; i < size - 1; i++){
            ret += get(i) + ", ";
        }
        return ret + get(size-1) + "]";
    }

    public T get(int index){
        if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    private Node getNode(int index){
        if(index >= size || index < 0){
            return null;
        }
        Node current = start;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current;
    }

    public T set(int index, T newValue){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for(int i = 0; i < index; i++){
            current= current.getNext();
        }
        T old = current.getValue();
        current.setValue(newValue);
        return old;
    }

    public int indexOf(T value){
        if(size == 0){
            return -1;
        }
        int i = 0;
        Node current = start;
        while(!current.getValue().equals(value)){
            if(current.getNext()== null){
                return -1;
            }
            i++;
            current = current.getNext();
        }
        return i;
    }

    public int min(){
        if(size == 0){
            return -1;
        }
	int m = 0;
        T min = start.getValue();
        Node n = start;
        for(int i = 0; i < size; i++){
            if(min.compareTo(n.getValue()) > 0){
                min = n.getValue();
                m = i;
            }
            n = n.getNext();
        }
	return m;
    }
    
    public int max(){
	if(size == 0){
	    return -1;
	}
	//int curr = 0;
	int m = 0;
	T max = start.getValue();
	Node n = start;
	for(int i = 0; i < size; i++){
	    if(max.compareTo(n.getValue()) < 0){
		max = n.getValue();
		m = i;
	    }
	    n = n.getNext();
	}
	return m;
    }


    private Node getEnd(){
	return end;
    }
    private Node getStart(){
	return start;
    }

    public void extend(MyLinkedListImproved<T> other){
	if(other.getStart() != null){
	    if(start == null){
		start = other.getStart();
		end = other.getEnd();
		size = other.size();
		other.clear();
	    }else{
		end.setNext(other.getStart());
		other.getStart().setPrev(end);
		end = other.getEnd();
		size += other.size();
		other.clear();
	    }
	}
    }

    private class Node{
	private T data;
        private Node next, prev;

        private Node(T d){
            data = d;
        }

        private T getValue(){
            return data;
        }

        private Node getNext(){
            return next;
        }
        private Node getPrev(){
            return prev;
        }

        private void setValue(T d){
            data = d;
        }

        private void setNext(Node n){
            next = n;
	}
        private void setPrev(Node n){
            prev = n;
        }
        public String toString(){
            return data + "";
        }
    }
    
    public Iterator<T> iterator(){
	return new LinkedListIterator(this.start);
    }

    private class LinkedListIterator implements Iterator<T>{

	private Node current;

	public LinkedListIterator(Node curr){
	    current = curr;
	}

	public boolean hasNext(){
	    return current != null;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

	public T next(){
	    T ret;
	    if (!hasNext()){
		System.exit(0);
	    }
	    ret = current.getValue();
	    current = current.getNext();
	    return ret;
	}
    }

    

    public static void main(String[] args){
	/*MyLinkedListImproved<String> m = new MyLinkedListImproved<>();
	m.add("EGGS");
	m.add("ja;jfkdlajfk");
	m.add("ZZZZZZZ");
	m.add("zzzzz");
	System.out.println(m.max());
	System.out.println(m);*/
	MyLinkedListImproved<Integer> q = new MyLinkedListImproved<>();
        q.add(Integer.valueOf(9));
	q.add(Integer.valueOf(-1249));
	q.add(Integer.valueOf(129));
	q.add(Integer.valueOf(-9));
	q.add(Integer.valueOf(839));
	q.add(Integer.valueOf(99));
	//System.out.println(q.max());
	//System.out.println(q.min());
        //System.out.println(q);
	MyLinkedListImproved<Integer> r = new MyLinkedListImproved<>();
        r.add(Integer.valueOf(9));
        r.add(Integer.valueOf(-1249));
        r.add(Integer.valueOf(129));
	r.add(Integer.valueOf(-9));
        r.add(Integer.valueOf(839));
        r.add(Integer.valueOf(99));
	MyLinkedListImproved<Integer> w = new MyLinkedListImproved<>();
	w.extend(r);
	//System.out.println(w);
	//System.out.println(r);
	//System.out.println(q.size());
	/*	for(Integer n : q){
	    System.out.println(n);
	    }*/


	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
        Random ran = new Random();

        for(int i = 0; i < 30; i++){
            m.add(ran.nextInt(100));
        }
        System.out.println(m);
	System.out.println(m.max());
    }
}