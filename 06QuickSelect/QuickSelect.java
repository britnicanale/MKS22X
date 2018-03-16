
import java.util.Random;
public class QuickSelect{
    public Random randgen;

    public QuickSelect(){
	randgen = new Random();
    }
    public void split(int[] nums){
	System.out.println(toString(nums));
	int i = randgen.nextInt(nums.length);
	System.out.println(nums[i]);
	int mv;
	for(int j = 0; j < nums.length; j++){
	    if(nums[j] < nums[i] && j > i){
		mv = nums[j];
		for(int l = j; l > 0; l--){
		    nums[l] = nums[l-1];
		}
		nums[0] = mv;
		i++;
	    }else if(nums[j] > nums[i] && j < i){
		mv = nums[j];
		for(int l = j; l < nums.length - 1; l++){
		    nums[l] = nums[l + 1];
		}
                nums[nums.length-1] = mv;
		i--;
		j--;
	    }
	}
	System.out.println(nums[i]);

	System.out.println(toString(nums));
    }
    public static String toString(int[] a){
	String ret = "";
	for(int i = 0; i < a.length; i++){
	    ret += a[i] + " ";
	}
	return ret;
    }
    public static void main(String[] args){
	QuickSelect q = new QuickSelect();
	int[] a = new int[]{2, -4,  4, 5, 32, 2, 8, 10, -3, 4, -23, 67, 98, 0};
	q.split(a);
    }
}