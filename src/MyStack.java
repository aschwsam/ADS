import java.util.Stack;


public class MyStack {
	
	private Stack mystack = new Stack();
	
	public MyStack(){
	}
	
	public void push(Object value){
		mystack.push(value);
	}
	
	public Object pop(){
	
		return mystack.pop();
	}
	
	public Object top(){
		Object tmp = mystack.pop();
		mystack.push(tmp);
		return tmp;		
	}
	
	public boolean isEmpty(){
		if(mystack.isEmpty()){
			return true;
		} else {
			return false;
		}
	}
}
