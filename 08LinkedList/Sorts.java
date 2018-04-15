import java.util.Random;
import java.util.Arrays;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if(data.size() != 0){
	    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
	    for(int i = 0; i < 10; i++){
		digits[i] = new MyLinkedListImproved<Integer>();
	    }
	  
	    MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
	    
	    for(Integer n : data){
		if(n > 0){
		    pos.add(n);
		data.remove(n);
		}
	    }
	    if(pos.size() > 0){
		double max = pos.get(pos.max());
		int maxDig = (int)Math.round(Math.log10(max));
		for(int i = 1; i <= maxDig; i++){
		    for(Integer n : pos){
			digits[getDig(n, i)].add(n);
		    }

		    pos.clear();
		for(int j = 0; j < 10; j++){
		    pos.extend(digits[j]);
		    digits[j].clear();
		}
		}
	    }
	    if(data.size() > 0){
		double min = data.get(data.min());
		int maxDig = (int)Math.round(Math.log10(-min));
		for(int i = 1; i <= maxDig; i++){
		    for(Integer n : data){
			digits[-getDig(n, i)].add(n);
		    }
		    data.clear();
		    for(int j = 9; j >= 0; j--){
			data.extend(digits[j]);
			digits[j].clear();
		    }
		}
	    }
	    data.extend(pos);
	}
    }
    private static int getDig(int j, int dig){
	return (j / (int)Math.round(Math.pow(10, dig - 1)))% 10;
    }
    public static void main(String[] args) {

	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(23);
	m.add(0);
	m.add(987);
	m.add(24);
	m.add(35);
	m.add(345);
	m.add(67);
	m.add(11);
	//Integer[] data = new Integer[15];
	//Random ran = new Random();
	/*for(int i = 0; i < 15; i++){
	    Integer n = ran.nextInt();
	    m.add(n);
	    data[i] = n;
	    }*/
	//Arrays.sort(data);
	//long end,start = System.currentTimeMillis();
	radixsort(m);
	//end = System.currentTimeMillis();
	//System.out.println(m);
	//System.out.println(data);
    }
}