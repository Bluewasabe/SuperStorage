import java.util.*;
import java.io.*;

//String inFile = "C:\\Users\\Bluew\\IdeaProjects\\New Project\\src\\Test.txt";
public class Dictionary {
    // variable to store the string word
    String word;
    //int flag = 0;
    // store height
    int h;
    Dictionary leftChild, rightChild;

    // vector to meaning
    Vector v;

    // constructor of Dictionary
    Dictionary(String data, String meaning) {
        word = data;
        v = new Vector();
        v.add(meaning);
        h = 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        DictionaryTree tree = new DictionaryTree();


        String inFile = args[0];
        //String inFile = "C:\\Users\\Bluew\\IdeaProjects\\New Project\\src\\TESTER.txt";

        File input = new File(inFile);
        Scanner sc = new Scanner(input);


        String wordin = " ", meaning = " ";
        while (sc.hasNextLine()) {

            String read = sc.nextLine();

            // System.out.println(read);
            //System.out.println("$" + read.toUpperCase());
            if (read.toUpperCase().equals(read) && read.length() > 0) {
                wordin = read;
                //System.out.println("@@@" + wordin);
            //if (Define(read))
               //meaning = read;

                meaning = sc.nextLine();
                //System.out.println("!!!" + meaning);


            }

            //System.out.println(meaning);
            //String read2 = sc.nextLine();

            tree.Root = tree.insert(tree.Root, wordin, meaning);
        }


        //wordin = "A";
        //meaning = "test";

        //String word = arr[0];
        //String meaning = read.substring(arr[0].length()+1);
        //tree.Root = tree.insert(tree.Root, wordin, meaning);

        System.out.println(tree.getHeight(tree.Root)-1);

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = scan.next();
            if (command.equalsIgnoreCase("SEARCH")) {
                String word = scan.next().toUpperCase();
                int flag = 0;
                tree.search(tree.Root, word);
                if(flag == 0)
                    System.out.println("WORD does not exist");
            } else if (command.equalsIgnoreCase("EXIT"))
                break;
            else
                System.out.println("Invalid command");
        }
    }

    public static boolean UpperTester(String s) {
        int tester = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                tester++;
            }
        }
        if (tester == s.length())
            return true;
        else
            return false;
    }
    public static boolean Define(String s){
        if (s.charAt(0) == 'D' && s.charAt(1) == 'e' && s.charAt(2) == 'f')
            return true;
        else
            return false;

    }
}

class DictionaryTree {

    // Root node
    Dictionary Root;

    static int flag = 0;

    // function for getting height
    int getHeight(Dictionary n) {
        if (n == null)
            return 0;

        return n.h;
    }

    // function to get maximum
    int getMax(int x, int y) {
        return (x > y) ? x : y;
    }

    // rotate Right for balancing
    Dictionary rotateRight(Dictionary input) {
        Dictionary temp1 = input.leftChild;
        Dictionary temp2 = temp1.rightChild;

        // rotate
        temp1.rightChild = input;
        input.leftChild = temp2;

        // update h
        input.h = getMax(getHeight(input.leftChild), getHeight(input.rightChild)) + 1;
        temp1.h = getMax(getHeight(temp1.leftChild), getHeight(temp1.rightChild)) + 1;

        //return root
        return temp1;
    }

    // rotate left for balancing
    Dictionary leftRotate(Dictionary input) {
        Dictionary temp1 = input.rightChild;
        Dictionary temp2 = temp1.leftChild;

        // rotate
        temp1.leftChild = input;
        input.rightChild = temp2;

        // update h
        input.h = getMax(getHeight(input.leftChild), getHeight(input.rightChild)) + 1;
        temp1.h = getMax(getHeight(temp1.leftChild), getHeight(temp1.rightChild)) + 1;

        // return root
        return temp1;
    }

    // get factor of balance
    int balanceFactor(Dictionary n) {
        if (n == null)
            return 0;

        return getHeight(n.leftChild) - getHeight(n.rightChild);
    }

    Dictionary insert(Dictionary root, String word, String meaning) {

        // insert according to bst
        if (root == null)
            return (new Dictionary(word, meaning));

        if ((word.compareTo(root.word)) < 0)
            root.leftChild = insert(root.leftChild, word, meaning);
        else if ((word.compareTo(root.word)) > 0)
            root.rightChild = insert(root.rightChild, word, meaning);

            // if allready present insert meaning
        else {
            (root.v).add(meaning);
            return root;
        }

        // update height
        root.h = 1 + getMax(getHeight(root.leftChild), getHeight(root.rightChild));

        // get balance factor
        int balFactor = balanceFactor(root);

        // if unbalanced
        if (balFactor > 1 && (word.compareTo(root.leftChild.word)) < 0)
            return rotateRight(root);



        // case = right right
        if (balFactor < -1 && (word.compareTo(root.rightChild.word)) > 0)
            return leftRotate(root);

        // case = left right

        if (balFactor > 1 && (word.compareTo(root.leftChild.word)) > 0) {
            root.leftChild = leftRotate(root.leftChild);
            return rotateRight(root);
        }

        // case = right left
        if (balFactor < -1 && (word.compareTo(root.rightChild.word)) < 0) {
            root.rightChild = rotateRight(root.rightChild);
            return leftRotate(root);
        }

        // else no change
        return root;
    }

    // search
    void search(Dictionary Root, String word) {
        if (Root != null) {
            if (word.equals(Root.word)) {

                for (int i = 0; i < Root.v.size(); i++)
                    System.out.println(Root.v.get(i));

            } else

            this.search(Root.leftChild, word);
            this.search(Root.rightChild, word);

        }

    }



}