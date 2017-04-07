
public class BadTransactionException extends Exception {
	private int amount;

	public BadTransactionException(int invalidAmount) {
		super("Invalid amount: " + invalidAmount);
		amount = invalidAmount;
	}
}