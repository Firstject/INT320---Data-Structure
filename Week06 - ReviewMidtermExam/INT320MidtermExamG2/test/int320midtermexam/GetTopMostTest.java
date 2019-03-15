/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320midtermexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sit.int320.midterm.MidtermExam;

/**
 *
 * @author Khaitong Lim
 */
public class GetTopMostTest {

    @Test
    public void getTopMostResultTest() {
        System.out.println("get Top Most Number (Max) Unit Test: ");
        Random r = new Random();
        int x[] = new int[37];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < x.length; j++) {
                x[j] = r.nextInt(27);
            }

            String result = getTopMostNumberSolutionMin(x);
            printMost(x, result);
            assertEquals(result, MidtermExam.getTopMostNumber(x));
            System.out.printf("Case %3d: %s (passed)\n", (i + 1), MidtermExam.getTopMostNumber(x));
            System.out.println("-----------");
        }
    }

    private static String getTopMostNumberSolution(int[] numbers) {
        Map<Integer, List<Integer>> result = new HashMap();
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            number = numbers[i];
            if (result.get(number) == null) {
                List<Integer> value = new LinkedList();
                value.add(i);
                result.put(number, value);
            } else {
                result.get(number).add(i);
            }
        }
        List<Map.Entry<Integer, List>> temp = new ArrayList(result.entrySet());
        Collections.sort(temp, new ListSizeComparator());
        Map.Entry<Integer, List> entry = temp.get(0);
        return entry.getKey() + " (" + entry.getValue().size() + ") : " + entry.getValue();
    }

    private void printMost(int[] numbers, String result) {
        String  str = result.substring(0, result.indexOf(" "));
        System.out.println("str = "+ str);
        int x = Integer.valueOf(str);
        System.out.print("[");
        for (int i : numbers) {
            if (i == x) {
                System.out.printf("  *%d*  ", i);
            } else {
                System.out.printf("%3d", i);
            }
        }
        System.out.println(" ]");
    }

    private static class ListOfPos implements Comparable<ListOfPos> {

        private int key;

        public int getKey() {
            return key;
        }
        private List<Integer> position = new LinkedList<>();

        public ListOfPos(int key, int pos) {
            this.key = key;
            position.add(pos);
        }

        public void addPos(int pos) {
            position.add(pos);
        }

        @Override
        public int compareTo(ListOfPos o) {
            int first = -(this.position.size() - o.position.size());
            if (first == 0) {
                return this.key - o.key;
            }
            return first;
        }
    }

    private static String getTopMostNumberSolutionMin(int[] numbers) {
        Map<Integer, ListOfPos> result = new HashMap();
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            number = numbers[i];
            if (result.get(number) == null) {
                result.put(number, new ListOfPos(number, i));
            } else {
                result.get(number).addPos(i);
            }
        }
        List<ListOfPos> temp = new ArrayList(result.values());
        Collections.sort(temp);
//        for (ListOfPos listOfPos : temp) {
//            System.out.println(listOfPos.key + " ("+ listOfPos.position.size()+") : "+ listOfPos.position );
//        }
        return temp.get(0).key + " (" + temp.get(0).position.size() + ") : " + temp.get(0).position;
    }

    private static class ListSizeComparator implements Comparator<Map.Entry<Integer, List>> {

        @Override
        public int compare(Map.Entry<Integer, List> o1, Map.Entry<Integer, List> o2) {
            int first = o2.getValue().size() - o1.getValue().size();
            if (first == 0) {
                return o2.getKey() - o1.getKey();
            }
            return first;
        }
    }
}
