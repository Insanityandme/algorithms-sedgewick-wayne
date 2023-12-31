package sum;

import binary_search.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.indexOf(-a[i]-a[j], a) > j)
                    cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();

        long before = System.currentTimeMillis();
        StdOut.println(count(a));
        long after = System.currentTimeMillis();

        System.out.println("Time: " + (after - before) / 1000.0 + "s");
    }
}
