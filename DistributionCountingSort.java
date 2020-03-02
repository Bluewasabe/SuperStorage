//Created by Christopher Hollowood

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DistributionCountingSort {

    static int[] countingSort(int counttotal, String file, int minvalue, int maxvalue) throws Exception {
        //change string to file and read it with scanner
        File tempfile = new File(file);
        Scanner sc = new Scanner(tempfile);

        //create an Array to store Strings from text
        List<Integer> inputArray = new ArrayList<Integer>();

        //take in values according to parameters
        int intAdd;
        while (sc.hasNextInt()) {
            intAdd = sc.nextInt();
            if (minvalue <= intAdd && intAdd <= maxvalue) {
                inputArray.add(intAdd);
            }
        }


        //System.out.println(inputArray.toString());
        //int len = inputArray.size();
        if (counttotal > inputArray.size())
            counttotal = inputArray.size();
        //System.out.println(counttotal);
        int[] sortedArray = new int[counttotal];

        int[] tempStorage = new int[maxvalue + 1];

        //temporary Storage after total value count
        for (int j = 0; j < counttotal; j++) {
            tempStorage[inputArray.get(j)] = tempStorage[inputArray.get(j)] + 1;
        }

        //temp storage after total value count
        for (int j = 1; j <= maxvalue; j++) {
            tempStorage[j] = tempStorage[j] + tempStorage[j - 1];
        }

        for (int j = counttotal - 1; j >= 0; j--) {
            //sorted array
            sortedArray[tempStorage[inputArray.get(j)] - 1] = inputArray.get(j);
            //temp storage
            tempStorage[inputArray.get(j)] = tempStorage[inputArray.get(j)] - 1;
        }
        printArray(sortedArray);
        return sortedArray;
    }

    //method for printing Array line by line
    static void printArray(int[] array) {
        //System.out.println();
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
        //System.out.println();
    }

    public static void main(String[] args) throws Exception {
        
        int count = Integer.parseInt(args[0]);
        //int count = 20; 
        //System.out.println(count);
        
        String inFile = args[1];
        
        int min = Integer.parseInt(args[2]);
        //int min = 1;
        //System.out.println(min);
        
        int max = Integer.parseInt(args[3]);
        //int max = 100;
        //System.out.println(max);  

        DistributionCountingSort Sort = new DistributionCountingSort();
        Sort.countingSort(count, inFile, min, max);
        //System.out.println("After Sorting Array");
        //printArray(sortedArray);
    }
}
