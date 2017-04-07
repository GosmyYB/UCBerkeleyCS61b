import java.io.*;
import java.util.Scanner;
public class Nuke2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine();
		if (str.length() > 2) {
			// remove the second character.
			System.out.println(str.substring(0, 1) + str.substring(2));
		} else {
			System.out.println("Your input is illegal.");
		}
	}
}