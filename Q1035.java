class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] arr : memo)
            Arrays.fill(arr, -1); // -1 indicates we haven't found a solution yet
        return dfs(nums1, nums2, 0, 0, memo);
    }

    public int dfs(int[] nums1, int[] nums2, int openInd, int currentPos, int[][] memo) {
        if (currentPos == nums1.length || openInd == nums2.length)
            return 0;
        if (memo[currentPos][openInd] >= 0)
            return memo[currentPos][openInd];

        int curr = nums1[currentPos];

        int max = 0;
        for (int i = openInd; i < nums2.length; i++) {
            if (curr == nums2[i]) {
                max = 1 + dfs(nums1, nums2, i + 1, currentPos + 1, memo);
                break; // the leftmost is always the most efficient option
            }  
        }

        max = Math.max(max, dfs(nums1, nums2, openInd, currentPos + 1, memo));
        memo[currentPos][openInd] = max;
        return max;
    }
}