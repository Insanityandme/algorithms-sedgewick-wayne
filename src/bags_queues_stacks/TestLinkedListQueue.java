package bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on stack)");
    }
}
