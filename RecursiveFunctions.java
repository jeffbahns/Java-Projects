class factorial{

	public static void main(String[]args){
		
		// factorials 
		//System.out.println(factorialInt(5));
		//System.out.println(factorialAlt(5));
		
		// integer sum
		int[] array1 = {1,2,3,4,5};
		int elements = 5;
		int answer = linearSum(array1, elements);
		//System.out.println(answer);
		
		// power function
		//System.out.println(pow(2,5));

		// fibonacci sequence
		System.out.println(fib(6));
	}
	
	////////////////////////////////////////
	public static int factorialInt(int n){
		if (n < 0)
			return (0);
		else if (n == 0)
			return 1;
		else
			return n * factorialInt(n-1);
	}

	public static int factorialAlt(int n){
		int factorial = 1;
		for (int l = n; l > 0; l--){
			factorial *= l;
		}
		return factorial;
	}
	
	////////////////////////////////////////
	public static int linearSum(int[] data, int n){
		if (n==0)
			return 0;
		else
			return linearSum(data, n-1) + data[n-1];
	}

	////////////////////////////////////////
	public static int pow(int x, int n){
		if (n==0)
			return 1;
		else
			return x * pow(x, n-1);
	}

	////////////////////////////////////////
	public static int fib(int n){

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}

}