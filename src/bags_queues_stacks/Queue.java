package bags_queues_stacks;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first; // top of stack (least recently added node)
    private Node last; // bottom of stack (most recently added node)
    private int N; // number of items

    private class Node {
        // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; } // Or: N == 0
    public int size() { return N; }

    public void enqueue(Item item) {
        // Remove item from top of stack
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) first = last;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
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