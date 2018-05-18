import java.util.Arrays;

class Example {

    public static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergesort(array, temp, leftStart, middle);
        mergesort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
    	int leftEnd = (rightEnd + leftStart) / 2;
    	int rightStart = leftEnd + 1;
    	int size = rightEnd - leftStart + 1;

    	int left = leftStart;
    	int right = rightStart;
    	int index = leftStart;

    	while (left <= leftEnd && right <= rightEnd) {
    		if (array[left] <= array[right]) {
    			temp[index] = array[left];
    			index++;
    			left++;
    		} else {
    			temp[index] = array[right];
    			right++;
    		}
    		index++;
    	}
    	System.out.println(array+", "+left+", "+temp+", "+index+", "+(leftEnd - left + 1));
    	System.arraycopy(array, left, temp, index, leftEnd - left + 1);
    	System.arraycopy(array, right, temp, index, rightEnd - right + 1);
    	System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    public static void main(String[] args) {
        int[] data = {9, 2, 12, 4, 5, 9, 3, 2, 1, 15, 3, 6};
        System.out.println("Before sorting: " + Arrays.toString(data));
        mergesort(data);
        System.out.println("After sorting: " + Arrays.toString(data));
    }

}