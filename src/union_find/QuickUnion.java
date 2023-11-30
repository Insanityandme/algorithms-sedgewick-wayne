package union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public QuickUnion(int N) {
        // initialize N sites with integer names (0 to N-1)
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // O(n)
    private int find(int p) {
        // Find component name
        while (p != id[p]) p = id[p];
        return p;
    }

    // O(n)
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }

    // O(n)
    public boolean connected(int p, int r) {
        // return true if p and q are in the same component
        return find(p) == find(r);
    }

    public int count() {
        // number of components
        return count;
    }

    public static void main(String[] args) {
        // solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt();
        QuickUnion qu = new QuickUnion(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // read pair to connect

            if (qu.connected(p, q)) continue; // ignore if connected
            qu.union(p, q);
            // StdOut.println(p + " " + q);
        }

        StdOut.println(qu.count() + " components");
    }
}
