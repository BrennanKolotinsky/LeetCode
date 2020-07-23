class Solution {
    
    int[][] memo;
    
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return true;
        
        int sum = 0;
        for (int n : nums)
            sum += n;
        
        // not possible to evenly divide
        if (sum % 2 != 0)
            return false;
        
        sum /= 2;
        
        this.memo = new int[nums.length][sum + 1]; // from this point on and this sum can we find the answer?
        
        return dfs(nums, 1, sum); // commit the first value to one pile to prevent mirroring (cuts the searches in half potentially)
    }
    
    public boolean dfs(int[] nums, int pos, int rem) {
        // if we already crossed the half point or we have evaluated every element in the array
        if (pos == nums.length || rem < 0)
            return rem == 0;
        
        // already found this position isn't possible
        if (this.memo[pos][rem] == -1)
            return false;
        
        boolean fnd = dfs(nums, pos + 1, rem - nums[pos]) || dfs(nums, pos + 1, rem);
        
        if (fnd == true)
            return true;
        this.memo[pos][rem] = -1;
        
        return false;
    }
}