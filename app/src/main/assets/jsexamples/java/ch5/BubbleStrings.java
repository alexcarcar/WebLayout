/*
	Question #4 (p 178): Bubble sort a list of strings.
*/

class BubbleStrings {
    public static void main(String[] args) {
        String strs[] = {"Simon", "Geroge", "Carol", "Alex"};
        String t;
        int a, b, size;

        size = strs.length;
        System.out.print("Original array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + strs[i]);
        }
        System.out.println();
        for (a = 1; a < size; a++) {
            for (b = size - 1; b >= a; b--) {
                if (strs[b - 1].compareTo(strs[b]) > 0) { // if out of order
                    // exchange elements
                    t = strs[b - 1];
                    strs[b - 1] = strs[b];
                    strs[b] = t;
                }
            }
        }
        System.out.print("Sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + strs[i]);
        }
    }
}

// Original array is: Simon Geroge Carol Alex
// Sorted array is: Alex Carol Geroge Simon