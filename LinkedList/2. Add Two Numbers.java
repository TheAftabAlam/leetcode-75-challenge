You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.


  // /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {


//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//         ListNode prev1 = null;
//         ListNode curr1 = l1;
//         while (curr1 != null) {
//             ListNode nextNode = curr1.next;
//             curr1.next = prev1;
//             prev1 = curr1;
//             curr1 = nextNode;
//         }

//         ListNode prev2 = null;
//         ListNode curr2 = l2;
//         while (curr2 != null) {
//             ListNode nextNode = curr2.next;
//             curr2.next = prev2;
//             prev2 = curr2;
//             curr2 = nextNode;
//         }
        
//         String num1 = "";
//         ListNode start1 = prev1;
//         while (start1 != null) {
//             num1 += start1.val;
//             start1 = start1.next;
//         }

//         String num2 = "";
//         ListNode start2 = prev2;
//         while (start2 != null) {
//             num2 += start2.val;
//             start2 = start2.next;
//         }


//         int sum = Integer.parseInt(num1) + Integer.parseInt(num2);

//         if (sum == 0) return new ListNode(0); // sum is 0 case

//         ListNode dummy = new ListNode(0);
//         ListNode result = dummy;
        
//         while(sum > 0){
//             int rem = sum % 10;
//             result.next = new ListNode(rem);
//             result = result.next;
//             sum = sum / 10;
//         }
//         return dummy.next;
//     }
// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy head for result list
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Add new node with current digit
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Update carry
            carry = sum / 10;
        }

        return dummy.next;
    }
}
