import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int size;
    private int removedItem;

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int count;


        public RandomizedQueueIterator() {
            count = 0;
        }

        public boolean hasNext() {
            return (count < size && count >= 0);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


        public Item next() {
            if (count == size)
                throw new NoSuchElementException();

            return arr[count++];

        }


    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[1];
        size = 0;
        removedItem = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (size == arr.length) resize(2 * arr.length);
        arr[size++] = item;


    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item removed = sample();
        // swap
        Item temp = arr[size - 1];
        arr[removedItem] = temp;
        arr[size - 1] = null;
        if (size > 0 && size == arr.length / 4) resize(arr.length / 2);
        size--;
        return removed;

    }


    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        //  int index = (int) (Math.random() * ((size) + 1));
        int index = edu.princeton.cs.algs4.StdRandom.uniform(0, size);
        removedItem = index;
        return arr[index];

    }

    // return an independent iterator over items in random order


    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }


    private void resize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];

        }

        arr = newArr;

    }

    // unit testing (required)

    public static void main(String[] args) {
        RandomizedQueue<Integer> obj = new RandomizedQueue<Integer>();
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        StdOut.println(obj.isEmpty());
        obj.dequeue();
        StdOut.println(obj.size());
        StdOut.println(obj.sample());
        for (Integer integer : obj) {
            StdOut.println(integer);
        }

    }

}
