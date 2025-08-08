239. Sliding Window Maximum

  You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


  class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums == null || nums.length == 0 || k <= 0) {
    //         return new int[0];
    //     }

    //     int n = nums.length;
    //     int[] result = new int[n - k + 1];
    //     int idx = 0;

    //     // Each i is the start of a window
    //     for (int start = 0; start <= n - k; start++) {
    //         result[idx++] = getMax(nums, start, start + k);
    //     }

    //     return result;
    // }

    // private int getMax(int[] nums, int start, int end) {
    //     int max = Integer.MIN_VALUE;
    //     for (int i = start; i < end; i++) {
    //         max = Math.max(max, nums[i]);
    //     }
    //     return max;
    // }

    //  int n = nums.length;
    //     int[] result = new int[n - k + 1];
    //     List<Integer> window = new ArrayList<>();

    //     // First window
    //     for (int i = 0; i < k; i++) {
    //         window.add(nums[i]);
    //     }
    //     result[0] = Collections.max(window);

    //     // Slide the window
    //     for (int i = k; i < n; i++) {
    //         // Remove first element (oldest)
    //         window.remove(0);
    //         // Add new element
    //         window.add(nums[i]);
    //         // Find max in current window
    //         result[i - k + 1] = Collections.max(window);
    //     }

    //     return result;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        List<Integer> list = new ArrayList<>(); 
        int ri = 0;

        for (int i = 0; i < n; i++) {
            // 1. Remove indices out of current window
            if (!list.isEmpty() && list.get(0) <= i - k) {
                list.remove(0);
            }

            // 2. Remove from back all elements smaller than current
            while (!list.isEmpty() && nums[list.get(list.size() - 1)] < nums[i]) {
                list.remove(list.size() - 1);
            }

            // 3. Add current index at the back
            list.add(i);

            // 4. Add max to result (front of list) once window is ready
            if (i >= k - 1) {
                result[ri++] = nums[list.get(0)];
            }
        }

        return result;
    }
}
