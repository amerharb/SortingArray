/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

import java.util.List;

/**
 *
 * @author Amer
 */
public class BinarySearch
{

    class element
    {

        int OriginalOrder;
        int value;
    }

    public static int binarySearch(int[] a, int x) 
    {
        element[] eList = new element[a.length];

        for (element e : eList) {
            int i = 0;
            e.value = a[i];
            e.OriginalOrder = i;
            i++;
        }
        
        sortElement(eList);
        
        return eList[binarySearchOrderedArray(eList, x)].OriginalOrder;
    }

    private static void sortElement(element[] items)
    {
        if (items.length > 1) {
            element[] tempSmaller = new element[items.length];
            element[] tempSame = new element[items.length];
            element[] tempLarger = new element[items.length];

            int smallerCounter = 0, sameCounter = 0, largerCounter = 0;
            
            element chosenItem = items[items.length / 2];
            for (int i = 0; i < items.length; i++) {
                if (items[i].value < chosenItem.value) {
                    tempSmaller[smallerCounter].value = items[i].value;
                    smallerCounter++;
                } else if (items[i].value > chosenItem.value) {
                    tempLarger[largerCounter] = items[i];
                    largerCounter++;
                } else {
                    tempSame[sameCounter] = items[i];
                    sameCounter++;
                }
            }
            
            element[] smaller = new element[smallerCounter];
            for (int i = 0; i < smallerCounter; i++) {
                smaller[i] = tempSmaller[i];
            }
            tempSmaller = null;
            
            element[] same = new element[sameCounter];
            for (int i = 0; i < sameCounter; i++) {
                same[i] = tempSame[i];
            }
            tempSame = null;
            
            element[] larger = new element[largerCounter];
            for (int i = 0; i < largerCounter; i++) {
                larger[i] = tempLarger[i];
            }
            tempLarger = null;
            
            sortElement(smaller); // Recursive call!
            sortElement(larger); // Recursive call!

            int x = 0;
            
            for (element i : smaller) {
                items[x] = i;
                x++;
            }
            smaller = null;
            
            for (element i : same) {
                items[x] = i;
                x++;
            }
            same = null;
            
            for (element i : larger) {
                items[x] = i;
                x++;
            }
            larger = null;

        }
    }

    private static int binarySearchOrderedArray(element[] a, int x)
    {

        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].value < x) {
                low = mid + 1;
            } else if (a[mid].value > x) {
                high = mid - 1;
            } else {
                return mid; // Found
            }
        }
        return -1; // NOT_FOUND is defined as -1
    }

    private static Integer binarySearch(List<Integer> a, int x)
    {

        int low = 0, high = a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a.get(mid).compareTo(x) < 0) {
                low = mid + 1;
            } else if (a.get(mid).compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid; // Found
            }
        }
        return null; // NOT_FOUND is defined as -1
    }

}
