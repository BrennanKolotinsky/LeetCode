class Solution {
    public int minimumSwaps(int[] nums) {
        if (nums.length == 1) return 0;
        // do they overlap? -- if not just count the difference
        // find the spot of the highest, and the lowest
        // edge case they are the same number -- then they should already be sorted and it should return 0
        int hi = 0, lo = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] >= nums[hi]) { // pick the further right value
                hi = i;
            }

            if (nums[i] < nums[lo]) {
                lo = i;
            }
        }

        if (nums[hi] == nums[lo]) return 0; // all values are the same

        if (hi < lo) {
            return (nums.length - 1 - hi) + (lo - 1); // one free swap, plus
        } else {
            return (nums.length - 1 - hi) + (lo);
        }
    }
}