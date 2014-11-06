public class Solution {
    public String intToRoman(int num) {
        String result = "";
        
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hund = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thou = {"", "M", "MM", "MMM"};
        
        result += thou[num / 1000];
        num = num % 1000;
        
        result += hund[num / 100];
        num = num % 100;
        
        result += tens[num / 10];
        num = num % 10;
        
        result += ones[num];
        
        return result;
        
    }
}
