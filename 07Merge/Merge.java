
public class Merge{
    public static void mergeSort(int[] data){
	mergeHelp(data, 0, data.length-1);
    }
    public static void mergeHelp(int[] data, int start, int end){
	if(end-start > 0){
	    mergeHelp(data, start, start + (end- start)/2);
	    mergeHelp(data, start + (end-start)/2 + 1, end);
	    merge(data, start, start +(end-start)/2, start + (end-start)/2 + 1, end);
	}
    }
    public static void merge(int[] data, int start1, int end1, int start2, int end2){
	int[] temp = new int[end2-start1+1];
	int i = 0;
	int start = start1;
	while((start1<=end1 && start2<=end2)){
	    if(data[start1]>data[start2]){
		temp[i] = data[start2];
		i++;
		start2++;
	    }else{
		temp[i] = data[start1];
		i++;
		start1++;
	    }
	}
	while(start1<=end1){
	    temp[i] = data[start1];
	    start1++;
	    i++;
	}
	while(start2<=end2){
	    temp[i] = data[start2];
	    start2++;
	    i++;
	}
	for(i = start; i <= end2; i++){
	    data[i] = temp[i - start];
	}
    }
    /*    public static String toString(int[] ary){
	String ret = "[";
	for(int i = 0; i < ary.length; i ++){
	    ret+= ary[i] + " ";
	}
	return ret + "]";
    }
    */
    public static void main(String[] args){
	int[] a = new int[]{-3, 5, 12, -3, 4, 6, 1, 124, 98, 34, -34, 90};
	int[] b = new int[]{-3, 5, 12, 34, 34, -29, 1, 12, 98, 343, 344};
	mergeSort(a);
	//System.out.println(toString(a));
    }
}