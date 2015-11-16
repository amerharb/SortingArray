package seminar1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Seminar1
{

    static int[] numbers;
    static int[] numbers1M = new int[1000000];
    static int[] numbers100 = new int[100];
    static int[] numbers10K = new int[10000];

    static List<Integer> numbersList;
    static List<Integer> numbersList1M;
    static List<Integer> numbersList100;
    static List<Integer> numbersList10K;

    public static void main(String[] args)
    {
        StopWatch arraySW = new StopWatch();
        arraySW.start();
        readNumbers();
        arraySW.stop();
        System.out.println("time of reading file & create the Arrays and list in nano is:" + arraySW.getPeriod() + " = " + getTimed(arraySW.getPeriod()));
        System.out.println("");

        StopWatch sortSW = new StopWatch();

        //MergeSort Array
        System.out.println("");
        
        //MergeSort 100 just Array
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        sortSW.reset();
        sortSW.start();
        MergeSort.mergeSort(numbers100);
        sortSW.stop();
        System.out.println("Time of  MergeSorting, 100 Elemints using Just Array:  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //MergeSort 10K just Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        sortSW.reset();
        sortSW.start();
        MergeSort.mergeSort(numbers10K);
        sortSW.stop();
        System.out.println("Time of  MergeSorting, 10K Elemints using Just Array:  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //MergeSort 1M just Array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        sortSW.reset();
        sortSW.start();
        MergeSort.mergeSort(numbers1M);
        sortSW.stop();
        System.out.println("Time of  MergeSorting, 1M  Elemints using Just Array:  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        
        //QuickSort Array List
        System.out.println("");
        
        //Sort 100 ArrayList
        //fill arrayList of 100 eleiments
        numbersList100 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbersList100.add(numbersList.get(i));
        }

        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList100);
        sortSW.stop();
        System.out.println("Time of QuickSorting, 100 Elemints using ArrayList  :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));
        
        //QuickSort 10K ArrayList
        //fill arrayList of 10000 eleiments
        numbersList10K = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            numbersList10K.add(numbersList.get(i));
        }

        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList10K);
        sortSW.stop();
        System.out.println("Time of QuickSorting, 10K Elemints using ArrayList  :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //QuickSort  1M ArrayList
        numbersList1M = new ArrayList<Integer>();
        numbersList1M.addAll(numbersList);

        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList1M);
        sortSW.stop();
        System.out.println("Time of QuickSorting, 1M  Elemints using ArrayList  :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //Just Array
        System.out.println("");

        //QuickSort 100 Array
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers100);
        sortSW.stop();
        System.out.println("Time of QuickSorting, 100 Elemints using Just Array :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //QuickSort 10K Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers10K);
        sortSW.stop();
        System.out.println("Time of QuickSorting, 10K Elemints using Just Array :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //QuickSort 1M Array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers1M);
        sortSW.stop();
        System.out.println("Time of QuickSorting, 1M  Elemints using Just Array :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //Insertsorting ArrayList
        System.out.println("");

        //Sort 100 ArrayList
        //fill arrayList of 100 eleiments
        numbersList100 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbersList100.add(numbersList.get(i));
        }

        sortSW.reset();
        sortSW.start();
        InsertSortArrayList.sort(numbersList100);
        sortSW.stop();
        System.out.println("Time of InsertSorting, 100 Elemints using ArrayList :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //Sort 10K ArrayList
        //fill arrayList of 10000 eleiments
        numbersList10K = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            numbersList10K.add(numbersList.get(i));
        }

        sortSW.reset();
        sortSW.start();
        InsertSortArrayList.sort(numbersList10K);
        sortSW.stop();
        System.out.println("Time of InsertSorting, 10K Elemints using ArrayList :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //InsertSort 1M ArrayList
        numbersList1M = new ArrayList<Integer>();
        numbersList1M.addAll(numbersList);

        sortSW.reset();
        sortSW.start();
        InsertSortArrayList.sort(numbersList1M);
        sortSW.stop();
        System.out.println("Time of InsertSorting, 1M  Elemints using ArrayList :  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //InsertSort using just Array
        System.out.println("");

        //InsertSort 100 just Array
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        sortSW.reset();
        sortSW.start();
        InsertSort.sort(numbers100);
        sortSW.stop();
        System.out.println("Time of insertSorting, 100 Elemints using Just Array:  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //InsertSort 10K just Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        sortSW.reset();
        sortSW.start();
        InsertSort.sort(numbers10K);
        sortSW.stop();
        System.out.println("Time of insertSorting, 10K Elemints using Just Array:  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

        //InsertSort 1M just array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        sortSW.reset();
        sortSW.start();
        InsertSort.sort(numbers1M);
        sortSW.stop();
        System.out.println("Time of insertSorting, 1M  Elemints using Just Array:  " + sortSW.getPeriod() + " = " + getTimed(sortSW.getPeriod()));

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

    private static String getTimed(long value)
    {
        try {
            final long B = 1000000000;

            int hours = (int) (value / (B * 60 * 60));
            value -= hours * (B * 60 * 60);
            int min = (int) (value / (B * 60));
            value -= min * (B * 60);
            int sec = (int) (value / B);
            value -= sec * (B);
            int mil = (int) (value / 1000000);
            value -= mil * 1000000;

            String S = "";
            if (hours > 0) {
                S += hours + " hours ";
            }
            if (min > 0) {
                S += min + " min ";
            }
            if (mil <= 0) {
                S += sec + " sec";
            } else if (mil < 10) {
                S += sec + ".00" + mil + " sec";
            } else if (mil < 100) {
                S += sec + ".0" + mil + " sec";
            } else {
                S += sec + "." + mil + " sec";
            }

            return S;

        } catch (Exception e) {
            return "";
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

            numbers = new int[list.size()];

            int i = 0;
            for (Integer s : list) {
                numbers[i] = s.intValue();
                i++;
            }

            inFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
