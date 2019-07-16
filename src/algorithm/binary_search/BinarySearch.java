package algorithm.binary_search;

public class BinarySearch {

    public static int rank(int key, int[] array) {

        int lo = 0;
        int hi = array.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key > array[mid]) lo = mid + 1;
            else if (key < array[mid]) hi = mid - 1;
            else return mid;
        }

        return -1;

    }

}
