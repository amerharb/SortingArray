package seminar1;

import java.util.ArrayList;
import java.util.List;

public class InsertSortArrayList
{

    public static void sort(List<Integer> items)
    {
        int j;
        for (int p = 1; p < items.size(); p++) {
            Integer tmp = items.get(p);
            for (j = p; j > 0 && tmp.compareTo(items.get(j - 1)) < 0; j--) {
                items.set(j, items.get(j - 1));
            }
            items.set(j, tmp);
        }
    }
}
