// Daily Challenge | Aug 03 2024 | Make Two Arrays Equal by Reversing Subarrays
// Time Complexity: O(n^2)

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        boolean bCanEqual = false;
        int iLen = target.length;
        int iTemp = 0;

        for (int i=0; i < iLen; i++) {
            for (int j=i; j < iLen; j++) {
                if (target[i] == arr[j]) {
                    iTemp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = iTemp;

                    bCanEqual = true;
                    break;
                }
                bCanEqual = false;
            }
            if (!bCanEqual) { return false; }
        }
        
        return bCanEqual;
    }
}
