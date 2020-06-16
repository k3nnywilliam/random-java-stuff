/*
Leet code 34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
    
        int[] results = {0,0};
        int left = 0;
        int right = nums.length - 1 ;

        while(left <= right) {

            int mid = (left + right)/2;

            if(nums[mid] == target) {

                if(nums[mid - 1] == nums[mid]) {
                    results[0] = mid - 1;
                    results[1] = mid;
                    break;
                }
                else if(nums[mid + 1] == nums[mid]) {
                    
                    results[0] = mid;
                    results[1] = mid + 1;
                    break;
                }
                else {
                    results[0] = -1;
                    results[1] = -1;
                    break;
                }
            }
            else if(nums[mid] < target) {

                left = mid + 1;
            }
            else {

                right = mid - 1;
            }

        }

         if ( left > right ){  
            results[0] = -1;
            results[1] = -1;
         };
        
        return results;
    
    }
        
}


class MainProgram {
    public static void main(String[] args) {

      Solution mySolution = new Solution();
      int target = 8;
      int[] nums = {5,7,7,8,8,10}; // 5,7,7,8,8,10
      System.out.print(Arrays.toString(mySolution.searchRange(nums, target)));
    }
  }

