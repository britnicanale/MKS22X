import java.util.Random;
public class Quick{
    public static int quickSelect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int part = partition(data, 0, data.length-1);
	while(part != k){
	    if(part < k){
		start = part + 1;
		part = partition(data, start, end);
	    }else{
		end = part - 1;
		part = partition(data, start, end);
	    }
	}
	return data[part];
    }
    public static void quickSort(int[] data){
	quickH(data, 0, data.length-1);
    }
    private static void quickH(int[] data, int start, int end){
	int part = partition(data, start, end);
	if(start - part!= 0){
	    quickH(data, start, part-1);
	}
	if(end - part != 0){
	    quickH(data, part + 1, end);
	}
    }
    public static void quickSortNew(int[] data){
	quickH(data, 0, data - 1);
    }
    public static void quickHNew(int[] data, int start, int end){
	int[] part = part(data, start, end);
	if(start - part[0] != 0){
	    quickHNew(data, start, part[0] - 1);
	}
	if(end - part[1] != 0){
	    quickHNew(data, part[1] + 1, end);
	}
    }

    public static int[] part
    
    public static int partition(int[] data, int start, int end){
	if(end-start == 0){
	    return end;
	}
	Random randgen = new Random();
	int pI = start + randgen.nextInt(end - start);
	int large = end;
	int small = start + 1;
	int i = small + 1;
	int mv = data[pI];
	data[pI] = data[small];
	data[small] = mv;
	while(large >= i    ){
	    if(data[i    ] > data[i-1  ]){
		i++;
	    }else if(data[i]> data[i-1]
		small++;
	    }
	}
	mv = data[large];
	data[large] = data[start];
	data[start] = mv;
	return large;
    }

    public static int[] part(int[] data, int start, int end){
	if(end-start == 0){
	    return end;
	}
	Random randgen = new Random();
        int pI = start + randgen.nextInt(end - start);
        int large = end;
        int small = start + 1;
	int i = small + 1;
        int mv = data[pI];
	data[pI] = data[small];
        data[small] = mv;
	while(large > i){
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

    public static String toString(int[] a){
        String ret = "";
        for(int i = 0; i < a.length; i++){
            ret += a[i] + " ";
        }
        return ret;
    }

    public static void main(String[] args){
	//Quick q = new Quick();
	int[] a = new int[]{2, -4,  4, 5, 32, 2, 8, 10, -3, 4, -23, 67, 98, 0};
	int[] b = new int[]{2, -4};
        int[] c = new int[]{2, -4,  4, 5, 32, 2, 8, 10, -3, 4, -23, 67, 98, 0};
        int[] d = new int[]{2};
	quickSort(d);
	System.out.println(toString(d));
	//System.out.println(quickSelect(a, 0));
    }
}
