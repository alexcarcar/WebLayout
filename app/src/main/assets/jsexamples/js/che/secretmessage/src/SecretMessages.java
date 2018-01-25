import java.util.Scanner;

public class SecretMessages {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message to encode or decode:");
		String message = scan.nextLine();
		String output = "";
		
		/* Example 1:
		for (int x=message.length()-1; x>=0; x--) {
			output += message.charAt(x);
		}
		
		Output:
		Enter a message to encode or decode:
		mp5 ta edacra eht ta em teeM
		Meet me at the arcade at 5pm */
		
		/* Example 2 */
		char key = 13;
		for (int x=0; x<message.length(); x++) {
			output += (char)(message.charAt(x) + key);
		}
		System.out.println(output);

		/* Output:
		Enter a message to encode or decode:
		Secret messages are so cool!
		`rpr?-zr??ntr?-nr-?|-p||y. */

	}

}
