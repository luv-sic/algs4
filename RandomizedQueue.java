
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[5];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (n == queue.length) {
            resize(n * 2);
        }
        queue[++n] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        checkEmpty();
        int i = getRandom();
        Item item = queue[i];
        queue[i] = null;
        n--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        checkEmpty();
        int i = getRandom();
        return queue[i];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void resize(int len) {
        Item[] q = (Item[]) new Object[len];
        for (int i = 0; i < queue.length; i++) {
            q[i] = queue[i];
        }
        queue = q;
    }

    private class QueueIterator implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return n != 0;
        }

        @Override
        public Item next() {
            return sample();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int getRandom() {
        int i = StdRandom.uniform(n) + 1;
        while (queue[i] == null) {
            i = StdRandom.uniform(n) + 1;
        }
        return i;
    }

    // unit testing (optional)
    public static void main(String[] args) {

    }
}
