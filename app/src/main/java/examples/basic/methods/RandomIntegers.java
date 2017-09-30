package examples.basic.methods;

import java.util.Random;

public class RandomIntegers {
    public static void main(String[] args) {
        Random randomNumbers = new Random();
        int face;
        for (int i = 1; i <= 20; i++) {
            face = 1 + randomNumbers.nextInt(6); // pick 1 to 6
            System.out.printf("%d ", face);
            if (i % 5 == 0)
                System.out.println();
        }
    }
}
