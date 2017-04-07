
public class Tester1 {

	public static void main(String[] args) {

		// (a)
		X[] xa = new Y[3];
		//Y[] ya = xa; // Compile-time error
		Y[] ya = new Y[3];

		xa = ya; // OK

		ya = (Y[]) xa; // OK

	}
}