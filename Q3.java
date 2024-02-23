class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int len = 1;

        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int j = 0;
        // sliding window
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(j++));
            }

            set.add(c);
            len = Math.max(len, set.size());
        }

        return len;
    }
}