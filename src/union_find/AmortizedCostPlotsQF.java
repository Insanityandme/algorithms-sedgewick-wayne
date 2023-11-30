package union_find;

import accumulator.VisualAccumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AmortizedCostPlotsQF {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    // Used for plotting amortized costs
    private int cost;
    private final VisualAccumulator vs;

    public AmortizedCostPlotsQF(int N) {
        // initialize N sites with integer names (0 to N-1)
        count = N;
        id = new int[N];

        // used for visualising data
        cost = 0;
        int arrayReferences = 1300;
        int connections = 900;
        vs = new VisualAccumulator(connections, arrayReferences);

        for (int i = 0; i < N; i++) {
            id[i] = i;
            cost++; // array access to id[i]
        }

    }

    // O(n)
    public void union(int site1, int site2) {
        // put site1 and site2 into the same component.
        int site1ID = find(site1);
        int site2ID = find(site2);

        // nothing to do if site1 and site2 are already
        // in the same component
        if (site1ID == site2ID) return;

        // rename site1's component to site2's name
        for (int i = 0; i < id.length; i++) {
            if (id[i] == site1ID) {
                id[i] = site2ID;
                cost++;
            }

            cost++; // array access
        }

        count--;

        // System.out.println(Arrays.toString(id));
    }

    // O(1)
    public int find(int site) {
        // component identifier for p (0 to N-1)
        cost++; // array access
        return id[site];
    }

    // O(1)
    public boolean connected(int site1, int site2) {
        // return true if p and q are in the same component
        cost += 2; // 2 array accesses

        vs.addDataValue(cost);

        cost = 0;

        return find(site1) == find(site2);
    }

    public int count() {
        // number of components
        return count;
    }

    public static void main(String[] args) {
        // solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt();
        AmortizedCostPlotsQF qf = new AmortizedCostPlotsQF(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // read pair to connect

            if (qf.connected(p, q)) continue; // ignore if connected
            qf.union(p, q);
        }

        StdOut.println(qf.count() + " components");
    }
}
