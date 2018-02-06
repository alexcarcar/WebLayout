import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
		String us = defaultFormat.format(payment);
        
		NumberFormat chFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
		String china = chFormat.format(payment);

		NumberFormat frFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		String france = frFormat.format(payment);

		String india = us.replace("$", "Rs.");

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
