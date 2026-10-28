class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    private void backtrack(int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, i + 1);
        curr.remove(curr.size() - 1);
        backtrack(nums, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }
}
