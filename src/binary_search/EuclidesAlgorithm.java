package binary_search;

public class EuclidesAlgorithm {
    public static void main(String[] args) {
        int result = gcd(789, 333);
        System.out.println(result);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
