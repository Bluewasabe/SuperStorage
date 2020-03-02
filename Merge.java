import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Merge {

    public static ArrayList<Integer> InsertionSortA(String file) throws Exception {

        //change string to file and read it with scanner
        File tempfile = new File(file);
        Scanner sc = new Scanner(tempfile);

        //create an Array to store Strings from text
        ArrayList<Integer> inputArray = new ArrayList<Integer>();

        //scan .txt and add Strings to List
        int intAdd;
        while (sc.hasNextInt()) {
            intAdd = sc.nextInt();
            inputArray.add(intAdd);
        }

        //This is the actual insertion sort
        for (int i = 1; i < inputArray.size(); i++) {
            int key = inputArray.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (key >= inputArray.get(j)) {
                    break;
                }
                inputArray.set(j + 1, inputArray.get(j));
                j--;
            }
            inputArray.set(j + 1, key);
        }
        System.out.println(toString(inputArray));
        return inputArray;
        //System.out.print(toString(inputArray));
    }

    public static ArrayList<Integer> InsertionSortD(String file) throws Exception {

        //change string to file and read it with scanner
        File tempfile = new File(file);
        Scanner sc = new Scanner(tempfile);

        //create an Array to store Strings from text
        ArrayList<Integer> inputArray = new ArrayList<Integer>();

        //scan .txt and add Strings to List
        int intAdd;
        while (sc.hasNextInt()) {
            intAdd = sc.nextInt();
            inputArray.add(intAdd);
        }

        //This is the actual insertion sort
        for (int i = 1; i < inputArray.size(); i++) {
            int key = inputArray.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (key <= inputArray.get(j)) {
                    break;
                }
                inputArray.set(j + 1, inputArray.get(j));
                j--;
            }
            inputArray.set(j + 1, key);
        }

        System.out.println(toString(inputArray));
        return inputArray;
    }

    public static void mergeSort(String file0, String file1) throws Exception {
        ArrayList<Integer> arr1 = InsertionSortA(file0);
        ArrayList<Integer> arr2 = InsertionSortD(file1);
        ArrayList<Integer> arr3 = new ArrayList<Integer>();

        //set up the starting points for all the arrays
        int i = arr1.size()-1, j = 0, k = 0;

        // Traverse both array
        while (i >= 0 && j < arr2.size()) {
            // Check if element at end of first array is less the first of second
            // Then increment accordingly
            if (arr1.get(i) > arr2.get(j)) {
                arr3.add(arr1.get(i));
                k++;
                i--;
            }
            else {
                arr3.add(arr2.get(j));
                k++;
                j++;
            }
            //System.out.print(arr3.toString() + "\n");
        }

        // Store remaining elements of first array
        while (i >= 0) {
            arr3.add(arr1.get(i));
            k++;
            i--;
        }

        // Store remaining elements of second array
        while (j < arr2.size()) {
            arr3.add(arr2.get(j));
            k++;
            j++;
        }
        System.out.println(toString(arr3));
    }

    //made a toString for printing one string per line
    public static String toString(ArrayList<Integer> tempArray) throws Exception {
        String temp = "";
        for (int i = 0; i < tempArray.size(); i++) {
            if (i == tempArray.size()-1)
                temp += tempArray.get(i);
            else
                temp += tempArray.get(i) + " ";
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {
        //for Some reason I always store in variables before passing
        String inFile0 = args[0];
        String inFile1 = args[1];

        //Sort the arrays, my two insertions are in the merge
        mergeSort(inFile0,inFile1);

    }

}
//String inFile = "C:\\Users\\Bluew\\IdeaProjects\\New Project\\src\\Test.txt";