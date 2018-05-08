/*
	Try This 5-1

	Demonstrate the Bubble sort.
*/

class Bubble {
    public static void main(String[] args) {
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        int a, b, t;
        int size;

        size = nums.length;
        System.out.println(size);
        System.out.print("Original array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
        for (a = 1; a < size; a++) {
            for (b = size - 1; b >= a; b--) {
                if (nums[b - 1] > nums[b]) { // if out of order
                    // exchange elements
                    t = nums[b - 1];
                    nums[b - 1] = nums[b];
                    nums[b] = t;
                }
            }
        }
        System.out.print("Sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + nums[i]);
        }
    }
}

// 10
// Original array is: 99 -10 100123 18 -978 5623 463 -9 287 49
// Sorted array is: -978 -10 -9 18 49 99 287 463 5623 100123
