560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107


  class Solution {
    public int subarraySum(int[] nums, int k) {

        // int count =0;
        // for(int i=0; i<nums.length; i++){
        //     int sum =0;
        //     for(int j=i; j<nums.length; j++){
        //         sum +=nums[j];
        //         if(sum==k){
        //             count++;
        //         }
        //     }
            
        // }
        // return count;
        int count = 0;
        int currentSum = 0;

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);  // base case: prefix sum of 0 occurs once

        for (int num : nums) {
            currentSum += num;

            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Instead of getOrDefault, we check and update manually
            if (prefixSumMap.containsKey(currentSum)) {
                int existingCount = prefixSumMap.get(currentSum);
                prefixSumMap.put(currentSum, existingCount + 1);
            } else {
                prefixSumMap.put(currentSum, 1);
            }
        }

        return count;
        
    }
}
