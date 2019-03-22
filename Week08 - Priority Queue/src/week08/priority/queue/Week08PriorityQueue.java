/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week08.priority.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author INT320
 */
public class Week08PriorityQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(20, new MyComparator());
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Integer addingValue = r.nextInt(99);
            pq.add(addingValue);
            System.out.println("Added: " + addingValue);
            System.out.println("Size: " + pq.size());
            System.out.println("first item in queue: " + pq.peek());
            System.out.println("PQ: " + pq);
            System.out.println("-----");
        }
        testApply();
    }

    private static void testApply() {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student(1001, "A", 1.75));
        pq.add(new Student(1007, "C", 2.25));
        pq.add(new Student(1008, "D", 3.25));
        pq.add(new Student(1011, "E", 3.59));
        pq.add(new Student(1021, "F", 3.65));
        pq.add(new Student(1031, "G", 4.05));
        pq.add(new Student(1051, "H", 3.25));
        for (Student student : pq) {
            System.out.println(student.id + ": " + student.gpax);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().gpax + ",");
        }
        System.out.println("\b\b\n");
    }

    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}

class Student implements Comparable<Student> {
    int id;
    String name;
    double gpax;

    public Student(int id, String name, double gpax) {
        this.id = id;
        this.name = name;
        this.gpax = gpax;
    }
    
    @Override
    public int compareTo(Student o) {
        if (this.gpax < o.gpax) {
            return 1;
        } else if (this.gpax > o.gpax) {
            return -1;
        }
        return 0;
    }
}
