
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INT320
 */
public class TestWordFrequency {
    public static void main(String[] args) {
        FrequencyCounter fc = new FrequencyCounter();
        try {
            fc.process("data.txt");
            System.out.println(fc);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
    }
}
