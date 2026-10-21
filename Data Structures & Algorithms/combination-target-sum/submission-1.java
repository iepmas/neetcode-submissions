class Solution {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> curr;
    int sum = 0;

    private void backtrack(int[] nums, int i, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        } else if (sum > target) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            curr.add(nums[j]);
            backtrack(nums, j, target);
            sum -= nums[j];
            curr.remove(curr.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        curr = new ArrayList<>();
        backtrack(nums, 0, target);
        return new ArrayList<>(result);   
    }
}
