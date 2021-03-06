import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head = null;
    private Node tail = null;
    private int n = 0;

    private class Node {
        private final Item item;
        private Node next;
        private Node prev;

        Node(Item i) {
            item = i;
        }
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        checkArgs(item);
        n++;
        Node current = new Node(item);
        Node oldHead = head;
        if (head == null) {
            head = current;
            tail = current;
            return;
        }
        current.next = oldHead;
        oldHead.prev = current;
        head = current;
    }

    // add the item to the end
    public void addLast(Item item) {
        checkArgs(item);
        n++;
        Node current = new Node(item);
        Node oldTail = tail;
        if (head == null) {
            head = current;
            tail = current;
            return;
        }
        current.prev = oldTail;
        oldTail.next = current;
        tail = current;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Node first = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        n--;
        if (head.equals(tail)) {
            head = null;
            tail = null;
            return first.item;
        }
        head = head.next;
        head.prev = null;
        return first.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        Node last = tail;
        if (head == null) {
            throw new NoSuchElementException();
        }
        n--;
        if (head.equals(tail)) {
            head = null;
            tail = null;
            return last.item;
        }
        tail = last.prev;
        tail.next = null;
        return last.item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void checkArgs(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        String s = "";
        Node current = head;
        while (current != null) {
            s = s.concat((String) current.item);
            current = current.next;
        }
        return s;
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("1");
        deque.addLast("2");
        deque.addFirst("3");
        deque.addLast("4");
        StdOut.println(deque.toString());
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        StdOut.println(deque.toString());
        for (String item : deque) {
            StdOut.println(item);
        }
    }
}
