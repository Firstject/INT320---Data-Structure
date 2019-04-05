/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchrecursive;

/**
 *
 * @author INT320
 */
public class BinarySearchRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] data = {2, 7, 8, 12, 14, 15, 26, 39, 47, 53, 55};
        int pos;
        pos = binarySearch(data, 25);
        System.out.println("key 25, position = " + pos);
        pos = binarySearch(data, 39);
        System.out.println("key 39, position = " + pos);
        pos = binarySearch(data, 7);
        System.out.println("key 7, position = " + pos);
        
        String[] str = {"A", "E", "I", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X"};
        pos = binarySearch(str, "X");
        System.out.println("key 'X', position = " + pos);
    }

    private static int binarySearch(Object[] data, Object key) {
        return binarySearch(data, key, 0, data.length - 1);
//        Comparable k = (Comparable) key;
//        int left = 0;
//        int right = data.length - 1;
//        while(left <= right) {
//            int mid = (left + right) / 2;
//            Comparable x = (Comparable) data[mid];
//            if (k.compareTo(x) < 0) {
//                right = mid - 1;
//            } else if (k.compareTo(x) > 0) {
//                left = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        
//        return -1;
    }
    
    private static int binarySearch(Object[] data, Object key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        Comparable k = (Comparable) key;
        Comparable x = (Comparable) data[mid];
        int compareValue= k.compareTo(x);
        if (compareValue == 0) {
            return mid;
        } else if (compareValue < 0) {
            return binarySearch(data, key, left, mid - 1);
        } else if (compareValue > 0) {
            return binarySearch(data, key, mid + 1, data.length - 1);
        }
        return -1;
    }
    
}
