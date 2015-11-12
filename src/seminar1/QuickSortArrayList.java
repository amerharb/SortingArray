package seminar1;

import java.util.ArrayList;
import java.util.List;

public class QuickSortArrayList
{

    public static void sort(List<Integer> items)
    {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            Integer chosenItem = items.get(items.size() / 2);
            for (Integer i : items) {
                if (i < chosenItem) {
                    smaller.add(i);
                } else if (i > chosenItem) {
                    larger.add(i);
                } else {
                    same.add(i);
                }
            }

            sort(smaller); // Recursive call!
            sort(larger); // Recursive call!

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }
}
