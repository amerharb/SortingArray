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

    static class Element
    {
        final int originalOrder;
        final int value;
        public Element(int originalOrder, int value){
            this.originalOrder = originalOrder;
            this.value = value;
        }
    }

    public static int binarySearch(int[] a, int x) 
    {
        Element[] eList = new Element[a.length];

        int i = 0;
        for (Element e : eList) {
            e = new Element(i, a[i]);
            i++;
        }
        
        sortElement(eList);
        
        return eList[binarySearchOrderedArray(eList, x)].OriginalOrder;
    }

    private static void sortElement(Element[] items)
    {
        if (items.length > 1) {
            Element[] tempSmaller = new Element[items.length];
            Element[] tempSame = new Element[items.length];
            Element[] tempLarger = new Element[items.length];

            int smallerCounter = 0, sameCounter = 0, largerCounter = 0;
            
            Element chosenItem = items[items.length / 2];
            for (int i = 0; i < items.length; i++) {
                if (items[i].value < chosenItem.value) {
                    tempSmaller[smallerCounter] = items[i];
                    smallerCounter++;
                } else if (items[i].value > chosenItem.value) {
                    tempLarger[largerCounter] = items[i];
                    largerCounter++;
                } else {
                    tempSame[sameCounter] = items[i];
                    sameCounter++;
                }
            }
            
            Element[] smaller = new Element[smallerCounter];
            for (int i = 0; i < smallerCounter; i++) {
                smaller[i] = tempSmaller[i];
            }
            tempSmaller = null;
            
            Element[] same = new Element[sameCounter];
            for (int i = 0; i < sameCounter; i++) {
                same[i] = tempSame[i];
            }
            tempSame = null;
            
            Element[] larger = new Element[largerCounter];
            for (int i = 0; i < largerCounter; i++) {
                larger[i] = tempLarger[i];
            }
            tempLarger = null;
            
            sortElement(smaller); // Recursive call!
            sortElement(larger); // Recursive call!

            int x = 0;
            
            for (Element i : smaller) {
                items[x] = i;
                x++;
            }
            smaller = null;
            
            for (Element i : same) {
                items[x] = i;
                x++;
            }
            same = null;
            
            for (Element i : larger) {
                items[x] = i;
                x++;
            }
            larger = null;

        }
    }

    private static int binarySearchOrderedArray(Element[] a, int x)
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
