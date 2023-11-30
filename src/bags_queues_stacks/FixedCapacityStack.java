package bags_queues_stacks;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    void push(Item item) {
        a[N++] = item;
    }

    Item pop() {
        return a[--N];
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }
}
