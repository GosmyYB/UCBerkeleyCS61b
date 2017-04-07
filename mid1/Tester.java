

public class Tester {
	public static void main(String[] args) {
		//(new Tomcat()).greet(); // a

		//(new Tomcat()).greet(new Siamese()); // b

		// c 
		// Cat c = new Tomcat();
		// Tomcat t = c;
		// t.greet(c);

		// d
		//Cat c = new Siamese();
		//((Cat)c).greet();

		// e
		//Cat c = new Siamese();
		//c.greet(new Tomcat());

		// f
		//Cat c = new Siamese();
		//((Tomcat)c).greet(c);

		// g
		//Cat c = new Cat();
		//c.greet(c);

	}
}