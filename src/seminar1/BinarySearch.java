/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

import java.util.ArrayList;
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

        public Element(int originalOrder, int value)
        {
            this.originalOrder = originalOrder;
            this.value = value;
        }
    }

    public static int[] goThrowSearch(int[] a, int x)
    {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] binarySearchUsingElements(int[] a, int x)
    {
        Element[] eList = new Element[a.length];

        for (int i = 0; i < eList.length; i++) {
            eList[i] = new Element(i, a[i]);
        }

        sortElement(eList);
        int FirstLoc = binarySearchFirstElementInOrderedArray(eList, x);
        int LastLoc = binarySearchLastElementInOrderedArray(eList, x);

        if (FirstLoc == -1 || LastLoc == -1) {
            return (new int[0]); // nothing found return array of zero elements
        } else {
            int[] results = new int[LastLoc - FirstLoc + 1];
            int j = 0;
            for (int i = FirstLoc; i < LastLoc + 1; i++) {
                results[j] = eList[i].originalOrder;
                j++;
            }
            return results;
        }
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

            for (Element e : smaller) {
                items[x] = e;
                x++;
            }
            smaller = null;

            for (Element e : same) {
                items[x] = e;
                x++;
            }
            same = null;

            for (Element e : larger) {
                items[x] = e;
                x++;
            }
            larger = null;

        }
    }

    private static int binarySearchFirstElementInOrderedArray(Element[] a, int x)
    {

        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].value < x) {
                low = mid + 1;
            } else if (a[mid].value > x) {
                high = mid - 1;
            } else {
                //Found, now we will go back to get first one with same value
                for (int i = mid - 1; i >= 0; i--) {
                    if (a[i].value == x) {
                        mid--;
                    } else {
                        return mid;
                    }
                }
                return mid; // Found
            }
        }
        return -1; // NOT_FOUND is defined as -1
    }

    private static int binarySearchLastElementInOrderedArray(Element[] a, int x)
    {

        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].value < x) {
                low = mid + 1;
            } else if (a[mid].value > x) {
                high = mid - 1;
            } else {
                //Found, now we will go Forward one by one to get last one with the same value
                for (int i = mid + 1; i < a.length; i++) {
                    if (a[i].value == x) {
                        mid++;
                    } else {
                        return mid;
                    }
                }
                return mid;
            }
        }
        return -1; // NOT_FOUND is defined as -1
    }

    static int binaryCounter = 0;

    public static void resetBinaryCounter()
    {
        binaryCounter = 0;
    }

    public static int getBinaryCounter()
    {
        return binaryCounter;
    }

    public static int binarySearch(int[] a, int x)
    {

        int low = 0, high = a.length - 1;

        while (low <= high) {
            binaryCounter++;
            int mid = (low + high) / 2;

            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid; //Found
            }
        }
        return -1; // NOT_FOUND is defined as -1
    }

    static int advBinaryCounter = 0;

    public static void resetAdvBinaryCounter()
    {
        advBinaryCounter = 0;
    }

    public static int getAdvBinaryCounter()
    {
        return advBinaryCounter;
    }

    public static int binarySearchAdv(int[] a, int x)
    {
        int low = 0, high = a.length - 1;

        if (x > a[high] || x < a[low]) {
            return -1; // NOT_FOUND
        }
        if (a[high] == a[low]) {
            // all array values are the same 
            if (x == a[low]) {
                return 0; //return the postion of first one
            } else {
                return -1; // value not found
            }
        }
        //TODO if low bigger than high then the array is not correctly sorted

        while (low <= high) {
            advBinaryCounter++; //count how many iteration it take to find the value
            int mid = (high * (x - a[low]) + low * (a[high] - x)) / (a[high] - a[low]);
            int mid2 = (int) ((double) (x - a[low]) / (a[high] - a[low]) * (high - low)) + low;
            if (mid != mid2) {
                System.out.println("STOP");
            }
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid; //Found
            }
            //mid = (low + high) / 2;
        }
        return -1; // NOT FOUND 
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
