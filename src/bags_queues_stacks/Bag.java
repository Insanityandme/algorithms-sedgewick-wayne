package bags_queues_stacks;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private Node first; // top of stack (most recently added node)
    private int N; // number of items

    private class Node {
        // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; } // Or: N == 0
    public int size() { return N; }

    public void add(Item item) {
        // Add item to top of stack
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        N++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
