Here’s a clean and efficient Java solution for LeetCode 216. Combination Sum III using backtracking.

✅ Problem Understanding

We need to find all combinations of k numbers that add up to n.

Use numbers from 1 to 9 without repetition.

Each combination should be unique and in ascending order.

✅ Approach

Use backtracking:

Maintain start to avoid reusing numbers.

Track sum and path (current combination).

Stop when:

path.size() == k and sum == n → Add to result.

sum > n or path.size() > k → Stop early (prune).

✅ Time Complexity

Worst case: O(C(9, k)) because we choose k numbers from 9.

Space: O(k) for recursion stack.

✅ Code:
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int k, int n, int start) {
        if (path.size() == k && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n - i < 0) break; // Prune if sum exceeds n

            path.add(i);
            backtrack(result, path, k, n - i, i + 1);
            path.remove(path.size() - 1); // Backtrack
        }
    }
}

✅ Example Run:
Solution sol = new Solution();
System.out.println(sol.combinationSum3(3, 7)); // [[1,2,4]]
System.out.println(sol.combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]


Do you want me to also show:
✔ Step-by-step recursion tree for (k=3, n=9) OR
✔ Optimized version with early pruning using sum and remaining slots?
