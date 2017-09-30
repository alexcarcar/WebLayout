package examples.basic.arrays;

import java.util.Random;

public class RollDie {
    public static void main(String[] args) {
        Random random = new Random();
        int[] f = new int[7];
        for (int i = 1; i <= 6000000; i++) {
            ++f[1 + random.nextInt(6)];
        }
        System.out.printf("%s%10s\n", "Face", "Frequency");
        for (int i = 1; i < f.length; i++) {
            System.out.printf("%4d%10d\n", i, f[i]);
        }
    }
}
