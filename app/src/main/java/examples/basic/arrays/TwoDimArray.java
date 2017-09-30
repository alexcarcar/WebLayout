package examples.basic.arrays;

public class TwoDimArray {
    public static void main(String[] args) {
        int[][] a1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] a2 = {{1, 2}, {3}, {4, 5, 6}};
        System.out.println("Values in array1 by row are");
        outputArray(a1);
        System.out.println("Values in array2 by row are");
        outputArray(a2);
    }

    public static void outputArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }
}
