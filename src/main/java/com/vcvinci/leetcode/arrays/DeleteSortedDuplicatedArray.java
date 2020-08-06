package com.vcvinci.leetcode.arrays;

import java.util.Arrays;

/**
 * @author vinci
 * @Title: DeleteSortedDuplicatedArray
 * @ProjectName vcvinci-leetcode
 * @Description: leetcode-26
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * @date 2020/8/712:04 上午
 */
public class DeleteSortedDuplicatedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6};
        System.out.println(removeDuplicate(nums));
    }

    public static int removeDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 结题思路双指针
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
        return i + 1;
    }
}
