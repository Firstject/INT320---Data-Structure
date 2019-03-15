/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.midterm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class PositionList implements Comparable<PositionList> {
    int key;
    List <Integer> positions = new ArrayList();

    public PositionList(int key, int position) {
        this.key = key;
        this.positions.add(position);
    }

    public void addPosition(int position) {
        this.positions.add(position);
    }

    @Override
    public int compareTo(PositionList o) {
        int first = o.positions.size() - this.positions.size();
        if (first != 0) {
            return first;
        }
        return this.key - o.key;
    }
}

public class MidtermExam {

    private static int precedenceLevel(String operator) {
        switch (operator) {
            case "(":
            case ")":
                return 0;

            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
            case "%":
                return 2;
        }
        throw new RuntimeException("Invalid operator");
    }

    private static boolean isOperator(String operator) {
        switch (operator) {
            case "(":
            case ")":
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return true;
        }
        return false;
    }

    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder(128);
        StringTokenizer stk = new StringTokenizer(exp, " +(-/*%)", true);
        LinkedList<String> stack = new LinkedList();
        String token;
        while (stk.hasMoreElements()) {
            token = stk.nextToken();
            if (token.equals(" ")) {
                continue;
            } else if (!isOperator(token)) {
                result.append(" ");
                result.append(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    result.append(" ");
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedenceLevel(token) <= precedenceLevel(stack.peek())) {
                    result.append(" ");
                    result.append(stack.pop());
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            result.append(" ");
            result.append(stack.pop());
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        infixToPostfix("A +     (B - 2.59)");
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

    public static String getTopMostNumber(int[] numbers) {
        Map <Integer,PositionList> frequency = new HashMap();
        int key;
        for (int i = 0; i < numbers.length; i++) {
            key = numbers[i];
            if (frequency.get(key) == null){
                frequency.put(key, new PositionList(key, i));
            } else {
                frequency.get(key).addPosition(i);
            }
        }
        List <PositionList> list = new ArrayList(frequency.values());
        Collections.sort(list);
        PositionList posList = list.get(0);
        return posList.key + " (" + posList.positions.size() + ") : " + posList.positions;
    }

    public static Object[] arrayUnion(Object[] obj1, Object[] obj2) {
        return arrayUnion(obj1, obj2, null);
    }

    public static Object[] arrayUnion(Object[] obj1, Object[] obj2, Comparator c) {
        Set setA;
        if (c == null) {
            setA = new TreeSet();
        } else {
            setA = new TreeSet(c);
        }
        setA.addAll(Arrays.asList(obj1));
        setA.addAll(Arrays.asList(obj2));
        
        return setA.toArray();
    }

}
