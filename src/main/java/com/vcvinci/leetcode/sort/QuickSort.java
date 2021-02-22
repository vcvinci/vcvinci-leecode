package com.vcvinci.leetcode.sort;

/**
 * @author vinci
 * @Title: QuickSort
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/2/229:24 下午
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] c = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};

        sort(a, 0, a.length-1);

        System.out.println("排序后的结果：");
        for(int x : a){
            System.out.print(x+" ");
        }

    }
    public static void sort(int[] arrs, int start, int end) {
        if (start > end) {
            return;
        }
        int partition = divide(arrs, start, end);
        sort(arrs, start, partition-1);
        sort(arrs, partition + 1, end);
    }

    private static int divide(int[] arrs, int start, int end) {
        int base = arrs[end];
        while (start < end) {
            while (start < end && base >= arrs[start]) {
                start ++;
            }
            if (start < end) {
                int temp = arrs[start];
                arrs[start] = arrs[end];
                arrs[end] = temp;
                end --;
            }
            while (start < end && base <= arrs[end]) {
                end --;
            }
            if (start < end) {
                int temp = arrs[start];
                arrs[start] = arrs[end];
                arrs[end] = temp;
                start ++;
            }
        }
        return end;
    }
}
