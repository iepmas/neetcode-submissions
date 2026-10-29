class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int currSum = 0;

    private void backtrack(int[] nums, int i, int target) {
        if (currSum > target) {
            return;
        }

        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            currSum += nums[j];
            curr.add(nums[j]);
            backtrack(nums, j, target);
            currSum -= nums[j];
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, 0, target);
        return result;
    }
}
