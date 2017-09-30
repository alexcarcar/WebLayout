package examples.basic.arrays;

public class PassArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println("Effects of passing reference to entire array:\n" +
                "The values of the original array are:");
        for (int x : a) System.out.printf("   %d", x);

        modifyArray(a);
        System.out.println("\n\nThe values of the modfied array are:");
        for (int x : a) System.out.printf("   %d", x);

        System.out.printf("\n\nEffects of passing array element value:\n" +
                "a[3] before modifyElement: %d\n", a[3]);
        modifyElement(a[3]);
        System.out.printf("a[3] after modifyElement: %d\n", a[3]);
    }

    public static void modifyArray(int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            array2[i] *= 2;
        }
    }

    public static void modifyElement(int element) {
        element *= 2;
        System.out.printf("Value of element in modifyElement: %d\n", element);
    }
}
