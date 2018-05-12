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

    // Manually allocate differing size second dimensions.
    static void ragged() {
        int riders[][] = new int[7][];
        riders[0] = new int[10];
        riders[1] = new int[10];
        riders[2] = new int[10];
        riders[3] = new int[10];
        riders[4] = new int[10];
        riders[5] = new int[2];
        riders[6] = new int[2];

        int i, j;

        // fabricate some fake data
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 10; j++) {
                riders[i][j] = i + j + 10;
            }
        }
        for (i = 5; i < 7; i++) {
            for (j = 0; j < 2; j++) {
                riders[i][j] = i + j + 10;
            }
        }

        System.out.println("Riders per trip during the week:");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(riders[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Riders per trip on the weekend:");
        for (i = 5; i < 7; i++) {
            for (j = 0; j < 2; j++) {
                System.out.print(riders[i][j] + " ");
            }
            System.out.println();
        }
        // Riders per trip during the week:
        // 10 11 12 13 14 15 16 17 18 19
        // 11 12 13 14 15 16 17 18 19 20
        // 12 13 14 15 16 17 18 19 20 21
        // 13 14 15 16 17 18 19 20 21 22
        // 14 15 16 17 18 19 20 21 22 23

        // Riders per trip on the weekend:
        // 15 16
        // 16 17
    }

    public static void squares() {
        int sqrs[][] = {
                {1, 1},
                {2, 4},
                {3, 9},
                {4, 16},
                {5, 25},
                {6, 36},
                {7, 49},
                {8, 64},
                {9, 81},
                {10, 100}
        };
        int i, j;

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 2; j++) {
                System.out.print(sqrs[i][j] + " ");
            }
            System.out.println();
        }
        // 1 1
        // 2 4
        // 3 9
        // 4 16
        // 5 25
        // 6 36
        // 7 49
        // 8 64
        // 9 81
        // 10 100
    }

    static void assignARef() {
        int i;
        int nums1[] = new int[10];
        int nums2[] = new int[10];
        for (i = 0; i < 10; i++) {
            nums1[i] = i;
            nums2[i] = -i;
        }
        System.out.print("Here is nums1: ");
        for (i = 0; i < 10; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        System.out.print("Here is nums2: ");
        for (i = 0; i < 10; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();

        nums2 = nums1; // now nums2 refers to nums1
        System.out.print("Here is nums2 after assignment: ");
        for (i = 0; i < 10; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
        // now operate on nums1 array through nums2
        nums2[3] = 99;

        System.out.print("Here is nums1 after change through nums2: ");
        for (i = 0; i < 10; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        // Here is nums1: 0 1 2 3 4 5 6 7 8 9
        // Here is nums2: 0 -1 -2 -3 -4 -5 -6 -7 -8 -9
        // Here is nums2 after assignment: 0 1 2 3 4 5 6 7 8 9
        // Here is nums1 after change through nums2: 0 1 2 99 4 5 6 7 8 9
    }

    static void lengthDemo() {
        int list[] = new int[10];
        int nums[] = {1, 2, 3};
        int table[][] = { // a variable-length table
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        System.out.println("list.length is " + list.length);
        System.out.println("nums.length is " + nums.length);
        System.out.println("table.length is " + table.length);
        System.out.println("table[0].length is " + table[0].length);
        System.out.println("table[1].length is " + table[1].length);
        System.out.println("table[2].length is " + table[2].length);
        for (int i = 0; i < list.length; i++) {
            list[i] = i * i;
        }
        System.out.print("Here is list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        // list.length is 10
        // nums.length is 3
        // table.length is 3
        // table[0].length is 3
        // table[1].length is 2
        // table[2].length is 4
        // Here is list: 0 1 4 9 16 25 36 49 64 81
    }

    // Use length variable to help copy an array. (p 149)
    static void aCopy() {
        int i;
        int nums1[] = new int[10];
        int nums2[] = new int[10];
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = i;
        }
        // copy nums1 to nums2
        if (nums2.length >= nums1.length) {
            for (i = 0; i < nums1.length; i++) {
                nums2[i] = nums1[i];
            }
        }
        for (i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
        // 0 1 2 3 4 5 6 7 8 9
    }

    static void forEach() {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int x : nums) {
            System.out.println("Value is: " + x);
            sum += x;
        }
        System.out.println("Summation: " + sum);
        // Value is: 1
        // Value is: 2
        // Value is: 3
        // Value is: 4
        // Value is: 5
        // Value is: 6
        // Value is: 7
        // Value is: 8
        // Value is: 9
        // Value is: 10
        // Summation: 55
    }

    // The for-each loop is essentially read-only.
    static void noChange() {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : nums) {
            System.out.print(x + " ");
            x = x * 10; // no effect on nums
        }
        System.out.println();
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
        // 1 2 3 4 5 6 7 8 9 10
        // 1 2 3 4 5 6 7 8 9 10
    }

    static void search() {
        int nums[] = {6, 8, 3, 7, 5, 6, 1, 4};
        int val = 5;
        boolean found = false;
        for (int x : nums) {
            if (x == val) {
                found = true;
                break;
            }
        }
        if (found)
            System.out.println("Value found!");
        // Value found!
    }

    static void stringDemo() {
        String str1 = new String("Java strings are objects.");
        String str2 = "They are constructed various ways.";
        String str3 = new String(str2);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        // Java strings are objects.
        // They are constructed various ways.
        // They are constructed various ways.
    }

    static void strOps() {
        String str1 = "When it comes to Web programming, Java is #1.";
        String str2 = new String(str1);
        String str3 = "Java strings are powerful.";
        int result, idx;
        char ch;

        System.out.println("Length of str1: " + str1.length());
        for (int i = 0; i < str1.length(); i++) {
            System.out.print(str1.charAt(i));
        }
        System.out.println();
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3));

        str2 = "One Two Three One";
        idx = str2.indexOf("One");
        System.out.println("Index of first occurence of One: " + idx);
        idx = str2.lastIndexOf("One");
        System.out.println("Index of last occurence of One: " + idx);
        // Length of str1: 45
        // When it comes to Web programming, Java is #1.
        // str1.equals(str2): true
        // str1.equals(str3): false
        // str1.compareTo(str3): 13
        // Index of first occurence of One: 0
        // Index of last occurence of One: 14
    }

    static void stringArrays() {
        String strs[] = {"This", "is", "a", "test."};
        System.out.println("Original array: ");
        for (String s : strs)
            System.out.print(s + " ");
        System.out.println();
        // change a string
        strs[1] = "was";
        strs[3] = "test, too!";
        for (String s : strs)
            System.out.print(s + " ");
        System.out.println();
        // This is a test.
        // This was a test, too!
    }

    static void substring() {
        String orgstr = "Java makes the Web move.";
        String substr = orgstr.substring(5, 18);
        System.out.println("orgstr: " + orgstr);
        System.out.println("substr: " + substr);
        // orgstr: Java makes the Web move.
        // substr: makes the Web
    }

    static void stringSwitch() {
        String command = "cancel";
        switch (command) {
            case "connect":
                System.out.println("Connecting");
                break;
            case "cancel":
                System.out.println("Canceling");
                break;
            case "disconnect":
                System.out.println("Disconnecting");
                break;
            default:
                System.out.println("Command Error!");
                break;
        }
        // Canceling
    }

    static void clDemo(String[] args) {
        System.out.println("There are " + args.length + " command line arguments.");
        System.out.print("They are:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(" " + args[i]);
        }
        System.out.println();
        // There are 3 command line arguments.
        // They are: one two three
    }

    static void phone(String[] args) {
        String numbers[][] = {
                {"Tom", "555-3322"},
                {"Mary", "555-8976"},
                {"Jon", "555-1037"},
                {"Rachel", "555-1400"}
        };
        int i;
        if (args.length != 1)
            System.out.println("Usage: java Example <name>");
        else {
            for (i = 0; i < numbers.length; i++) {
                if (numbers[i][0].equals(args[0])) {
                    System.out.println(numbers[i][0] + ": " + numbers[i][1]);
                    break;
                }
            }
            if (i == numbers.length)
                System.out.println("Name not found.");
        }
        // java Example Mary
        // Mary: 555-8976
    }

    static void upCase() {
        char ch;
        for (int i = 0; i < 10; i++) {
            ch = (char) ('a' + i);
            System.out.print(ch);
            // This statement turns off the 6th bit.
            ch = (char) ((int) ch & 65503);
            System.out.print(ch + " ");
        }
        System.out.println();
        // aA bB cC dD eE fF gG hH iI jJ
    }

    static void showBits() {
        int t;
        byte val;

        val = 123;
        for (t = 128; t > 0; t = t / 2) {
            if ((val & t) != 0) System.out.print("1 ");
            else System.out.print("0 ");
        }
        System.out.println();
        /* 64+32+16+8+2+1 = 96+27 = 110+13 = 123 */
        // 0 1 1 1 1 0 1 1
    }

    static void lowCase() {
        char ch;
        for (int i = 0; i < 10; i++) {
            ch = (char) ('A' + i);
            System.out.print(ch);
            // This statement turns on the 6th bit (= 2^(6-1) = 2^5 = 32)
            ch = (char) ((int) ch | 32); // ch is now lowercase
            System.out.print(ch + " ");
        }
        System.out.println();
        // Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj
    }

    static void encode() {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        int key = 88;

        System.out.println("Original message: " + msg);

        for (int i = 0; i < msg.length(); i++)
            encmsg = encmsg + (char) (msg.charAt(i) ^ key);
        System.out.println("Encoded message: " + encmsg);

        for (int i = 0; i < msg.length(); i++)
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key);
        System.out.println("Decoded message: " + decmsg);
        // Original message: This is a test
        // Encoded message: 01+x1+x9x,=+,
        // Decoded message: This is a test
    }

    // Demonstrate the bitwise NOT. (p 170)
    static void notDemo() {
        byte b = -34;
        for (int t = 128; t > 0; t = t / 2) {
            if ((b & t) != 0) System.out.print("1 ");
            else System.out.print("0 ");
        }
        System.out.println();

        // reverse all bits
        b = (byte) ~b;

        for (int t = 128; t > 0; t = t / 2) {
            if ((b & t) != 0) System.out.print("1 ");
            else System.out.print("0 ");
        }
        System.out.println();
        // 1 1 0 1 1 1 1 0
        // 0 0 1 0 0 0 0 1
    }

    static void shiftDemo() {
        int val = 1;
        for (int i = 0; i < 8; i++) {
            for (int t = 128; t > 0; t = t / 2) {
                if ((val & t) != 0) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
            val = val << 1; // left shift
        }
        System.out.println();

        val = 128;
        for (int i = 0; i < 8; i++) {
            for (int t = 128; t > 0; t = t / 2) {
                if ((val & t) != 0) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
            val = val >> 1; // right shift
        }
        System.out.println();
        // 0 0 0 0 0 0 0 1
        // 0 0 0 0 0 0 1 0
        // 0 0 0 0 0 1 0 0
        // 0 0 0 0 1 0 0 0
        // 0 0 0 1 0 0 0 0
        // 0 0 1 0 0 0 0 0
        // 0 1 0 0 0 0 0 0
        // 1 0 0 0 0 0 0 0

        // 1 0 0 0 0 0 0 0
        // 0 1 0 0 0 0 0 0
        // 0 0 1 0 0 0 0 0
        // 0 0 0 1 0 0 0 0
        // 0 0 0 0 1 0 0 0
        // 0 0 0 0 0 1 0 0
        // 0 0 0 0 0 0 1 0
        // 0 0 0 0 0 0 0 1
    }

    static void noZeroDiv() {
        int result;
        for (int i = -5; i < 6; i++) {
            result = i != 0 ? 100 / i : 0;
            if (i != 0) {
                System.out.println("100 / " + i + " is " + result);
            }
        }
        // 100 / -5 is -20
        // 100 / -4 is -25
        // 100 / -3 is -33
        // 100 / -2 is -50
        // 100 / -1 is -100
        // 100 / 1 is 100
        // 100 / 2 is 50
        // 100 / 3 is 33
        // 100 / 4 is 25
        // 100 / 5 is 20
    }

    static void noZeroDiv2() {
        for (int i = -5; i < 6; i++)
            if (i != 0 ? true : false)
                System.out.println("100 / " + i + " is " + 100 / i);
        // 100 / -5 is -20
        // 100 / -4 is -25
        // 100 / -3 is -33
        // 100 / -2 is -50
        // 100 / -1 is -100
        // 100 / 1 is 100
        // 100 / 2 is 50
        // 100 / 3 is 33
        // 100 / 4 is 25
        // 100 / 5 is 20
    }

    public static void main(String[] args) {
        arrayDemo();
        minMax();
        minMax2();
        arrayErr();
        twoD();
        ragged();
        squares();
        assignARef();
        lengthDemo();
        aCopy();
        forEach();
        noChange();
        search();
        stringDemo();
        strOps();
        stringArrays();
        substring();
        stringSwitch();
        clDemo(args);
        phone(args);
        upCase();
        showBits();
        lowCase();
        encode();
        notDemo();
        shiftDemo();
        noZeroDiv();
        noZeroDiv2();

        System.out.println("I like Java".length()); // 11
        System.out.println("I like Java".charAt(2)); // l

        boolean a = true;
        boolean b = false;
        System.out.println(a&b);
        a = true;
        b = true;
        System.out.println(a&b);
    }
}
