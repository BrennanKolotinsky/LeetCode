class Solution {
    public int numDistinct(String s, String t) {
        // easy dynamic programming problem we have seen a million times using DFS
        int[][] memo = new int[s.length()][t.length()]; // This will track how many ways the word can be completed from this point
        
        for (int[] arr : memo)
            Arrays.fill(arr, -1);
        
        // easy checks to save processing
        if (t.length() > s.length())
            return 0;
        
        if (t.length() == s.length() && t.equals(s))
            return 1;
        else if (t.length() == s.length())
            return 0;
        
        return dfs(s, t, 0, 0, memo);     
    }
    
    public int dfs(String s, String t, int i, int j, int[][] memo) {
        
        // found a match
        if (j == t.length())
            return 1;
        else if (s.length() == i) // hit the end without a match
            return 0;

        // already calculated this position
        if (memo[i][j] != -1)
            return memo[i][j];
        
        int cases = 0;
        
        // advance both characters if they match OR only the bigger strings
        if (s.charAt(i) == t.charAt(j))
            cases = dfs(s, t, i + 1, j + 1, memo) + dfs(s, t, i + 1, j, memo);
        else
            cases = dfs(s, t, i + 1, j, memo);
         
        memo[i][j] = cases;
        return cases;
    }
}