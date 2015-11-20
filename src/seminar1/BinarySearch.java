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

    class element{
        int OriginalOrder;
        int value;
    }

    public static int binarySearch(int[] a, int x) throws Exception
    {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid; // Found
            }
        }
        throw new Exception(); // NOT_FOUND is defined as -1
    }

    public static Integer binarySearch(List<Integer> a, int x)
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
