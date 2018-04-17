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
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
	radixsort(data);
    }
    private static int getDig(int j, int dig){
	return (j / (int)Math.round(Math.pow(10, dig - 1)))% 10;
    }
    public static void main(String[] args) {
	/*
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
	    }
	//Arrays.sort(data);
	//long end,start = System.currentTimeMillis();
	radixsort(m);
	//end = System.currentTimeMillis();
	//System.out.println(m);
	//System.out.println(data);
	*/

	//-----------SORTING POSITIVES-----------
	System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
	MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
	int[] correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	long end,start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	boolean hasError = false;
	int index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with all positive integers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING NEGATIVES-----------
	System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
	data.clear();
	correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    temp *= -1;
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with all negative numbers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING POSITIVES AND NEGATIVES-----------
	System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
	data.clear();
	correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    if((int)(Math.random() * 1000) % 2 == 0){
		temp *= -1;
	    }
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING EMPTY LISTS-----------
	System.out.println("SORTING ON EMPTY LISTS");
	data.clear();
	correctData = new int[0];

	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your empty LinkedList is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
	System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
	data.clear();
	correctData = new int[1];

	int temp = (int)(Math.random() * 1000);
	data.add(temp);
	correctData[0] = temp;

	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with one positive element is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
	System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
	data.clear();
	correctData = new int[1];

	temp = (int)(Math.random() * 1000) * -1;
	data.add(temp);
	correctData[0] = temp;

	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with one negative element is properly sorted.");
	}
	else{
	    System.out.println(data);
	}

    }
}