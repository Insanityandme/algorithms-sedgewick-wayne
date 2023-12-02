package elementary_sorts;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class SelectionVisualTrace {
    private int N;
    public static void sort(Comparable[] a) {
        // Implementing selection sort
        int N = a.length;

        for (int i = 0; i < N; i++) {
            // Exchange a[i] with the smallest entry in a[i+1...N]
            // index of minimal entry
            int min = i;

            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // Print the array, on a single line.
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }

        StdOut.println();
    }

    private static void showVisual(Comparable[] a) {
        StdDraw.setXscale(0, a.length);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.setPenRadius(0.005);

        for (int i = 0; i < a.length; i++) {
            String word = a[i].toString();
            IntStream intStream = word.codePoints();
            int charCodeSum = intStream.sum();

            StdDraw.setYscale(0, charCodeSum);

            StdDraw.filledRectangle(20, 20, 20, 20);
        }
    }

    public static boolean isSorted(Comparable[] a) {
        // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;

        return true;
    }

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        showVisual(a);
    }
}
