2336. Smallest Number in Infinite Set

  You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 

Example 1:

Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 

Constraints:

1 <= num <= 1000
At most 1000 calls will be made in total to popSmallest and addBack.


  import java.util.*;

class SmallestInfiniteSet {
    private int next;                              // next smallest number not yet popped from the infinite tail
    private PriorityQueue<Integer> heap;           // re-added numbers (min-heap)
    private Set<Integer> inHeap;                   // to avoid duplicates in heap

    public SmallestInfiniteSet() {
        this.next = 1;
        this.heap = new PriorityQueue<>();
        this.inHeap = new HashSet<>();
    }

    public int popSmallest() {
        if (!heap.isEmpty()) {
            int val = heap.poll();
            inHeap.remove(val);
            return val;
        }
        return next++;
    }

    public void addBack(int num) {
        // Only add back if num was previously popped (num < next) and not already present in heap
        if (num < next && inHeap.add(num)) {
            heap.offer(num);
        }
    }
}
