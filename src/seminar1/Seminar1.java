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

    static StopWatch SW = new StopWatch();

    static class periods
    {

        static long InsertSort100;
        static long InsertSort10K;
        static long InsertSort1M;
        static long InsertSortArrayList100;
        static long InsertSortArrayList10K;
        static long InsertSortArrayList1M;
        static long MergeSort100;
        static long MergeSort10K;
        static long MergeSort1M;
        static long MergeSortIterative100;
        static long MergeSortIterative10K;
        static long MergeSortIterative1M;
        static long MergeSortArrayList100;
        static long MergeSortArrayList10K;
        static long MergeSortArrayList1M;
        static long QuickSort100;
        static long QuickSort10K;
        static long QuickSort1M;
        static long QuickSortMT100;
        static long QuickSortMT10K;
        static long QuickSortMT1M;
        static long QuickSortArrayList100;
        static long QuickSortArrayList10K;
        static long QuickSortArrayList1M;
    }

    public static void main(String[] args) throws Exception
    {
        SW.reset();
        SW.start();
        readNumbers();
        SW.stop();
        System.out.println("time of reading file & create the Arrays and list in nano is:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));
        System.out.println("");

        while (true) {
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Select Operation You want to Test");
            System.out.println("U- Search all value S- Search, I- insertSort, M- mergeSort, Q- quickSort, A- All Sort");
            //System.out.println("H- 100 elements only, K- 10 000 elements only, M- 1 000 000 elements only");
            //System.out.println("L- use only ArrayList, R- use only Array");

            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print(">");

            String ans = sc.nextLine();
            ans = ans.toUpperCase();

            if (ans.contains("EXIT")) {
                break;
            }
            if (ans.contains("T")) {
                System.out.println("TEST TEST TEST");
                System.out.println("");
                System.arraycopy(numbers, 0, numbers1M, 0, 1000000);
                QuickSort.sortInt(numbers1M);
                for (int i = 0; i <= 100; i++) {
                    BinarySearch.resetBinaryCounter();
                    BinarySearch.binarySearch(numbers1M, i);
                    BinarySearch.resetAdvBinaryCounter();
                    BinarySearch.binarySearchAdv(numbers1M, i);
                    if (BinarySearch.binaryCounter < BinarySearch.advBinaryCounter) {
                        System.out.println("normal is faster than adv at this value : " + i);
                    }
                }

                //int[] a = {2, 2, 3, 4, 5, 6, 6, 6, 7, 15, 16, 34, 36, 37, 38, 41, 50, 51, 55, 55};
                int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 98, 99};
                BinarySearch.resetBinaryCounter();
                BinarySearch.binarySearch(a, 2);
                System.out.println(BinarySearch.getBinaryCounter());
                BinarySearch.resetAdvBinaryCounter();
                BinarySearch.binarySearchAdv(a, 2);
                System.out.println(BinarySearch.getAdvBinaryCounter());

            }
            if (ans.contains("U")) {
                System.out.println("search all value will take some time");
                System.out.println("");
                ultimateBinarySearch();
            }
            if (ans.contains("S")) {
                while (true) {
                    System.out.println("Enter the value you want to search for? (type Exit to go main menu)");
                    System.out.print("Value?>");
                    String SValue = sc.nextLine();
                    SValue = SValue.toUpperCase();
                    if (SValue.contains("EXIT")) {
                        break;
                    }
                    int value = Integer.valueOf(SValue);

                    //Go Throw Search
                    //goThrowSearch(value);
                    //Binary Search
                    binarySearch(value);
                }
            }
            if (ans.contains("M") || ans.contains("A")) {
                //MergeSort ArrayList
                mergeSortArrayList();
                if (isArrayListSorted(numbersList100) && isArrayListSorted(numbersList10K) && isArrayListSorted(numbersList1M)) {
                    System.out.println("Arrays Checked, they are Sorted Correctly");
                } else {
                    System.out.println("Mistake in Sorting, problem in Sorting");
                }

                //MergeSort Array
                mergeSortJustArray();
                if (isArraySorted(numbers100) && isArraySorted(numbers10K) && isArraySorted(numbers1M)) {
                    System.out.println("Arrays Checked, they are Sorted Correctly");
                } else {
                    System.out.println("Mistake in Sorting, problem in Sorting");
                }

                //MergeSort Array Iterative
                mergeSortJustArrayIterative();
                if (isArraySorted(numbers100) && isArraySorted(numbers10K) && isArraySorted(numbers1M)) {
                    System.out.println("Arrays Checked, they are Sorted Correctly");
                } else {
                    System.out.println("Mistake in Sorting, problem in Sorting");
                }
            }

            if (ans.contains("Q") || ans.contains("A")) {
                //QuickSort Array List
                quickSortArrayList();
                if (isArrayListSorted(numbersList100) && isArrayListSorted(numbersList10K) && isArrayListSorted(numbersList1M)) {
                    System.out.println("ArrayLists Checked, they are Sorted Correctly");
                } else {
                    System.out.println("Mistake in Sorting, problem in Sorting");
                }

                //QuickSort Just Array
                quickSortJustArray();
                if (isArraySorted(numbers100) && isArraySorted(numbers10K) && isArraySorted(numbers1M)) {
                    System.out.println("Sorted");
                } else {
                    System.out.println("Not Sorted");
                }

                //QuickSort Just Array Multi Threads
                quickSortArrayMultiThreads();
                if (isArrayListSorted(numbersList100) && isArrayListSorted(numbersList10K) && isArrayListSorted(numbersList1M)) {
                    System.out.println("Arrays Checked, they are Sorted Correctly");
                } else {
                    System.out.println("Mistake in Sorting, problem in Sorting");
                }

            }

            if (ans.contains("I") || ans.contains("A")) {
                //Insertsorting ArrayList
                insertSortingArrayList();
                if (isArrayListSorted(numbersList100) && isArrayListSorted(numbersList10K) && isArrayListSorted(numbersList1M)) {
                    System.out.println("Arrays Checked, they are Sorted Correctly");
                } else {
                    System.out.println("Mistake in Sorting, problem in Sorting");
                }

                //InsertSort using just Array
                insertSortingJustArray();
            }
        }

        System.out.println("Good Bye!");
//        System.out.println("");
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
            int secPart = (int) (value / 100000);
            value -= secPart * 100000;

            String S = "";
            if (hours > 0) {
                S += hours + " hours ";
            }
            if (min > 0) {
                S += min + " min ";
            }
            if (secPart <= 0) {
                S += sec + " sec";
            } else if (secPart < 10) {
                S += sec + ".000" + secPart + " sec";
            } else if (secPart < 100) {
                S += sec + ".00" + secPart + " sec";
            } else if (secPart < 1000) {
                S += sec + ".0" + secPart + " sec";
            } else {
                S += sec + "." + secPart + " sec";
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

    private static void goThrowSearch(int value)
    {
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        SW.reset();
        SW.start();
        int[] loc1 = BinarySearch.goThrowSearch(numbers1M, value);
        SW.stop();
        System.out.println("has been found in " + loc1.length + " Locations:");
        for (int l : loc1) {
            System.out.print(l + ", ");
        }
        System.out.println("");
        System.out.println("Time of GoThro Search, 1M Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));
    }

    private static void ultimateBinarySearch()
    {
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        //sort array using quick
        QuickSort.sortInt(numbers1M);
        BinarySearch.resetBinaryCounter();
        SW.reset();
        SW.start();
        for (int i = 0; i <= 100; i++) {
            if (BinarySearch.binarySearch(numbers1M, i) == -1) {
                System.out.println("ERROR");
            }
        }
        SW.stop();
        System.out.println("itiration Counter for normal Binary Sort: " + BinarySearch.getBinaryCounter());
        System.out.println("Time of Binary search, 1M Elemints:    " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        System.out.println("");
        BinarySearch.resetAdvBinaryCounter();
        SW.reset();
        SW.start();
        for (int i = 0; i <= 100; i++) {
            if (BinarySearch.binarySearchAdv(numbers1M, i) == -1) {
                System.out.println("ERROR value not found");
            }
        }
        SW.stop();
        System.out.println("itiration Counter for Adv binary Sort: " + BinarySearch.getAdvBinaryCounter());
        System.out.println("Time of Adv Binary search, 1M Elemints:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));
    }

    private static void binarySearch(int value)
    {

        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);
        //test
//        numbers1M = new int[1000000];
//        for (int i = 0; i < 1000000; i++) {
//            numbers1M[i] = (int) (Math.random() * 10000);
//        }
        //sort array using quick
        QuickSort.sortInt(numbers1M);
        int l, firstL, lastL;

        System.out.println("");
        SW.reset();
        SW.start();
        l = BinarySearch.binarySearch(numbers1M, value);
        SW.stop();
        System.out.println("the location is: " + l);
        System.out.println("Time of Binary search, 1M Elemints:    " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));
        firstL = BinarySearch.getFirst(numbers1M, l);
        lastL = BinarySearch.getLast(numbers1M, l);
        System.out.println("First found at : " + firstL);
        System.out.println("Last found at  : " + lastL);

        System.out.println("");
        SW.reset();
        SW.start();
        l = BinarySearch.binarySearchAdv(numbers1M, value);
        SW.stop();
        System.out.println("the location is: " + l);
        System.out.println("Time of Adv Binary search, 1M Elemints:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));
        firstL = BinarySearch.getFirst(numbers1M, l);
        lastL = BinarySearch.getLast(numbers1M, l);
        System.out.println("First found at : " + firstL);
        System.out.println("Last found at  : " + lastL);

    }

    private static void mergeSortArrayList()
    {
        System.out.println("");

        //MergeSort 100 ArrayList 
        //fill arrayList of 100 eleiments
        numbersList100 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbersList100.add(numbersList.get(i));
        }

        SW.reset();
        SW.start();
        MergeSortArrayList.mergeSort(numbersList100);
        SW.stop();
        periods.MergeSortArrayList100 = SW.getPeriod();
        System.out.println("Time of MergeSorting, 100 Elemints using ArrayList  :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //MergeSort 10K ArrayList
        //fill arrayList of 10000 eleiments
        numbersList10K = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            numbersList10K.add(numbersList.get(i));
        }

        SW.reset();
        SW.start();
        MergeSortArrayList.mergeSort(numbersList10K);
        SW.stop();
        periods.MergeSortArrayList10K = SW.getPeriod();
        System.out.println("Time of MergeSorting, 10K Elemints using ArrayList  :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort  1M ArrayList
        numbersList1M = new ArrayList<Integer>();
        numbersList1M.addAll(numbersList);

        SW.reset();
        SW.start();
        MergeSortArrayList.mergeSort(numbersList1M);
        SW.stop();
        periods.MergeSortArrayList1M = SW.getPeriod();
        System.out.println("Time of MergeSorting, 1M  Elemints using ArrayList  :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void mergeSortJustArray()
    {
        System.out.println("");

        //MergeSort 100 just Array
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        SW.reset();
        SW.start();
        MergeSort.mergeSort(numbers100);
        SW.stop();
        periods.MergeSort100 = SW.getPeriod();
        System.out.println("Time of MergeSorting, 100 Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //MergeSort 10K just Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        SW.reset();
        SW.start();
        MergeSort.mergeSort(numbers10K);
        SW.stop();
        periods.MergeSort10K = SW.getPeriod();
        System.out.println("Time of MergeSorting, 10K Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //MergeSort 1M just Array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        SW.reset();
        SW.start();
        MergeSort.mergeSort(numbers1M);
        SW.stop();
        periods.MergeSort1M = SW.getPeriod();
        System.out.println("Time of MergeSorting, 1M  Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void mergeSortJustArrayIterative()
    {
        System.out.println("");

        //MergeSort 100 just Array Iterative
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        SW.reset();
        SW.start();
        MergeSortIterative.iterativeMergeSort(numbers100);
        SW.stop();
        periods.MergeSortIterative100 = SW.getPeriod();
        System.out.println("Time of MergeSorting Iterative, 100 Elemints using Just Array:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));
        if(!isArraySorted(numbers100)){
            System.out.println("misteke");
        }
        
        //MergeSort 10K just Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        SW.reset();
        SW.start();
        MergeSortIterative.iterativeMergeSort(numbers10K);
        SW.stop();
        periods.MergeSortIterative10K = SW.getPeriod();
        System.out.println("Time of MergeSorting Iterative, 10K Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //MergeSort 1M just Array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        SW.reset();
        SW.start();
        MergeSortIterative.iterativeMergeSort(numbers1M);
        SW.stop();
        periods.MergeSortIterative1M = SW.getPeriod();
        System.out.println("Time of MergeSorting Iterative, 1M  Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void quickSortArrayMultiThreads()
    {
        System.out.println("");

        //QuickSort 100 Array MultiThread
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        SW.reset();
        SW.start();
        QuickSortMultiThread qsmt = new QuickSortMultiThread(numbers100);
        qsmt.run();
        SW.stop();
        periods.QuickSortMT100 = SW.getPeriod();
        System.out.println("Time of QuickSorting MT, 100 Elemints using Just Array:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort 10K Array MultiThread
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        SW.reset();
        SW.start();
        qsmt = new QuickSortMultiThread(numbers10K);
        qsmt.run();
        SW.stop();
        periods.QuickSortMT10K = SW.getPeriod();
        System.out.println("Time of QuickSorting MT, 10K Elemints using Just Array:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort 1M Array MultiThread
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        SW.reset();
        SW.start();
        qsmt = new QuickSortMultiThread(numbers1M);
        qsmt.run();
        SW.stop();
        periods.QuickSortMT10K = SW.getPeriod();
        System.out.println("Time of QuickSorting MT, 1M  Elemints using Just Array:" + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void quickSortArrayList()
    {
        System.out.println("");

        //Sort 100 ArrayList
        //fill arrayList of 100 eleiments
        numbersList100 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbersList100.add(numbersList.get(i));
        }

        SW.reset();
        SW.start();
        QuickSortArrayList.sort(numbersList100);
        SW.stop();
        periods.QuickSortArrayList100 = SW.getPeriod();
        System.out.println("Time of QuickSorting, 100 Elemints using ArrayList  :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort 10K ArrayList
        //fill arrayList of 10000 eleiments
        numbersList10K = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            numbersList10K.add(numbersList.get(i));
        }

        SW.reset();
        SW.start();
        QuickSortArrayList.sort(numbersList10K);
        SW.stop();
        periods.QuickSort10K = SW.getPeriod();
        System.out.println("Time of QuickSorting, 10K Elemints using ArrayList  :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort  1M ArrayList
        numbersList1M = new ArrayList<Integer>();
        numbersList1M.addAll(numbersList);

        SW.reset();
        SW.start();
        QuickSortArrayList.sort(numbersList1M);
        SW.stop();
        periods.QuickSort1M = SW.getPeriod();
        System.out.println("Time of QuickSorting, 1M  Elemints using ArrayList  :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void quickSortJustArray()
    {
        System.out.println("");

        //QuickSort 100 Array
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        SW.reset();
        SW.start();
        QuickSort.sortInt(numbers100);
        SW.stop();
        periods.QuickSort100 = SW.getPeriod();
        System.out.println("Time of QuickSorting, 100 Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort 10K Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        SW.reset();
        SW.start();
        QuickSort.sortInt(numbers10K);
        SW.stop();
        periods.QuickSort10K = SW.getPeriod();
        System.out.println("Time of QuickSorting, 10K Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //QuickSort 1M Array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        SW.reset();
        SW.start();
        QuickSort.sortInt(numbers1M);
        SW.stop();
        periods.QuickSort1M = SW.getPeriod();
        System.out.println("Time of QuickSorting, 1M  Elemints using Just Array :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void insertSortingArrayList()
    {
        System.out.println("");

        //Sort 100 ArrayList
        //fill arrayList of 100 eleiments
        numbersList100 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbersList100.add(numbersList.get(i));
        }

        SW.reset();
        SW.start();
        InsertSortArrayList.sort(numbersList100);
        SW.stop();
        periods.InsertSortArrayList100 = SW.getPeriod();
        System.out.println("Time of InsertSorting, 100 Elemints using ArrayList :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //Sort 10K ArrayList
        //fill arrayList of 10000 eleiments
        numbersList10K = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            numbersList10K.add(numbersList.get(i));
        }

        SW.reset();
        SW.start();
        InsertSortArrayList.sort(numbersList10K);
        SW.stop();
        periods.InsertSortArrayList10K = SW.getPeriod();
        System.out.println("Time of InsertSorting, 10K Elemints using ArrayList :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //InsertSort 1M ArrayList
        numbersList1M = new ArrayList<Integer>();
        numbersList1M.addAll(numbersList);

        SW.reset();
        SW.start();
        InsertSortArrayList.sort(numbersList1M);
        SW.stop();
        periods.InsertSortArrayList1M = SW.getPeriod();
        System.out.println("Time of InsertSorting, 1M  Elemints using ArrayList :  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static void insertSortingJustArray()
    {
        System.out.println("");

        //InsertSort 100 just Array
        System.arraycopy(numbers, 0, numbers100, 0, 100);

        SW.reset();
        SW.start();
        InsertSort.sort(numbers100);
        SW.stop();
        periods.InsertSort100 = SW.getPeriod();
        System.out.println("Time of insertSorting, 100 Elemints using Just Array:  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //InsertSort 10K just Array
        System.arraycopy(numbers, 0, numbers10K, 0, 10000);

        SW.reset();
        SW.start();
        InsertSort.sort(numbers10K);
        SW.stop();
        periods.InsertSort10K = SW.getPeriod();
        System.out.println("Time of insertSorting, 10K Elemints using Just Array:  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

        //InsertSort 1M just array
        System.arraycopy(numbers, 0, numbers1M, 0, 1000000);

        SW.reset();
        SW.start();
        InsertSort.sort(numbers1M);
        SW.stop();
        periods.InsertSort1M = SW.getPeriod();
        System.out.println("Time of insertSorting, 1M  Elemints using Just Array:  " + SW.getPeriod() + " = " + getTimed(SW.getPeriod()));

    }

    private static boolean isArraySorted(int[] list)
    {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i + 1] < list[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isArrayListSorted(List<Integer> list)
    {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                return false;
            }
        }
        return true;
    }

}
