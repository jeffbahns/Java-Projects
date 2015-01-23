
public class stutterprimes{
	
	public static void main(String args[]){
		//computePrimes(30);
		//isPrime(4);
		printStutter(13);
	}
	
	public static void computePrimes(int num){
		for (int p = 2; p <= num; p++){
			System.out.println("-----------------");
			System.out.println(p);
			boolean decision = true;
			for (int i = 2; i <= Math.sqrt(p); i++){
				if (p % i == 0)
					decision = false;
			}
			if (decision)
				System.out.println("PRIME!");
			else
				System.out.println("NOT PRIME!");
		}
	}

	public static void isPrime(int num){
		boolean decision = true;
		for (int i = 2; i <= Math.sqrt(num); i++){
			if (num % i == 0)
				decision = false;
		}
		if (decision)
			System.out.println("PRIME!");
		else
			System.out.println("NOT PRIME!");
	}

	public static void printStutter(int num){
		int lim = 1000000;
		String jeff = "";
		while (lim >=1){
			num = num - lim;
			System.out.println(jeff);
			lim = lim / 10;
		}
	}
}