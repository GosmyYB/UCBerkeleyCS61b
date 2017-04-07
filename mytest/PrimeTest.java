
public class PrimeTest {

	/**
	* Print primes from 2 to n(includes);
	*/
	public static void printPrimes(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}

	/**
	* A better version for printing primes.
	*/
	public static void printPrimes2(int n) {
		boolean[] primes = new boolean[n+1];
		int i;
		for (i = 2; i <= n; i++) {
			primes[i] = true;
		}
		// use base primes to get not prime numbers.
		for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) {
			if (primes[divisor]) {
				for (i = 2 * divisor; i <= n; i += divisor) {
					primes[i] = false;
				}
			}
		}

		// print the primes.
		for (i = 2; i <= n; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
	}

	/**
	* return ture if n is a prime, otherwise return false
	*/
	public static boolean isPrime(int n) {
		for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) {
			if (n % divisor == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] str) {
		printPrimes2(1000);
	}
}