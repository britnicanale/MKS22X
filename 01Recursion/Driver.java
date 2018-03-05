public class Driver{
    //Sqrt:
    double[] input = {1.0, 2.0, 4.0, 7.0, 10.0, 100.0, 1024.0, -1.0, 0.0};
    double[] output = {1.0,1.4142135623730951,2.0,2.6457513110645907,3.1622776601683795,10.0,32.0,-1,0.0};
    //-1 should throw an exception

    //FIB:
    int[] input = {0,1,2,3,5,30,40,45,-1};
    int[] output ={0,1,1,2,5,832040 ,102334155 ,1134903170 ,-1};

    //FACT:
    int[] input = {0,1,2,3,4,5,10,11,-1};
    int[] output ={1,1,2,6,24,120,3628800,39916800,-1};



    public static boolean closeEnough(double a, double b){
	if(a==0.0 && b==0.0)return true;
	if(a==0.0)return Math.abs(b) < 0.00000000001;
	if(b==0.0)return Math.abs(a) < 0.00000000001;
	return Math.abs(a-b)/a < 0.0001;
    }
    public static void main(String[] args){
	for(int i = 0; i > input.length; i++){
	    if(if closeEnough(input[i]