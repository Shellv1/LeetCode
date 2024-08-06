// Runtime: 4ms     (Beats 46.09%)
// Memory:  43.84MB (Beats 96.28%)

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        boolean bCanEqual = false;
        int iLen = target.length;
        int i=0, j=0;

        for (i=0; i < iLen; i++) {
            for (j=0; j < iLen; j++) {
                if (target[i] == arr[j]) {
                    arr[j] = 0;
                    bCanEqual = true;
                    break;
                }
                bCanEqual = false;
            }
            if (bCanEqual == false) { return false; }
        }
        
        return bCanEqual;
    }
}
