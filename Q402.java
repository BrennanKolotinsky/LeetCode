class Solution {
    public String removeKdigits(String num, int k) {

        if (k == num.length()) return "0";

        // any time the next digit is smaller we want to remove it for sure
        Stack<Character> st = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > digit) {
                st.pop();
                --k;
            }
            st.push(digit);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            --k;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}