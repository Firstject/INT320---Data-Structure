/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancesymbolchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author INT320
 */
public class BalanceSymbolChecker {
    
    private static final String file1 = "src/balancesymbolchecker/ExampleClass.java";
    private static final String file2 = "src/balancesymbolchecker/ExampleMissingOpenSym.java";
    private static final String file3 = "src/balancesymbolchecker/ExampleUnbalancedSym.java";
    
    public static String checkBalance(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        LinkedList<String> stack = new LinkedList();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            StringTokenizer stk = new StringTokenizer(line, "{}[]()<>", true);
            while (stk.hasMoreTokens()) {
                String token = stk.nextToken();
                if (isSymbol(token)) {
                    if (isOpenSymbol(token)) {
                        stack.push(token);
                    } else {
                        String top = stack.peek();
                        if (top == null) {
                            return "Missing open Symbol";
                        } else if (getValue(top) != getValue(token)){
                            return "Unbalanced symbol";
                        }
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return "Missing close symbol";
        }
        return "Balanced";
    }
    
    private static boolean isSymbol(String symbol) {
        switch (symbol) {
            case "[":
            case "]": 
            case "{":
            case "}": 
            case "(":
            case ")": 
            case "<":
            case ">": return true;
        }
        return false;
    }
    
    private static boolean isOpenSymbol(String symbol){
        switch (symbol) {
            case "[":
            case "{":
            case "(":
            case "<":
                return true;
        }
        return false;
    }
    
    private static int getValue(String symbol){
        switch (symbol) {
            case "[":
            case "]": 
                return 1;
                
            case "{":
            case "}": 
                return 2;
                
            case "(":
            case ")": 
                return 4;
                
            case "<":
            case ">": 
                return 8;
        }
        return -1;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        //File ExampleClass.java is balanced.
        System.out.println(checkBalance(file1));
        System.out.println(checkBalance(file2));
        System.out.println(checkBalance(file3));
    }
}
