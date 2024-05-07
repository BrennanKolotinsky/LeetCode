class Solution {
    
    // copied for simplicity!
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        return helper(num);
    }

    public String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 20) return LESS_THAN_20[num];
        else if (num < 100) sb.append(TENS[num / 10]).append(" ").append(helper(num % 10)).toString();
        else if (num < 1000) sb.append(LESS_THAN_20[num / 100]).append(" Hundred ").append(helper(num % 100)).toString();
        else if (num < 1000000) sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000)).toString();
        else if (num < 1000000000) sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000)).toString();
        else sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000)).toString();
        return sb.toString().trim();
    }
}