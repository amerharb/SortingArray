/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amer
 */
public class Seminar1
{

    /**
     * @param args the command line arguments
     */
    static int[] numbers;
    static int[] numbers100 = new int[100];
    static int[] numbers10000 = new int[10000];
    static List<Integer> numbersList;
    static List<Integer> numbersList100;
    static List<Integer> numbersList10000;

    public static void main(String[] args)
    {
        StopWatch arraySW = new StopWatch();
        arraySW.start();
        readNumbers();
        arraySW.stop();
        long timeCreateNumberArray = arraySW.getPeriod();
        System.out.println("time of reading file & create the Arrays and list in nano is:" + timeCreateNumberArray);
        System.out.println("");

        StopWatch sortSW = new StopWatch();

         //int[] numbers2 = numbers.clone();
        //Sort 1M ArrayList
        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList);
        sortSW.stop();
        long timeOfSortingArrayUseArrayList = sortSW.getPeriod();
        System.out.println("Time of sorting the Arrya 1M using ArrayList :  " + timeOfSortingArrayUseArrayList);

        //Sort 10K ArrayList
        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList10000);
        sortSW.stop();
        long timeOfSortingArrayUseArrayList10000 = sortSW.getPeriod();
        System.out.println("Time of sorting the Arrya 10K using ArrayList:  " + timeOfSortingArrayUseArrayList10000);

        //Sort 100 ArrayList
        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList100);
        sortSW.stop();
        long timeOfSortingArrayUseArrayList100 = sortSW.getPeriod();
        System.out.println("Time of sorting the Arrya 100 using ArrayList:  " + timeOfSortingArrayUseArrayList100);

        //Sort 1M Array
        System.out.println("");
        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers);
        sortSW.stop();
        long timeOfSortingArray = sortSW.getPeriod();
        System.out.println("Time of sorting the Arrya 1M using just Array:  " + timeOfSortingArray);

        //Sort 10K Array
        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers10000);
        sortSW.stop();
        long timeOfSortingArray10000 = sortSW.getPeriod();
        System.out.println("Time of sorting the Arrya 10K using just Array: " + timeOfSortingArray10000);

        //Sort 100 Array
        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers100);
        sortSW.stop();
        long timeOfSortingArray100 = sortSW.getPeriod();
        System.out.println("Time of sorting the Arrya 100 using just Array: " + timeOfSortingArray100);

//        printArray(numbers);
        System.out.println("");
        sortSW.reset();
        sortSW.start();
        InsertSort.Sort(numbers);
        sortSW.stop();
        long timeOfInsertSortingArray = sortSW.getPeriod();
        System.out.println("Time of Insert sorting 1M the Arrya in nano is : " + timeOfInsertSortingArray);

        sortSW.reset();
        sortSW.start();
        InsertSort.Sort(numbers10000);
        sortSW.stop();
        long timeOfInsertSortingArray10000 = sortSW.getPeriod();
        System.out.println("Time of Insert sorting 10K the Arrya in nano is: " + timeOfInsertSortingArray10000);

        sortSW.reset();
        sortSW.start();
        InsertSort.Sort(numbers100);
        sortSW.stop();
        long timeOfInsertSortingArray100 = sortSW.getPeriod();
        System.out.println("Time of Insert sorting 1M the Arrya in nano is : " + timeOfInsertSortingArray100);
//        printArray(numbers);

//        sortSW.reset();
//        sortSW.start();
//        QuickSortMultiThread qsmt = new QuickSortMultiThread(numbers2);
//        
//        qsmt.run();
//        sortSW.stop();
//        long timeOfSortingArrayMultiThread = sortSW.getPeriod();
//        System.out.println("Time of sorting the arrya MultiThreads in nano is : " + timeOfSortingArrayMultiThread);
////        printArray(number2);
//        
//        //check if both array match
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] != numbers2[i]){
//                System.out.println("NO MACH there is error in sorting");
//                break;
//            }
//        }
        System.out.println("");
//        System.out.println("Array 1M  is faster by: " + (double) (timeOfSortingArrayUseArrayList) / timeOfSortingArray + " times");
//        System.out.println("Array 10K is faster by: " + (double) (timeOfSortingArrayUseArrayList10000) / timeOfSortingArray10000 + " times");
//        System.out.println("Array 100 is faster by: " + (double) (timeOfSortingArrayUseArrayList100) / timeOfSortingArray100 + " times");
    }

    private static void printArray(int[] items)
    {
        for (int i : items) {
            System.out.println(i);
        }
    }

    public static void readNumbers()
    {
        try {
            Scanner inFile = new Scanner(new File("numbers.txt"));
//            Scanner inFile = new Scanner(new File("numbers small.txt"));
            List<Integer> list = new ArrayList<Integer>();
            while (inFile.hasNextLine()) {
                String n = inFile.nextLine();
                list.add(new Integer(n));
            }

            numbersList = list;

            //fill arrayList of 100 eleiments
            if (numbersList.size() >= 10000) { //which mean its not a test
                numbersList100 = new ArrayList<Integer>();
                for (int i = 0; i < 100; i++) {
                    numbersList100.add(numbersList.get(i));
                }

                //fill arrayList of 10000 eleiments
                numbersList10000 = new ArrayList<Integer>();
                for (int i = 0; i < 10000; i++) {
                    numbersList10000.add(numbersList.get(i));
                }
            }

            numbers = new int[list.size()];

            int i = 0;
            for (Integer s : list) {
                numbers[i] = s.intValue();
                i++;
            }

            if (numbersList.size() >= 10000) { //which mean its not a test
                // array of 100 elemints
                System.arraycopy(numbers, 0, numbers100, 0, 100);

                // array of 10000 elemints
                System.arraycopy(numbers, 0, numbers10000, 0, 10000);
            }
            inFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
