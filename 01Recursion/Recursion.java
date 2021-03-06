public class Recursion{
    public Recursion(){
    }

    public int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelp(0, n, 0, 1);
    }

    public int fibHelp(int count, int n, int a, int b){
	if(count == n){
	    return a;
	}
	return fibHelp(count + 1, n, b, a + b);
    }

    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelp(n, n/2);
    }

    public double sqrtHelp(double n, double g){
	if(Math.abs(g * g - n) < n / 1000000){
	    return g;
	}
	return sqrtHelp(n, ((n / g) + g) / 2);
    }

    public static void main(String[] args){
	Recursion r = new Recursion();
	System.out.println(r.fact(1));
	System.out.println(r.fact(0));
	System.out.println(r.fact(2));
	System.out.println(r.fact(4));
	System.out.println(r.fact(5));
	System.out.println(r.fact(8));
	System.out.println(r.fact(10));
	System.out.println(r.fib(0));
	System.out.println(r.fib(1));
	System.out.println(r.fib(2));
	System.out.println(r.fib(3));
	System.out.println(r.fib(4));
	System.out.println(r.fib(5));
	System.out.println(r.sqrt(100));
	System.out.println(r.sqrt(-10000));
	System.out.println(r.sqrt(2));

    }
}