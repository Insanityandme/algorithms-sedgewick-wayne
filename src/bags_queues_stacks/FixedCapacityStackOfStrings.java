package bags_queues_stacks;

public class FixedCapacityStackOfStrings {
    String[] a; // stack entries
    int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public void push(String item) { a[N++] = item; }

    public String pop() { return a[--N]; }

    public int size() { return N; }

    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return N == a.length - 1; }
}