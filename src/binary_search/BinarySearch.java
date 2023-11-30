package binary_search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int indexOf(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] allowlist = new In(args[0]).readAllInts();

        Arrays.sort(allowlist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            if (indexOf(key, allowlist) == -1)
                StdOut.println(key);
        }
    }
}
