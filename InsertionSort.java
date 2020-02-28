//Created By Christopher Hollowood for Assignment 1

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class InsertionSort {

    public void Sort(int count, String file) throws Exception {

        //change string to file and read it with scanner
        File tempfile = new File(file);
        Scanner sc = new Scanner(tempfile);

        //create an Array to store Strings from text
        List<String> inputArray = new ArrayList<String>();

        //scan .txt and add Strings to List
        String stringAdd = "";
        while (sc.hasNextLine()) {
            stringAdd = sc.nextLine();
            inputArray.add(stringAdd);
        }

        //this was for error when input count was larger than available strings
        if (count > inputArray.size())
            count = inputArray.size();

        //This is the actual insertion sort
        for (int i = 1; i < count; i++) {
            String key = inputArray.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (key.compareTo(inputArray.get(j)) > 0) {
                    break;
                }
                inputArray.set(j + 1, inputArray.get(j));
                j--;
            }
            inputArray.set(j + 1, key);
        }
        System.out.print(toString(count, inputArray));
    }

    //made a toString for printing one string per line
    public String toString(int n, List<String> tempArray) {
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp += tempArray.get(i) + "\n";
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {

        //create a keyboard scanner
        //Scanner kb = new Scanner(System.in);
        //System.out.print("Enter the number of items to be sorted:");

        int count = Integer.parseInt(args[0]);
        //this prevents backslash errors
        //kb.useDelimiter("\n");
        //System.out.print("Enter input file path and name:");
        String inFile = args[1];


        //System.out.println("You entered: " + inFile);


        InsertionSort sort = new InsertionSort();
        sort.Sort(count, inFile);


    }




}

//for testing
//String inFile = "C:\\Users\\Bluew\\IdeaProjects\\New Project\\src\\Test1.txt";
//String inFile = "C:\Users\Bluew\IdeaProjects\New Project\src\Test1.txt";
        




