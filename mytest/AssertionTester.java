
public class AssertionTester {

	public static void test(int x) {
		assert(x == 3) : " x should be 3.";
	}

	public static void main(String[] args) {
		int x = 4;
		test(x);
	}
}