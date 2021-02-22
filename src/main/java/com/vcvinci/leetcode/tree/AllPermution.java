package com.vcvinci.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author vinci
 * @Title: AllPermution
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/2/229:32 上午
 */
public class AllPermution {

    private static int[] nums = new int[]{1,2,3};
    private static List<List<Integer>> res = new LinkedList<>();
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(nums);
        permute.forEach(list -> {list.forEach(System.out::print); System.out.println();});
    }

    private static List<List<Integer>> permute(int[] arrs) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(arrs, track);
        return res;
    }

    private static void backtrack(int[] arrs, LinkedList<Integer> track) {
        if (arrs.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < arrs.length; i++) {
            if (track.contains(arrs[i])) {
                continue;
            }
            track.add(arrs[i]);
            backtrack(arrs, track);

            track.removeLast();
        }
    }
}
