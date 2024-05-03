class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
    }
    
    public void update(int row, int col, int val) {
        int prevValue = dp[row + 1][col + 1] - dp[row + 1][col] - dp[row][col + 1] + dp[row][col];
        int diff = val - prevValue;
        System.out.println(dp[row + 1][col + 1]);

        for (int i = row; i < dp.length - 1; ++i)
            for (int j = col; j < dp[0].length - 1; ++j)
                dp[i + 1][j + 1] += diff;        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */