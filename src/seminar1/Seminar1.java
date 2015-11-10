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
    
    public static void main(String[] args)
    {
        StopWatch arraySW = new StopWatch();
        arraySW.start();
        readNumbers();
        arraySW.stop();
        long timeCreateNumberArray = arraySW.getPeriod();
        System.out.println("time of create the array in nano is :" + timeCreateNumberArray);

        
//        for (int i : numbers) {
//            System.out.println(i);
//        }

        StopWatch sortSW = new StopWatch();
        sortSW.start();
        QuickSort.sortInt(numbers);
        sortSW.stop();
        long timeOfSortingArray = sortSW.getPeriod();
        System.out.println("Time of sorting the arrya in nano is : " + timeOfSortingArray);

        for (int i : numbers) {
            System.out.println(i);
        }
              
    }

    public static void readNumbers()
    {

        try {
            Scanner inFile = new Scanner(new File("numbers.txt"));
            List<Integer> list = new ArrayList<Integer>();
            while (inFile.hasNextLine()) {
                String n = inFile.nextLine();
                list.add(new Integer(n));
            }
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
