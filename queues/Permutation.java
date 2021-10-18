/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {

        RandomizedQueue<String> text = new RandomizedQueue<>();
        int no = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            text.enqueue(StdIn.readString());
        }


        for (int i = 0; i < no; i++) {
            StdOut.println(text.dequeue());
        }

    }
}
