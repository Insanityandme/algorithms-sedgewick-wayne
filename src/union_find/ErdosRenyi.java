package union_find;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        System.out.println("Number of connections generated: " + count(N, false));
    }

    public static int count(int N, boolean verbose) {
        int connections = 0;

        UF uf = new UF(N);

        while (uf.count() != 1) {
            int p = StdRandom.uniformInt(N);
            int q = StdRandom.uniformInt(N);

            if (verbose) StdOut.println("Connection generated: " + p + " - " + q);

            connections++;

            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }


        return connections;
    }
}
