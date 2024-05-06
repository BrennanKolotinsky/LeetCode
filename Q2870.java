class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // if there is one element without a match then the solution is -1
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int cnt = 0;

        for (int v : map.values()) {
            if (v == 1) {
                return -1;
            } else if (v % 3 == 0) {
                cnt += v / 3;
            } else {
                cnt += v / 3 + 1; // if there is a remainder of 1, we'll switch out one of the 3 operations to a 2 and a 2; if there is a remainder of 2, we'll perform an extra 2 operation
            }
        }

        return cnt;
    }
}