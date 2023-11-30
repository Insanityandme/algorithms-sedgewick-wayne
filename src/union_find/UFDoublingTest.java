package union_find;

import analysis_of_algorithms.Stopwatch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class UFDoublingTest {
    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            // Print time for problem size N.
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }

    public static double timeTrial(int N) {
        return 0.0;
    }
}
