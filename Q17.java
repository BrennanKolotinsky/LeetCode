class Solution {
    public HashMap<Integer, char[]> createMap() {
        HashMap<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        return map;
    };

    public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList<>();
        if (digits == null || digits.length() == 0) return sol;
        
        HashMap<Integer, char[]> map = createMap();

        backtrack(digits, map, 0, "", sol);
        return sol;
    }

    public void backtrack(String digits, HashMap<Integer, char[]> map, int i, String s, List<String> sol) {
        if (i == digits.length()) {
            sol.add(s);
            return;
        }

        char d = digits.charAt(i);
        int digit = d - '0'; 

        for (char c : map.get(digit)) {
            String tmpS = s + c;
            backtrack(digits, map, i + 1, tmpS, sol);
        }
    }
}