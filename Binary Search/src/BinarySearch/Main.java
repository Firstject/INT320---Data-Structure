/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

/**
 *
 * @author INT303
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int data[] = {9, 15, 32, 71, 78, 92, 101, 115, 117, 129, 270, 350, 470, 500};
        int pos = binarySearch(data, 78);
        System.out.println("Pos:" + pos);
    }

    private static int binarySearch(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = data[mid];
            
            if (midVal < key) {
                left = mid + 1;
            } else if(midVal > key) {
                right = mid - 1;
            } else {
                return mid; //Key found ja
            }
        }
        return -(left + 1);
    }
}
