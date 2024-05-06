class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 2
        while (True):
            if (i < 0):
                Solution.reverse(nums, 0)
                return
            if (nums[i] < nums[i + 1]):
                break
            i = i - 1
        
        j = len(nums) - 1
        while (True):
            if (nums[j] > nums[i]):
                break
            j = j - 1

        Solution.swap(nums, i, j)
        Solution.reverse(nums, i + 1)
    
    def reverse(nums, i):
        j = len(nums) - 1
        while (i < j):
            Solution.swap(nums, i, j)
            i = i + 1
            j = j - 1
        
    def swap(nums, i, j):
        tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp