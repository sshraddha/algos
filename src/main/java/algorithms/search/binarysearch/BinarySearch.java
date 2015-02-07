package algorithms.search.binarysearch;

import java.util.Arrays;

/**
 * @author vkavuluri
 */
public class BinarySearch {


    private int binarySearch(int[] a, int needle, int left, int right) {

        if (left > right) {
            return -1;
        }

        int idx = (left + right) / 2;

        if(idx >= a.length) {
            return -1;
        }

        int pivot = a[idx];

        if (needle < pivot) {
            right = idx - 1;
            return binarySearch(a, needle, left, right);
        } else if (needle > pivot) {
            left = idx + 1;
            return binarySearch(a, needle, left, right);
        } else {
            return pivot;
        }
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {1, 2, 3, 4, 5};
        int needle = 10;
        int result = bs.binarySearch(a, needle, 0, a.length);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("n = " + needle);
        System.out.println("result = " + result);
    }
}
