class Solution {
    public int maxJump(int[] stones) {
        int sol = stones[1];

        for (int i = 2; i < stones.length; ++i) {
            sol = Math.max(stones[i] - stones[i - 2], sol);
        }
        
        return sol;
    }
}