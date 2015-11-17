package seminar1;

import java.util.ArrayList;
import java.util.List;

public class MergeSortArrayList
{

    public static void mergeSort(List<Integer> list)
    {
        List<Integer> tmpList = new ArrayList<>();
        tmpList.addAll(list);//to make it same size of List
        mergeSort(list, tmpList, 0, list.size() - 1);
    }

    private static void mergeSort(List<Integer> a, List<Integer> tmpList, int left, int right)
    {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpList, left, center);
            mergeSort(a, tmpList, center + 1, right);
            merge(a, tmpList, left, center + 1, right);
        }
    }

    private static void merge(List<Integer> a, List<Integer> tmpList,
            int leftPos, int rightPos, int rightEnd)
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a.get(leftPos).compareTo(a.get(rightPos)) <= 0) {
                tmpList.set(tmpPos++, a.get(leftPos++));
            } else {
                tmpList.set(tmpPos++, a.get(rightPos++));
            }
        }

        while (leftPos <= leftEnd) // Copy rest of first half
        {
            tmpList.set(tmpPos++, a.get(leftPos++));
        }

        while (rightPos <= rightEnd) // Copy rest of right half
        {
            tmpList.set(tmpPos++, a.get(rightPos++));
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a.set(rightEnd, tmpList.get(rightEnd));
        }
    }
}
