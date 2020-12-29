package com.vcvinci.leetcode.math;

/**
 * @author vinci
 * @Title: Pow
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2020/12/296:30 上午
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(9));
        System.out.println(sqrt(15));
        System.out.println(sqrt(20));
    }


    public static int sqrt(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        int start = 0;
        int end = target;
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start);
            if (mid * mid == target) {
                return mid;
            } else if (mid * mid > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }

        }
        return result;
    }

    public static int sqrt2(int target) {
        int res = target;
        while (res * res > target) {
            res = (res + target / res) / 2;
        }
        return res;
    }



}
