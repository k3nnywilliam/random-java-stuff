/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        
        int result = 1;
        int n = 0;

        for (int i = 0, j = 1; i < nums.length && j < nums.length - 1; i++) {

            if(nums[i] == nums[j]) {
                if(n < k) {

                    int curr_num = nums[i];
                    n = n + nums[i];

                    while(curr_num == nums[j]) {
                        n = n + nums[j];
                        result++;
                        j++;
                    }
                    
                }
            }
            else if(n == k) {
                return result;
            }
            else {
                result = 1;
                n = 0;
            }
        
        }

        return result;
    }

    public int subarraySum2(int[] nums, int k) {

    HashMap < Integer, Integer > map = new HashMap < > ();
    int count = 0;
    int sum = 0;
    
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (map.containsKey(sum - k))
            count += map.get(sum - k);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
    }
}


class PractTwo {
    public static void main(String[] args) {

        int[] nums = {1,1,1};
        int k = 2;

        Solution2 mySolution2 = new Solution2();
        //System.out.println(mySolution2.subarraySum(nums, k));
        System.out.println(mySolution2.subarraySum2(nums, k));
    }
  }