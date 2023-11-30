import edu.princeton.cs.algs4.StdDraw;

public class DrawingExamples {
    public static void main(String[] args) {
        int N = 15;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);

        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i*i); // potens
            StdDraw.point(i, i*Math.log(i)); // logarithmic
        }
    }
}
