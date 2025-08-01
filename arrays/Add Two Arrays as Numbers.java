Problem Description:
You are given two integer arrays arr1 and arr2 of the same length n, where each array represents the digits of a number (from most significant to least significant). 
Your task is to add these two numbers digit by digit (from right to left), including carry handling, and return the resulting array of digits of the same length n. 
The result should wrap around if there's a final carry (i.e., drop the most significant digit if it exceeds length n).
Input: 
arr1 = [2,3,4]
arr2 = [4,5,6]

Output: 
[6,9,0]


  234
+ 456
-----
  690   → carry from 9+6 = 15 ⇒ last digit is 0, carry = 1, but only 3 digits allowed, so we drop the leading 1

  
class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 4};
        int[] arr2 = new int[]{4, 5, 6};

        int[] result = addArrays(arr1, arr2);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] addArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] res = new int[n];
        int carry = 0;

        for (int i = n - 1; i >= 0; i--) {
            int sum = arr1[i] + arr2[i] + carry;
            res[i] = sum % 10;
            carry = sum / 10;
        }

        // If carry still remains, it is ignored (wrap around behavior)
        return res;
    }
}
