package union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public QuickFind(int N) {
        // initialize N sites with integer names (0 to N-1)
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
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
        for (int i = 0; i < id.length; i++)
            if (id[i] == site1ID) id[i] = site2ID;
        count--;

        // System.out.println(Arrays.toString(id));
    }

    // O(1)
    public int find(int site) {
        // component identifier for p (0 to N-1)
        return id[site];
    }

    // O(1)
    public boolean connected(int site1, int site2) {
        // return true if p and q are in the same component
        return find(site1) == find(site2);
    }

    public int count() {
        // number of components
        return count;
    }

    public static void main(String[] args) {
        // solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt();
        QuickFind qf = new QuickFind(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // read pair to connect

            if (qf.connected(p, q)) continue; // ignore if connected
            qf.union(p, q);

            // StdOut.println(p + " " + q);
        }

        StdOut.println(qf.count() + " components");
    }

}
