class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    private void backtrack(int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited.contains(nums[j])) {
                continue;
            }
            curr.add(nums[j]);
            visited.add(nums[j]);
            backtrack(nums);
            visited.remove(nums[j]);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }
}
