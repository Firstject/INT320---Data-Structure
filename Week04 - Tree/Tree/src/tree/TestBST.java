/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author INT320
 */
public class TestBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Student> x = new TreeSet(new StudentComparator());
        x.add(new Student(1, "A"));
        x.add(new Student(1, "B"));
        x.add(new Student(1, "C"));
        x.add(new Student(1, "D"));
        x.add(new Student(1, "E"));
        x.add(new Student(1, "F"));
        System.out.println(x);
        System.out.println(x.contains(new Student(3, "C")));
    }
    
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
    
}

class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student st) {
        return this.id - st.id + this.name.compareTo(st.name);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }

    
}