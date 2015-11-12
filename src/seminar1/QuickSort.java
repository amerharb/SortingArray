/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

public class QuickSort
{

    public static void sortInt(int[] items)
    {
        if (items.length > 1) {
            int[] tempSmaller = new int[items.length];
            int[] tempSame = new int[items.length];
            int[] tempLarger = new int[items.length];

            int smallerCounter = 0, sameCounter = 0, largerCounter = 0;
            
            int chosenItem = items[items.length / 2];
            for (int i = 0; i < items.length; i++) {
                if (items[i] < chosenItem) {
                    tempSmaller[smallerCounter] = items[i];
                    smallerCounter++;
                } else if (items[i] > chosenItem) {
                    tempLarger[largerCounter] = items[i];
                    largerCounter++;
                } else {
                    tempSame[sameCounter] = items[i];
                    sameCounter++;
                }
            }
            
            int[] smaller = new int[smallerCounter];
            for (int i = 0; i < smallerCounter; i++) {
                smaller[i] = tempSmaller[i];
            }
            tempSmaller = null;
            
            int[] same = new int[sameCounter];
            for (int i = 0; i < sameCounter; i++) {
                same[i] = tempSame[i];
            }
            tempSame = null;
            
            int[] larger = new int[largerCounter];
            for (int i = 0; i < largerCounter; i++) {
                larger[i] = tempLarger[i];
            }
            tempLarger = null;
            
            sortInt(smaller); // Recursive call!
            sortInt(larger); // Recursive call!

            int x = 0;
            
            for (int i : smaller) {
                items[x] = i;
                x++;
            }
            smaller = null;
            
            for (int i : same) {
                items[x] = i;
                x++;
            }
            same = null;
            
            for (int i : larger) {
                items[x] = i;
                x++;
            }
            larger = null;

        }
    }

    private void copyArray(int[] sourceArr, int[] targetArr, int numberOfElements){

    }

}
