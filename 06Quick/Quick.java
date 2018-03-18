
import java.util.Random;
public class Quick{

    //New methods using dutch flag partition 
    public static int quickSelect(int[] data, int k){
        int start = 0;
        int end = data.length-1;
        int[] part = partition(data, 0, data.length-1);
        while(k < part[0] || k > part[1]){
            if(k < part[0]){
                end = part[0] - 1;
                part = partition(data, start, end);
            }else{
                start = part[1] + 1;
                part = partition(data, start, end);
            }
        }
        return data[part[0]];
    }

    public static void quickSort(int[] data){
	quickH(data, 0, data.length - 1);
    }

    private static void quickH(int[] data, int start, int end){
	int[] part = partition(data, start, end);
	if(start - part[0] < 0){
	    quickH(data, start, part[0] - 1);
	}
	if(end - part[1] > 0){
	    quickH(data, part[1] + 1, end);
	}
    }
    public static int[] partition(int[] data, int start, int end){
	if(end-start == 0){
	    int[] a = new int[]{start, end};
	    return a;
	}
	Random randgen = new Random();
        int pI = start + randgen.nextInt(end - start);
        int large = end;
        int small = start;
	int i = small + 1;
        int mv = data[pI];
	data[pI] = data[small];
        data[small] = mv;
	while(large >= i){
	    if(data[i] == data[i-1]){
		i++;
	    }else if(data[i] > data[i-1]){
		mv = data[i];
		data[i] = data[large];
		data[large] = mv;
		large--;
	    }else{
		mv = data[i];
                data[i] = data[small];
                data[small] = mv;
		i++;
		small++;
	    }
	}
	int[] a = new int[]{small, large};
	return a;
    }

    /*
      Old Methods using regular partition method
    
    public static int quickSelectOld(int[] data, int k){
        int start = 0;
        int end = data.length-1;
        int part = partitionOld(data, 0, data.length-1);
        while(part != k){
            if(part < k){
                start = part + 1;
                part = partitionOld(data, start, end);
            }else{
                end = part - 1;
                part = partitionOld(data, start, end);
            }
        }
        return data[part];
    }
    public static void quickSortOld(int[] data){
        quickHOld(data, 0, data.length-1);
    }
    private static void quickHOld(int[] data, int start, int end){
        int part = partitionOld(data, start, end);
        if(start - part!= 0){
            quickHOld(data, start, part-1);
        }
        if(end - part != 0){
            quickHOld(data, part + 1, end);
        }
    }
    private static int partitionOld(int[] data, int start, int end){
        if(end-start == 0){
            return end;
        }
        Random randgen = new Random();
        int pI = start + randgen.nextInt(end - start);
        int large = end;
        int small = start + 1;
        int mv = data[pI];
        data[pI] = data[start];
        data[start] = mv;
        while(large >= small){
            if(data[small] > data[start]){
                mv = data[large];
                data[large] = data[small];
                data[small] = mv;
                large--;
            }else{
                small++;
            }
        }
        mv = data[large];
        data[large] = data[start];
        data[start] = mv;
        return large;
    }


    */
    public static void main(String[] args){
	int[] a = new int[]{2, -4,  4, 5, 32, 2, 8, 10, -3, 4, -23, 67, 98, 0};
	int[] e = new int[]{2, -4,  4, 5, 32, 2, 8, 10, -3, 4, -23, 67, 98, 0};
	int[] b = new int[]{2, -4};
        int[] c = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] d = new int[]{2};
	System.out.println(quickSelect(a, 0));
	//System.out.println(toString(a));

	long start,end;
	start = System.nanoTime();
	quickSort(c);
	end = System.nanoTime();
	System.out.println(end-start);
	System.out.println(a);
	start = System.nanoTime();
        quickSortOld(c);
        end = System.nanoTime();
        System.out.println(end-start);
	System.out.println(e);
	//System.out.println(quickSelect(a, 0));
    }
}
