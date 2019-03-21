import java.util.Arrays;

import com.sun.org.apache.regexp.internal.recompile;

import jdk.nashorn.internal.ir.ReturnNode;

/** Median of Two Sorted Arrays
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 */

 public class Median {

    public double solution(int[] nums1, int[] nums2) {
        return 0;
    }
 
    // Time Limit Exceeded
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] array = new int[len];
        int index  = 0, index1 = 0, index2 = 0;
        while(index < len) {
            if(nums1[index1] <= nums2[index2] || index2 >= len2) {
                array[index++] = nums1[index1++];
            } else if(index1 >= len1) {
                array[index++] = nums2[index2++];
            }
        }
        int position = len / 2;
        double result = (len % 2 == 0) ? (array[position]+array[position])/(1.0*2) : (double)array[position];
        return result;
    }
 }