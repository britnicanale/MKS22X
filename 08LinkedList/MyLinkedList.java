public class MyLinkedList{

    private Node start, end;
    private int size;

    public MyLinkedList(){
	int size = 0;
    }

    public boolean add(int value){
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

    public boolean add(int index, int value){
	if(index > size){
            throw new IndexOutOfBoundsException();
        }
	if(index == size){
	    add(value);
	}
	Node n = new Node(value);
	if(index == 0){
	    n.setNext(start);
	    start.setPrev(n);
	    start = n;
	    size++;
	    return true;
        }
	getNode(index - 1).setNext(n);
	n.setPrev(getNode(index - 1));
	n.setNext(getNode(index));
	getNode(index).setPrev(n);
	size++;
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
	Node current = start;
	while(current.getNext() != null){
	    ret += current.getValue() + ", ";
	    current = current.getNext();
	}
	return ret + current.getValue() + "]";
    }

    public int get(int index){
	if(index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    private Node getNode(int index){
	if(index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current;
    }

    public int set(int index, int newValue){
	if(index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start;
        for(int i = 0; i < index; i++){
            current= current.getNext();
        }
	int old = current.getValue();
	current.setValue(newValue);
	return old;
    }

    private class Node{
	
	private int data;
	private Node next, prev;

	private Node(int d){
	    data = d;
	}

	private int getValue(){
	    return data;
	}

	private Node getNext(){
	    return next;
	}
	private Node getPrev(){
	    return prev;
	}

	private void setValue(int d){
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
    public static void main(String[] args){
	MyLinkedList m = new MyLinkedList();
	System.out.println(m);
	m.add(8);
	m.add(9);
	m.add(10);
	//System.out.println(m.get(1));
	System.out.println(m);
	m.set(2, 100);
	System.out.println(m);
	System.out.println(m.getNode(2).getPrev().getValue());
	m.add(0, 99);
	m.add(4, 66);
	m.add(2, -1);
	System.out.println(m);
    }
}