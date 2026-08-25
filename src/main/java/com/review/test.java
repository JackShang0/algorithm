package com.review;

import java.util.Arrays;

public class test {


    /*

     */


    public static void main(String[] args) {

    }

    public int getKNumber(int[] nums,int k){
        if(nums.length < k){
            return 0;
        }

        Arrays.sort(nums);

        return nums[k-1];
    }



    public int getKNumberV2(int[] nums,int k){
        


        return 0;
    }



}
