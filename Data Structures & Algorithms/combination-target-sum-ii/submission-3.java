class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int sum = 0;

    private void backtrack(int[] candidates, int i, int target) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            sum += candidates[j];
            curr.add(candidates[j]);
            backtrack(candidates, j + 1, target);
            sum -= candidates[j];
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return result;
    }
}
