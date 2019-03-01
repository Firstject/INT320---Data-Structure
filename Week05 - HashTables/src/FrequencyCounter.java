
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INT320
 */
public class FrequencyCounter {
    Map<String, WordFrequency> frequency;

    public FrequencyCounter() {
        frequency = new HashMap(125);
    }
    
    public void process(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            StringTokenizer stk = new StringTokenizer(line, " .:,()*-/\\1234567890");
            while(stk.hasMoreElements()) {
                String word = stk.nextToken().toLowerCase();
                if (frequency.get(word) == null) {
                    frequency.put(word, new WordFrequency(word));
                } else {
                    frequency.get(word).increment();
                }
            }
        }
    }
    
    public void clear() {
        frequency.clear();
    }
    
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder(frequency.size()*20);
        List<WordFrequency> words = new ArrayList(frequency.values());
        Collections.sort(words);
        for (WordFrequency word : words) {
            stb.append(String.format("%-15s : %3d\n", word.getWord(), word.getCount()));
        }
        
        return stb.toString();
    }
}
