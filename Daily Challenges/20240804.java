// Daily Challenge | Aug 04 2024 | Range Sum of Sorted Subarray Sums
// Time Complexity: O(nlog(n)) for Merge Sort
//                  O(n^2)     for Array Creation

// LeetCode Runtime: 121ms    (Beats 42.85%)
// LeetCode Memory:  56.91MB  (Beats 40.75%)

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Escape Case
        if (n == 1) { return nums[0]; }

        // Part I:   Create array with subarrays
        int[] ilNums2 = CreateList(nums, n);

        // Part II: Sort ilNums2
        ilNums2 = Sort(ilNums2, ilNums2.length);

        // Part III: Calculate Sum of Range
        return SumOfRange(ilNums2, left, right);
    }

    static int[] CreateList(int[] ilNums1, int iLen1) {
        int iLen2 = iLen1 * (iLen1 + 1) / 2;
        int[] ilNums2 = new int[iLen2];
        
        int iPos = 0;

        for (int i=0; i < iLen1; i++) {
            ilNums2[iPos] = ilNums1[i];
            iPos++;

            for (int j=i+1; j < iLen1; j++, iPos++) {
                ilNums2[iPos] = ilNums2[iPos-1] + ilNums1[j];
            }
        }

        return ilNums2;
    }

    static int[] Sort(int[] ilNums, int iLen) {
        // Escape Case
        if (iLen == 1) { return ilNums; }

        // Create and fill left and right arrays
        int iSizeLeft = iLen/2;
        int iSizeRight = iLen - iSizeLeft;

        int[] ilLeft = new int[iSizeLeft];
        int[] ilRight = new int[iSizeRight];

        for (int i=0; i < iSizeLeft; i++) {
            ilLeft[i] = ilNums[i];
        }
        for (int i=iSizeLeft; i < iLen; i++) {
            ilRight[i-iSizeLeft] = ilNums[i];
        }

        // Recursive function call
        ilLeft = Sort(ilLeft, iSizeLeft);
        ilRight = Sort(ilRight, iSizeRight);

        // Copy array contents back
        int i=0, j=0, k=0;

        while ((i < iSizeLeft) && (j < iSizeRight)) {
            if (ilLeft[i] < ilRight[j]) {
                ilNums[k] = ilLeft[i];
                i++;
            }
            else {
                ilNums[k] = ilRight[j];
                j++;
            }
            k++;
        }
        while (i < iSizeLeft) {
            ilNums[k] = ilLeft[i];
            i++; k++;
        }
        while (j < iSizeRight) {
            ilNums[k] = ilRight[j];
            j++; k++;
        }

        return ilNums;
    }

    static int SumOfRange(int[] ilNums, int iLeft, int iRight) {
        long liSum = 0L;

        for (int i=iLeft-1; i < iRight; i++) {
            liSum += ilNums[i];
        }

        return (int)(liSum % (1000000000 + 7));
    }
}
