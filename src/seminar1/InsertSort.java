package seminar1;

public class InsertSort
{

    public static void Sort(int[] list)
    {
        int j;

        for (int p = 1; p < list.length; p++) {
            int tmp = list[p];
            for (j = p; j > 0 && tmp < list[j - 1]; j--) {
                list[j] = list[j - 1];
            }
            list[j] = tmp;
        }
    }
}
