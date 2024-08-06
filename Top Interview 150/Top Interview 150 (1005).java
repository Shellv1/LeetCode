// Top Interview 150 | Array / String 005 | Majority Element
// Time Complexity: O(n^2)

// LeetCode Runtime: 1ms      (Beats 99.79%)
// LeetCode Memory:  52.96MB  (Beats 47.03%)

class Solution {
    public int majorityElement(int[] nums) {
        // An array with less than 3 elements will have no majority
        int iLen = nums.length;
        if (iLen < 3) { return nums[0]; }

        // Variable Declarations
        int iTemp = 0;
        int iCount = 0;
        int iElement = 0;
        int j = 0;

        // Iterate through array, exit if current element is the majority
        for (int i=0; (i < iLen) && (iCount < (iLen/2)+1); i++) {
            // Reset count if starting a new element
            if (iElement != nums[i]) {
                iCount = 1;
                iElement = nums[i];
            }
            // Increment count if continuing from same element
            else { iCount++; }

            // From the end of the array, if the element is the same:
            for (int j = iLen-1; (j > i); j--) {
                if (nums[j] == iElement) {
                    // Move i to next non-matching element
                    while ((nums[i] == iElement) && (i < j)) {
                        i++;
                        iCount++;
                    }
                    // Swap i and j
                    iTemp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = iTemp;
                }
            }
        }

        // Return majority element
        return iElement;
    }
}
