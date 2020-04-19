import java.util.*;

//Queue class
import java.util.PriorityQueue;
import java.util.Scanner;

public class StreamingWords {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int count1 = 0;
                int count2 = 0;
                for (int i=0;i<s1.length();i++){
                    if (s1.charAt(i)==' ' && s1.charAt(i+1)!=' ')
                        count1++;
                }
                for (int j=0;j<s2.length();j++) {
                    if(s2.charAt(j)==' ' && s2.charAt(j+1)!=' ')
                    count2++;

                }
                return count1 - count2;//s1.length() - s2.length();
            }
        };
        PriorityQueue<String> sortedword = new PriorityQueue<>(stringLengthComparator);
        while (true) {

            String input = kb.nextLine();

            if (input.equals("END")) {
                break;
            } else {

                //String[] tokens = input.split("\n");
                //for (String token : tokens) {
                    sortedword.add(input);//(kb.nextLine());//(token);
                //}
            }
        }

        System.out.println(sortedword.remove());
        while (!sortedword.isEmpty()) {
            System.out.println(sortedword.remove());
        }

        kb.close();
    }
}
