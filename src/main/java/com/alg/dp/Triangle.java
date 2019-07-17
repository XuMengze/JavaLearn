package com.alg.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class Triangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> firstRow = new ArrayList<>() {{
            add(2);
        }};
        ArrayList<Integer> secondRow = new ArrayList<>() {{
            add(3);
            add(4);
        }};
        ArrayList<Integer> thirdRow = new ArrayList<>() {{
            add(6);
            add(5);
            add(7);
        }};
        ArrayList<Integer> fourthRow = new ArrayList<>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        input.add(firstRow);
        input.add(secondRow);
        input.add(thirdRow);
        input.add(fourthRow);

        System.out.println(getMinSum(input));
    }

    static int getMinSum(ArrayList<ArrayList<Integer>> tree) {
        if (tree.size() == 0) {
            return 0;
        }
        if (tree.size() == 1) {
            return tree.get(0).get(0);
        }
        for (int i = 1; i < tree.size(); i++) {
            ListIterator<Integer> it = tree.get(i).listIterator();
            int index = 0;
            while (it.hasNext()) {
                int value = it.next();
                it.set(
                        Math.min(value + tree.get(i - 1).get(Math.min(index, tree.get(i - 1).size() - 1)),
                                value + tree.get(i - 1).get(Math.max(index - 1, 0))
                        )
                );
                index++;
            }
        }
        return tree.get(tree.size() - 1).stream().min(Comparator.comparingInt(i -> i)).orElse(-1);
    }
}
