class Example {
    static void arrayDemo() {
        int sample[] = new int[10];
        int i;
        for (i = 0; i < 10; i++)
            sample[i] = i;
        for (i = 0; i < 10; i++)
            System.out.println("This is sample[" + i + "]: " + sample[i]);
        // This is sample[0]: 0
        // This is sample[1]: 1
        // This is sample[2]: 2
        // This is sample[3]: 3
        // This is sample[4]: 4
        // This is sample[5]: 5
        // This is sample[6]: 6
        // This is sample[7]: 7
        // This is sample[8]: 8
        // This is sample[9]: 9
    }

    // Find the minimum and maximum values in an array.
    static void minMax() {
        int nums[] = new int[10];
        int min, max;
        nums[0] = 99;
        nums[1] = -10;
        nums[2] = 100123;
        nums[3] = 18;
        nums[4] = -978;
        nums[5] = 5623;
        nums[6] = 463;
        nums[7] = -9;
        nums[8] = 287;
        nums[9] = 49;
        min = max = nums[0];
        for (int i = 0; i < 10; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];

        }
        System.out.println("min and max: " + min + " " + max);
        // min and max: -978 100123
    }

    // Use array initializers.
    static void minMax2() {
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        int min, max;
        min = max = nums[0];
        for (int i = 0; i < 10; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];

        }
        System.out.println("min and max: " + min + " " + max);
        // min and max: -978 100123
    }

    // Demonstrate an array overrun.
    static void arrayErr() {
        int sample[] = new int[10];
        int i;
        try {
            for (i = 0; i < 100; i++) {
                sample[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        // java.lang.ArrayIndexOutOfBoundsException: 10
    }

    // Demonstrate a two-dimensional array. (p 142)
    static void twoD() {
        int t, i;
        int table[][] = new int[3][4];
        for (t = 0; t < 3; ++t) {
            for (i = 0; i < 4; ++i) {
                table[t][i] = (t * 4) + i + 1;
                System.out.print(table[t][i] + " ");
            }
            System.out.println();
        }
        // 1 2 3 4
        // 5 6 7 8
        // 9 10 11 12
    }

    public static void main(String[] args) {
        arrayDemo();
        minMax();
        minMax2();
        arrayErr();
        twoD();
    }
}
