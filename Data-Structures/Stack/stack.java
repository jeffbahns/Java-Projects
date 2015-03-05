public class stack {
	
	private int t;
	private int[] stackr = new int[15];
	
	public void stack(){
		t = -1;
	}
	
	boolean isEmpty(){
		return (t+1 == 0);
	}
	void push(int n){
		if isEmpty(){
			return null;
		}
		else{
			t = t + 1;
			stackr[t] = n;
		}
	}

	void pop(){
	}
}