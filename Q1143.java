class Solution {
    public int dfs(String text1, String text2, int i, int j, int[][] memo) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = dfs(text1, text2, i + 1, j + 1, memo) + 1;
        } else {
            memo[i][j] = Math.max(dfs(text1, text2, i + 1, j, memo), dfs(text1, text2, i, j + 1, memo));
        }
        return memo[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(text1, text2, 0, 0, memo);
    }
}