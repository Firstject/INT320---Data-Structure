/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320midtermexam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;
import sit.int320.midterm.MidtermExam;

/**
 *
 * @author Khaitong Lim
 */
public class TestUnionArray {

    private static String[] data1 = new String[15];
    private static String[] data2 = new String[15];

    private static Comparator<String> compareIgnoreCase = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.toLowerCase().compareTo(o1.toLowerCase());
        }
    };

    @Test
    public void testUnionAndIntersection() {
        System.out.println("Array Union Unit Test: ");
        int count = 1;
        Random r = new Random();
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < data1.length; i++) {
                data1[i] = ((char) (r.nextInt(57) + 65)) + "";
                data2[i] = ((char) (r.nextInt(57) + 65)) + "";
            }
            String data3[] = new String[data1.length];
            System.arraycopy(data1, 0, data3, 0, data1.length);

            String data4[] = new String[data2.length];
            System.arraycopy(data2, 0, data4, 0, data2.length);

            Object[] result = MidtermExam.arrayUnion(data1, data2);
            //Object[] result = Midterm.arrayIntersection(data1, data2);
            Arrays.sort(result);
            
            Object[] expected1 = arrayUnion(data1, data2);
            //Object[] expected1 = arrayIntersection(data1, data2);
            assertEquals(expected1, result);

            Object[] result2 = MidtermExam.arrayUnion(data3, data4, compareIgnoreCase);
            //Object[] result2 = Midterm.arrayIntersection(data3, data4, compareIgnoreCase);
            String[] finalResult = new String[result2.length];
            System.arraycopy(result2, 0, finalResult, 0, result2.length);
            Arrays.sort(finalResult, compareIgnoreCase);

            Object[] expected2 = arrayUnion(data3, data4, compareIgnoreCase);
            //Object[] expected2 = arrayIntersection(data3, data4, compareIgnoreCase);
            assertEquals(expected2, finalResult);

            //System.out.println(Arrays.toString(result2));
            System.out.printf("Case %3d:\n%s\n%s\n--> passed\n", count++, Arrays.toString(expected1), Arrays.toString(expected2));
        }
    }

    private static Object[] arrayIntersection(Object[] obj1, Object[] obj2) {
        return arrayIntersection(obj1, obj2, null);
    }

    private static Object[] arrayIntersection(Object[] obj1, Object[] obj2, Comparator c) {
        Set a, b;
        if (c != null) {
            a = new TreeSet(c);
            b = new TreeSet(c);
        } else {
            a = new TreeSet();
            b = new TreeSet();
        }
        for (Object object : obj1) {
            a.add(object);
        }
        for (Object object : obj2) {
            b.add(object);
        }
        a.retainAll(b);
        return a.toArray();
    }

    private static Object[] arrayUnion(Object[] obj1, Object[] obj2) {
        return arrayUnion(obj1, obj2, null);
    }

    private static Object[] arrayUnion(Object[] obj1, Object[] obj2, Comparator c) {
        Set a, b;
        if (c != null) {
            a = new TreeSet(c);
            b = new TreeSet(c);
        } else {
            a = new TreeSet();
            b = new TreeSet();
        }
        for (Object object : obj1) {
            a.add(object);
        }
        for (Object object : obj2) {
            b.add(object);
        }
        a.addAll(b);
        return a.toArray();
    }
}
