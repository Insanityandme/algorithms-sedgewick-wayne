package drawings;

import edu.princeton.cs.algs4.*;

public class Interval2DTest {
    public static void main(String[] args) {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        Interval1D xBox = new Interval1D(xlo, xhi);
        Interval1D yBox = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xBox, yBox);
        box.draw();

        Counter c = new Counter("hits");

        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);

            if (box.contains(p)) c.increment();
            else p.draw();
        }

        // Won't work with intellij for some reason
        StdOut.println(c);
        StdOut.println(box.area());

        // Will work with intellij
        // System.out.println(c);
        // System.out.println(box.area());
    }
}
