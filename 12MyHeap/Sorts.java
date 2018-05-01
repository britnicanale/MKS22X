import java.util.Random;
import java.util.Arrays;

public class Sorts{
    public static void heapsort(Integer[] data){
	MyHeap<Integer> m = new MyHeap<>();
	m.heapify(data);
	for(int i = 0; i < data.length; i++){
	    Integer t = m.remove();
	    data[m.size()] = t;
	}
    }

    public static void main(String[] args){
	Integer[] A = new Integer[Integer.parseInt(args[0])];
	Integer[] B = new Integer[A.length];
	Random r = new Random();
	for(int i = 0; i < A.length; i++){
	    Integer n = Integer.valueOf(r.nextInt(10000));
	    B[i] = n;
	    A[i] = n;
	}
	System.out.println(Arrays.toString(A));
	heapsort(A);
	Arrays.sort(B);
	for(int i = 0; i < A.length; i++){
	    if(!A[i].equals(B[i])){
		System.out.println("ERROR");
	    }
	}
	System.out.println(Arrays.toString(A));
    }
}