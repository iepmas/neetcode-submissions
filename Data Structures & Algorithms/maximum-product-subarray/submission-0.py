class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        cur_max = nums[0]
        for i in range(len(nums)):
            running_prod = 1
            for j in range(i, len(nums)):
                running_prod *= nums[j]
                cur_max = max(cur_max, running_prod)
        return cur_max