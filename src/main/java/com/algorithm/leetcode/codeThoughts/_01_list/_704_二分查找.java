package com.algorithm.leetcode.codeThoughts._01_list;

public class _704_二分查找 {
    public static void main(String[] args) {


    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] > target && nums[right] < target) {
            return -1;
        }

        while (left <= right) {
            int middle = left + ((right - left)/2);
            if(nums[middle]>target){
                right = middle-1;
            }else if (nums[middle]<target){
                left = middle +1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
