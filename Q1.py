class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}

        for ind, n in enumerate(nums):
            prev = target - n
            if prev in map:
                return [map.get(prev), ind]
            map[n] = ind
        return [-1, -1]
        