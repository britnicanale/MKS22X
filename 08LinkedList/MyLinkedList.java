public class MyLinkedList{

    private Node start, end;
    private int size;

    public MyLinkedList(){
	int size = 0;
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    public boolean add(Integer value){
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

    public boolean add(int index, Integer value){
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

    public Integer remove(int index){
	if(index >= size  || index < 0){
            throw new IndexOutOfBoundsException();
        }
	Integer ret = getNode(index).getValue();
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
	//System.out.println(this);
	return ret;
	
    }


    public boolean remove(Integer value){
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
	//Node current = start;
	for(int i = 0; i < size - 1; i++){ 
	    ret += get(i) + ", ";
	}
	return ret + get(size-1) + "]";
    }

    public Integer get(int index){
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

    public Integer set(int index, Integer newValue){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start;
        for(int i = 0; i < index; i++){
            current= current.getNext();
        }
	Integer old = current.getValue();
	current.setValue(newValue);
	return old;
    }

    public int indexOf(Integer value){
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
    private class Node{
	
	private Integer data;
	private Node next, prev;

	private Node(Integer d){
	    data = d;
	}

	private Integer getValue(){
	    return data;
	}

	private Node getNext(){
	    return next;
	}
	private Node getPrev(){
	    return prev;
	}

	private void setValue(Integer d){
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
	//System.out.println("Should be [8, 9, 10]");
	System.out.println("Should be 9: " + (m.get(1)));
	System.out.println("Should be [8, 9, 10]: " + m);
	m.set(2, 100);
	System.out.println("Should be [8, 9, 100]: " +m);
	System.out.println("Should be 9: " +m.getNode(2).getPrev().getValue());
	m.add(0, 99);
	System.out.println("Should be [99, 8, 9, 100]: " +m);
	System.out.println(m.add(4, 66));
	System.out.println("Should be [99, 8, 9, 100, 66]: " +m);
	m.add(2, -1);
	System.out.println("Should be [99, 8, -1, 9, 100, 66]: " +m);
	System.out.println(m.remove(1));
	System.out.println("Should be [99, -1, 9, 100, 66]: " +m);
	System.out.println(m.remove(1));
        System.out.println("Should be [99,  9, 100, 66]: " +m);
	System.out.println(m.remove(1));
        System.out.println("Should be [99,  100, 66]: " +m);
	System.out.println(m.remove(1));
        System.out.println("Should be [99,  66]: " +m);
	System.out.println(m.remove(1));
        System.out.println("Should be [99]: " +m);
	System.out.println(m.remove(0));
        System.out.println("Should be []: " +m);
    }
}