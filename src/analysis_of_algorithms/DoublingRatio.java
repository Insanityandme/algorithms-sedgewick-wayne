package analysis_of_algorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingRatio {
    public static void main(String[] args) {
        double prev = timeTrial(125);

        for (int N = 250; true; N += N) {
            double time = timeTrialCountpairs(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }

    public static double timeTrialCountpairs(int N) {
        int MAX = 1000000;
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = 1;
        }

        Stopwatch timer = new Stopwatch();
        int pairs = countpairs(a);

        return timer.elapsedTime();
    }

    public static int countpairs(int[] sortedarr) {
        int pairs = 0;
        int nbrToCompare = 0;
        int cntNumbers = 1;

        for (int i = 1; i < sortedarr.length; i++) {
            if (sortedarr[nbrToCompare] != sortedarr[i]) {
                nbrToCompare = i;
                pairs += (cntNumbers * (cntNumbers - 1)) /2;
                cntNumbers = 1;
            } else {
                cntNumbers += 1;
            }
        }

        // when you've reached the last cntNumbers.
        pairs += (cntNumbers * (cntNumbers - 1)) / 2;

        return pairs;
    }

    public static int countpairs1(int[] unsortedarr) {
        int N = unsortedarr.length;
        int pairs = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (unsortedarr[i] == unsortedarr[j])
                    pairs++;
            }
        }

        return pairs;
    }

    public static int countpairs2(int[] sortedarr) {
        int N = sortedarr.length;
        int pairs = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (sortedarr[i] != sortedarr[j])
                    break;

                if (sortedarr[i] == sortedarr[j])
                    pairs++;
            }
        }

        return pairs;
    }

    public static double timeTrial(int N) {
        // Time ThreeSum.count() for N random 6-digit ints.
        int MAX = 1000000;
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-MAX, MAX);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
}
