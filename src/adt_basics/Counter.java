package adt_basics;

public class Counter {
    String id;
    int counter;
    public Counter(String id) {
        this.id = id;

        counter = 0;
    }

    public void increment() {
        counter++;
    }

    public int tally() {
        return counter;
    }

    @Override
    public String toString() {
        return String.format("%d %s", counter, id);
    }
}
