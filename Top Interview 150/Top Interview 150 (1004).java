// Top Interview 150 | Array / String 004 | Remove Duplicates from a Sorted Array II
// Time Complexity: O(n^2)

// LeetCode Runtime: 0ms     (Beats 100.00%)
// LeetCode Memory:  44.49MB (Beats 42.51%)

class Solution {
    public int removeDuplicates(int[] nums) {
        // Early return if array is empty
        int iLen = nums.length;
        if (iLen == 0) { return 0; }

        // Variable Declarations
        int j=0;
        int iCurrNum = nums[0];
        int iTolerance = 0;

        for (int i=0; i < iLen; i++, j++) {
            // If still on current number
            if (iTolerance < 2) {
                // If current number only appeared once
                if (nums[i] > iCurrNum) {
                    iCurrNum = nums[i];
                    iTolerance = 0;
                }
                nums[j] = nums[i];
                iTolerance++;
            }
            // If current number has appeared twice already
            else {
                // Skip to next number
                while ((nums[i] == iCurrNum) && (i < iLen-1)) { i++; }
                // Early return if current number is the last number in the list
                if (nums[i] == iCurrNum) { return j; }
                
                iCurrNum = nums[i];
                nums[j] = nums[i];
                iTolerance = 1;
            }
        }
        
        // Return length of non-duplicates
        return j;
    }
}
