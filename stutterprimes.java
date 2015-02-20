public class stutterprimes{

	// methods are all executed from main
	public static void main(String args[]){
		computePrimes(47);
		isPrime(47);
		printStutter(47);
	}
	
	public class Counter{
		int currentCount;
		public Counter(int startingnum){
			currentCount = startingnum;
		}
		public int increment(){
			currentCount += 1;
			return (currentCount);
		}
	}
	
	// computes/prints every prime between 2 and n
	public static void computePrimes(int num){
		System.out.println("Primes between 2 and " + String.valueOf(num));
		for (int p = 2; p <= num; p++){
			boolean decision = true;
			for (int i = 2; i <= Math.sqrt(p); i++){
				if (p % i == 0)
					decision = false;
			}
			if (decision)
				System.out.println(p);
		}
	}

	// decides whether or not number is prime
	public static void isPrime(int num){
		System.out.println("Is " + String.valueOf(num) + " prime or not?");
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

	// prints stutter prime of a number
	public static void printStutter(int num){
		int length = (int) Math.log10(num);
		int mask = (int) Math.pow(10, length);
		String outp = "";
		while (mask >=1){
			int place = num / mask;
			num = num - (place * mask);
			outp += String.valueOf(place) + String.valueOf(place);
			mask /= 10;
		}
		System.out.println(outp);
	}
}
