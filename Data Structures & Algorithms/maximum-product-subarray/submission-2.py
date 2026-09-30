class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        dp_max = [nums[0]]
        dp_min = [nums[0]]
        curr_max = max(nums)
        for i in range(1, len(nums)):
            if nums[i] > 0:
                curr_max = max(dp_max[i - 1] * nums[i], curr_max)
                dp_max.append(dp_max[i - 1] * nums[i])
                dp_min.append(dp_min[i - 1] * nums[i])
            elif nums[i] < 0:
                curr_max = max(dp_min[i - 1] * nums[i], curr_max)
                dp_max.append(dp_min[i - 1] * nums[i])
                dp_min.append(dp_max[i - 1] * nums[i])
            else:
                dp_max.append(0)
                dp_min.append(0)
        return curr_max