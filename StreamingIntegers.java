//Chris Hollowood CSC 241

import java.util.PriorityQueue;
import java.util.Scanner;

public class StreamingIntegers {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        PriorityQueue<Integer> sortednum = new PriorityQueue<>();
        while (true) {

            String input = kb.nextLine();

            if (input.equals("END")) {
                break;
            } else {

                String[] tokens = input.split(" ");
                for (String token : tokens) {
                    sortednum.add(Integer.parseInt(token));
                }
            }
        }

        System.out.print(sortednum.remove());
        while (!sortednum.isEmpty()) {
            System.out.print(" " + sortednum.remove()); //+ " ");
        }

        kb.close();
    }
}
