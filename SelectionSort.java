import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) throws Exception {
        //I guess I can just pass args but meh, i stored as inFile
        String inFile = args[0];
        // sort the array
        selectionSort(inFile);
    }

    private static void selectionSort(String file) throws Exception {
        File tempfile = new File(file);
        Scanner sc = new Scanner(tempfile);

        //create an Array to store Strings from text
        ArrayList<Integer> inputArray = new ArrayList<Integer>();

        //take in values according to parameters
        int intAdd;
        while (sc.hasNextInt()) {
            intAdd = sc.nextInt();
            inputArray.add(intAdd);
        }

        //This is where it finds min in the bounds of i-size()
        //As this progresses the i shifts to the right every loop
        //Changing the starting spot
        for (int i = 0; i < inputArray.size(); i++) {
            int min = i;
            int j = i + 1;
            for (; j < inputArray.size(); j++) {
                if (inputArray.get(j) < inputArray.get(min))
                    min = j;
            }

            //This swaps the minimum value to the first spot
            int newmin = inputArray.get(min);
            inputArray.set(min, inputArray.get(i));
            inputArray.set(i, newmin);
        }
        printArray(inputArray);
    }

    public static void printArray(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}


