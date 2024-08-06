// Daily Challenge | Aug 01 2024 | Number of Senior Citizens
// Time Complexity: O(n)

// LeetCode Runtime: 0ms      (Beats 100.00%)
// LeetCode Memory:  42.28MB  (Beats 78.58%)

class Solution {
    public int countSeniors(String[] details) {
        int iLen = details.length;
        int iNumSeniors = 0;

        for (int i=0; i < iLen; i++) {
            char cTens = details[i].charAt(11);
            char cOnes = details[i].charAt(12);

            if ((cTens > '6') || ((cTens == '6') && (cOnes > '0'))) {
                iNumSeniors++;
            }
        }

        return iNumSeniors;
    }
}
