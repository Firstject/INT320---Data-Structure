package int320midtermexam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.Test;
import sit.int320.midterm.MidtermExam;
import static org.junit.Assert.*;

/**
 *
 * @author Khaitong Lim
 */
public class InToPoTest {

    private static List<String> exp = new ArrayList();

    static {
        exp.add("A *    B + C");
        exp.add("A + B * C");
        exp.add("A * (B + C)");
        exp.add("A * (B + C * D) + E");
        exp.add("A * B + (C - D) + E");
        exp.add("A * B + C - (D + E)");
        exp.add("A * (B + C) - (D + E)");
        exp.add("A * ((B + C) - (D + E))");
        exp.add("(13.25 + 5)*2.1 - 12 % (4 + 8)");
        exp.add("13.25 + 5 * 2.1 - 12 % 4 + 8");
        exp.add("13.25 + 5 * (2.1 - 12) % 4 + 8");
        exp.add("13.25 + 5 * ((2.1 - 12) % 4 + 8)");
        exp.add("salary * ( y + value - ( a/b + c ) * d ) % ex");
        exp.add("Salary * (bonus + value) - ( a/b + c ) * d ) % extended");
        exp.add("salary * (bonus + value) - a / (b + c ) * d % extended");
        exp.add("A * (B + C) * D + E");
        exp.add("A * ((B + C) * D + E)");
        exp.add("A * ((B + C) * (D + E))");
        exp.add("A * B + C * (D + E)");
        exp.add("A * ((B + C) / (D + E))");
        exp.add("(((A * ((B + C) / (D + E)))))");
        exp.add("150 - 30 / 9 + 70 % 3 - 980 * (gpax + credit)");
        exp.add("(150 - 30) / 9 + 70 % 3 - 980 * (gpax + credit)");
        exp.add("150 - 30 / (9 + 70) % 3 - 980 * (gpax + credit)");
        exp.add("150 - 30 / 9 + 70 % (3 - 980) * (gpax + credit)");
        exp.add("(150 - 30 / 9 + 70) % 3 - 980 * (gpax + credit)");
        exp.add("((150 - 30) / (9 + 70)) % 3 - 980 * (gpax + credit)");
        exp.add("150 - 30 / 9 + 70 % 3 - 980 * (gpax + credit)");
        exp.add("150 - 30 / 9 + 70 % 3 - 980 * gpax + credit");
        exp.add("A*C+D-20/F");
    }

    /**
     * Test of infixToPostfix method, of class Midterm.
     */
    @Test
    public void testInfixToPostfix()  {
        System.out.println("infix To Postfix Expression Unit Test: ");

        int i = 1;
        Collections.shuffle(exp);
        for (String string : exp) {
            assertEquals(MidtermSolution.infixToPostfix(string), MidtermExam.infixToPostfix(string));
            System.out.printf("Case %3d: %s --> passed\n", i++, MidtermExam.infixToPostfix(string));
        }
    }

    private static class MidtermSolution {
        // A utility function to return precedence of a given operator 
        // Higher returned value means higher precedence 

        static int prec(String operator) {
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

        static boolean isOperator(String operator) {
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

        // The main method that converts given infix expression 
        // to postfix expression. 
        public static String infixToPostfix(String exp) {
            // initializing empty String for result 
            StringBuilder result = new StringBuilder(128);

            // initializing empty stack 
            LinkedList<String> stack = new LinkedList<>();

            StringTokenizer stk = new StringTokenizer(exp, " +-*/()", true);
            String token;
            while (stk.hasMoreElements()) {
                token = stk.nextToken();
                if (token.trim().length() == 0) {
                    continue; //do nothings for white space
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
                    while (!stack.isEmpty() && prec(token) <= prec(stack.peek())) {
                        result.append(" ");
                        result.append(stack.pop());
                    }
                    stack.push(token);
                }

            }

            // pop all the operators from the stack 
            while (!stack.isEmpty()) {
                result.append(" ");
                result.append(stack.pop());
            }
            System.out.println(result.toString().trim());
            return result.toString().trim();
        }
    }
}
