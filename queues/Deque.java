import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node front;
    private Node rear;
    private int size;

    private class Node {
        private Item value;
        private Node next;
        private Node before;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = front;

        public DequeIterator() {


        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null)
                throw new NoSuchElementException();
            Item item = current.value;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    // construct an empty deque
    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }


    // is the deque empty?
    public boolean isEmpty() {

        return (size == 0);
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();


        Node oldNode = front;
        front = new Node();
        front.value = item;
        if (oldNode == null)
            rear = front;
        else {

            front.next = oldNode;
            rear.before = front;
        }
        size++;

    }


    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (rear == null) {
            front = rear = new Node();
            rear.value = item;
            size++;
        }
        else {
            Node oldRear = rear;
            rear = new Node();
            rear.value = item;
            rear.before = oldRear;
            oldRear.next = rear;
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (front == null)
            throw new NoSuchElementException();

        Node oldFront = front;
        front = front.next;
        if (oldFront == rear)
            rear = front;
        size--;
        return oldFront.value;

    }

    // remove and return the item from the back

    public Item removeLast() {
        if (front == null && rear == null)
            throw new NoSuchElementException();

        Node oldRear = rear;
        if (front == rear)
            front = rear = null;

        else {
            rear = new Node();
            rear = oldRear.before;
            rear.next = null;
        }
        size--;
        return oldRear.value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> obj = new Deque<Integer>();
        obj.addFirst(22);
        obj.addFirst(24);
        obj.addLast(23);
        obj.addLast(25);

        obj.removeLast();
        obj.removeFirst();
        StdOut.println(obj.size());
        StdOut.println(obj.isEmpty());
        for (Integer integer : obj) {
            StdOut.println(integer);
        }
    }

}
