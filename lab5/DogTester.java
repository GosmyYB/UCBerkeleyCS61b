
public class DogTester {

	public static void main(String[] args) {
		Animal dog = new Dog();
		dog.eat("meat");

		Dog dog2 = new Dog();
		((Animal)dog).eat("meat");

		Animal dog3 = new Animal();
		((Dog) dog3).eat("meat");
	}
}