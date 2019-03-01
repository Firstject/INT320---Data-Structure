/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtb;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author INT320
 */
public class HashTB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Set<String> s = new HashSet<>();
//        s.add("Cat");
//        s.add("Dog");
//        s.add("Bird");
//        s.add("Duck");
//        
//        String x = new String("Cat");
//        
//        System.out.println("Cat".hashCode());
//        System.out.println(x.hashCode());
        
        testHashCode();
    }
    
    static void testHashCode() {
        Set <NewStudent> st = new HashSet();
        st.add(new NewStudent(1001, "Somchai"));
        st.add(new NewStudent(1002, "Somsri"));
        st.add(new NewStudent(1003, "Somkiet"));
        NewStudent ns = new NewStudent(1002, "Somsri");
        NewStudent ns2 = new NewStudent(1002, "Somsri");
        System.out.println(ns.hashCode());
        System.out.println(ns2.hashCode());
        System.out.println(st.contains(ns));
    }
}

class NewStudent {
    private int id;
    private String name;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NewStudent other = (NewStudent) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    public NewStudent(int id, String name) {
        this.id = id;
        this.name = name;
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
    
}