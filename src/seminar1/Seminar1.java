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
    static List<Integer> numbersList;

    public static void main(String[] args)
    {
        StopWatch arraySW = new StopWatch();
        arraySW.start();
        readNumbers();
        arraySW.stop();
        long timeCreateNumberArray = arraySW.getPeriod();
        System.out.println("time of reading file & create the array in nano is:" + timeCreateNumberArray);

        //int[] numbers2 = numbers.clone();

        StopWatch sortSW = new StopWatch();
        
        sortSW.reset();
        sortSW.start();
        QuickSortArrayList.sort(numbersList);
        sortSW.stop();
        long timeOfSortingArrayUseArrayList = sortSW.getPeriod();
        System.out.println("Time of sorting the arrya use ArrayList : " + timeOfSortingArrayUseArrayList);

        sortSW.reset();
        sortSW.start();
        QuickSort.sortInt(numbers);
        sortSW.stop();
        long timeOfSortingArray = sortSW.getPeriod();
        System.out.println("Time of sorting the arryause only array : " + timeOfSortingArray);

//        printArray(number2);
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
        System.out.println("Array is faster by: " + (double)(timeOfSortingArrayUseArrayList) / timeOfSortingArray + "times");
    }
    
    private static void printArray(int[] items){
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
