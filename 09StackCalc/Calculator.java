public class Calculator{
    public static double eval(String exp){
	Stack s = new Stack();
	while(exp.length() > 0){
	    String t = "";
	    int i = 0;
	    while(i < exp.length() && exp.charAt(i) != ' '){
		t += exp.charAt(i);
		i++;
	    }
	    if(i == exp.length() || exp.charAt(i) != ' '){
		exp = exp.substring(i);
	    }else{
		exp = exp.substring(i + 1);
	    }
	    if(t.equals("+")){
		s.push(s.pop() + s.pop());
	    }else if(t.equals("-")){
                s.push(- s.pop() + s.pop());
            }else if(t.equals("*")){
                s.push(s.pop() * s.pop());
            }else if(t.equals("/")){
                s.push((1/s.pop())* s.pop());
            }else if(t.equals("%")){
		double d = s.pop();
                s.push(s.pop() % d);
            }else if(!t.equals("")){
	        s.push(Double.parseDouble(t));
	    }
	}
	return s.peek();
    }
    public static void main(String[] args){
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}