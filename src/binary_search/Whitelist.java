package binary_search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Whitelist {
    public static void main(String[] args) {
        int[] w = new In(args[0]).readAllInts();
        StaticSETofInts set = new StaticSETofInts(w);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (set.rank(key) == -1)
                StdOut.println(key);
        }
    }
}
