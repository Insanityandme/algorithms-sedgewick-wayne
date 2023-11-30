package union_find;

import accumulator.VisualAccumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AmortizedCostPlotsWQU {
    private int[] id; // parent link (site indexed)
    private int[] sz; // size of component for roots (site indexed)
    private int count; // number of components

    // Used for plotting amortized costs
    private int cost;
    private VisualAccumulator vs;

    public AmortizedCostPlotsWQU(int N) {
        count = N;
        id = new int[N];

        // used for visualising data
        cost = 0;
        int arrayReferences = 1300;
        int connections = 900;
        vs = new VisualAccumulator(connections, arrayReferences);

        for (int i = 0; i < N; i++) {
            id[i] = i;
            cost++;
        }

        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        cost += 2;

        vs.addDataValue(cost);

        cost = 0;

        return find(p) == find(q);
    }

    private int find(int p) {
        // Follow links to find a root.
        while (p != id[p]) {
            p = id[p];

            cost++;
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];

        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        cost++;
        count--;
    }

    public static void main(String[] args) {
        // solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt();
        AmortizedCostPlotsWQU wqu = new AmortizedCostPlotsWQU(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // read pair to connect

            if (wqu.connected(p, q)) continue; // ignore if connected
            wqu.union(p, q);
            // StdOut.println(p + " " + q);
        }

        StdOut.println(wqu.count() + " components");
    }
}
