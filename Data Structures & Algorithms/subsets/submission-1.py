class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ret = []
        def decision(curr_pos, candidate):
            if curr_pos >= len(nums):
                ret.append(candidate)
                return


            choice = candidate.copy()

            # Don't include current number
            decision(curr_pos + 1, choice)
            decision(curr_pos + 1, choice + [nums[curr_pos]])

        decision(0, [])
        return ret
        # []
        # [1], []
        # [1, 2], [1], [2], []
        # [1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []