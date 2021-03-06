import java.util.Arrays;
public class Merge{
    public static void swap(int[] ary, int a, int b){
	int c =ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                           
    }
    public static void insertionSort(int[] ary){
	for(int i = 1; i < ary.length; i++){
	    for(int j = i - 1; j >= 0 && ary[j] > ary[j+1]; j--){
		swap(ary, j, j + 1);
	    }
	}
    }

    public static void mergesort(int[] data){
	mergeHelp(data, 0, data.length-1);
    }
    public static void mergeHelp(int[] data, int start, int end){
	if(end-start > 43){
	    mergeHelp(data, start, start + (end- start)/2);
	    mergeHelp(data, start + (end-start)/2 + 1, end);
	    merge(data, start, start +(end-start)/2, start + (end-start)/2 + 1, end);
	}
	else{
	    int[] ary = new int[end - start + 1];
	    for(int i = start; i <=end; i++){
		ary[i - start] = data[i];
	    } 
	    insertionSort(ary);
	    for(int i = start; i <= end; i++){
		data[i] = ary[i - start];
	    }
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
   
    public static void main(String[] args){
	int[] a = new int[]{-3, 5, 12, -3, 4, 6, 1, 124, 98, 34, -34, 90};
	int[] b = new int[]{-3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3};
	long start,end;
	start = System.currentTimeMillis();
	insertionSort(a);
	end = System.currentTimeMillis();
	System.out.println(end-start);
	System.out.println(Arrays.toString(a));
    }
}