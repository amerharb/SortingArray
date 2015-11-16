package seminar1;

public class MergeSort
{

    public static void mergeSort(int[] list)
    {
        int[] tmpArray = new int[list.length];
        mergeSort(list, tmpArray, 0, list.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmpArray, int left, int right)
    {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmpArray,
            int leftPos, int rightPos, int rightEnd)
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) // Copy rest of first half
        {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) // Copy rest of right half
        {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}
