// Daily Challenge | Aug 07 2024 | Integer to English Words
// Time Complexity:

// LeetCode Runtime: 3ms      (Beats 80.85%)
// LeetCode Memory:  43.88MB  (Beats 5.48%)

class Solution {
    public String numberToWords(int num) {
        if (num == 0) { return "Zero"; }

        String sNum = "";

        int iPlace = 1000000000;

        while (iPlace > 0) {
            if ((num / iPlace) > 0) {
                sNum = PrintNumber(sNum, (num / iPlace));
                sNum = PrintPlace(sNum, iPlace);
                num %= iPlace;
                if (num > 0) { sNum += " "; }
            }
            else { num %= iPlace; }
            iPlace /= 1000;
        }

        return sNum;
    }

    private String PrintNumber(String sNum, int iNum) {
        if (iNum > 99) {
            sNum = PrintOneths(sNum, (iNum / 100));
            sNum += " Hundred";
            if ((iNum % 100) > 0) { sNum += " "; }
        }
        if ((iNum % 100) != 0) {
            sNum = PrintTenths(sNum, (iNum % 100));
        }

        return sNum;
    }

    private String PrintOneths(String sNum, int iNum) {
        if (iNum == 0) { sNum += " "; }
        if (iNum < 5) {
            if (iNum == 1) { sNum += "One"; }
            else if (iNum == 2) { sNum += "Two"; }
            else if (iNum == 3) { sNum += "Three"; }
            else if (iNum == 4) { sNum += "Four"; }
        }
        else {
            if (iNum == 5) { sNum += "Five"; }
            else if (iNum == 6) { sNum += "Six"; }
            else if (iNum == 7) { sNum += "Seven"; }
            else if (iNum == 8) { sNum += "Eight"; }
            else if (iNum == 9) { sNum += "Nine"; }
        }

        return sNum;
    }

    private String PrintTenths(String sNum, int iNum) {
        if (iNum < 10) { sNum = PrintOneths(sNum, iNum); }
        else if (iNum < 20) {
            if (iNum < 15) {
                if (iNum == 10) { sNum += "Ten"; }
                else if (iNum == 11) { sNum += "Eleven"; }
                else if (iNum == 12) { sNum += "Twelve"; }
                else if (iNum == 13) { sNum += "Thirteen"; }
                else if (iNum == 14) { sNum += "Fourteen"; }
            }
            else {
                if (iNum == 15) { sNum += "Fifteen"; }
                else if (iNum == 16) { sNum += "Sixteen"; }
                else if (iNum == 17) { sNum += "Seventeen"; }
                else if (iNum == 18) { sNum += "Eighteen"; }
                else if (iNum == 19) { sNum += "Nineteen"; }
            }
        }
        else if (iNum < 100) {
            if (iNum < 60) {
                if (iNum < 30) { sNum += "Twenty"; }
                else if (iNum < 40) { sNum += "Thirty"; }
                else if (iNum < 50) { sNum += "Forty"; }
                else { sNum += "Fifty"; }
            }
            else {
                if (iNum < 70) { sNum += "Sixty"; }
                else if (iNum < 80) { sNum += "Seventy"; }
                else if (iNum < 90) { sNum += "Eighty"; }
                else { sNum += "Ninety"; }
            }

            if ((iNum % 10) != 0) {
                sNum += " ";
                sNum = PrintOneths(sNum, (iNum % 10));
            }
        }

        return sNum;
    }

    private String PrintPlace(String sNum, int iPlace) {
        if (iPlace == 0) { return sNum; }
        if (iPlace == 1000) { sNum += " Thousand"; }
        else if (iPlace == 1000000) { sNum += " Million"; }
        else if (iPlace == 1000000000) { sNum += " Billion"; }

        return sNum;
    }
}
