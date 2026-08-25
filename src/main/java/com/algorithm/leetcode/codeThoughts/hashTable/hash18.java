package com.algorithm.leetcode.codeThoughts.hashTable;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和
 */
public class hash18 {

    public static void main(String[] args) {

        int[] ints = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> lists = fourSum(ints, 0);
        for (List<Integer> list : lists) {
            System.out.println("list = " + list);
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 4) {
            return lists;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0 && nums[i] > target && target > 0) {
                return lists;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target && target > 0) {
                    return lists;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        right--;
                        left++;
                    }
                    /*else if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    } else if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }*/
                }
            }
        }
        return lists;
    }


    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                // nums[i]+nums[j] > target 直接返回, 剪枝操作
                if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target) {
                    return result;
                }

                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 4) {
            return lists;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0 && nums[i] > target && target > 0) {
                //return lists;
                break;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target && target > 0) {
                    //return lists;
                    break;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        right--;
                        left++;

                    } else if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    }
                }
            }
        }
        return lists;
    }

    private List<List<Integer>> res;
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        return new AbstractList<List<Integer>>(){
            @Override
            public List<Integer> get(int idx){
                init();
                return res.get(idx);
            }

            @Override
            public int size(){
                init();
                return res.size();
            }

            private void init(){
                if(res!=null) return;
                int len = nums.length;
                Arrays.sort(nums);
                res = new ArrayList<>();
                for(int a =0;a<len-3;a++){
                    int n1 = nums[a];
                    if(a!=0&&n1==nums[a-1])continue;
                    if((long)n1 + nums[a+1] + nums[a+2] + nums[a+3] > target) break;
                    if((long)n1 + nums[len-3] + nums[len-2] + nums[len-1] < target) continue;
                    for(int b=a+1;b<len-2;b++){
                        int n2 = nums[b];
                        if(b!=a+1&&n2==nums[b-1]) continue;
                        if((long)n1 + n2 + nums[b+1] + nums[b+2] > target) break;
                        if((long)n1 + n2 + nums[len-2] + nums[len-1] < target) continue;
                        for(int c=b+1, d = len-1;c<d;c++){
                            int n3 = nums[c];
                            if(c!=b+1&&n3==nums[c-1]) continue;
                            if((long)n1 + n2 + n3 + nums[c+1] > target) break;
                            if((long)n1 + n2 + n3 + nums[len-1] < target) continue;
                            while(c<d&&n1+n2+n3+nums[d]>target) d--;
                            if(c<d&& n1+n2+n3+nums[d]==target){
                                List<Integer> list = new ArrayList<>();
                                list.add(n1);
                                list.add(n2);
                                list.add(n3);
                                list.add(nums[d]);
                                res.add(list);
                            }
                        }
                    }
                }
            }
        };
    }


    public List<List<Integer>> fourSum4(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i =0 ; i< n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            if((long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target){
                continue;
            }
            for (int j = i+1 ; j< n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                    break;
                }
                if((long)nums[i] + nums[j] + nums[n-2] + nums[n-1] < target){
                    continue;
                }
                int left = j + 1;
                int right = n -1;
                while(left < right){
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> ans = new ArrayList<Integer>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        result.add(ans);
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        right--;
                    }else if(sum > target){
                        right--;
                    }else{
                        left++;
                    }

                }
            }

        }
        return result;
    }


}
