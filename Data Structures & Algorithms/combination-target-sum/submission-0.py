class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        ret = []
        curr = []
        def dfs(i):
            if sum(curr) > target:
                return
            
            if sum(curr) == target:
                ret.append(curr.copy())
                return
            
            if i >= len(nums):
                return

            # Add same value
            curr.append(nums[i])
            dfs(i)

            # Add new value
            curr.pop()
            dfs(i + 1)
        
        dfs(0)
        return ret