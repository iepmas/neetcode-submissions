class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ret = new int[nums.length];

        for (int r = 0; r < nums.length; r++) {
            // Remove left window boundary
            if (!deque.isEmpty() && deque.peekFirst() < r - k + 1) {
                deque.removeFirst();
            }

            // Remove elements in deque which nums[r] is greater than since it is greater AND newer.
            while (!deque.isEmpty() && nums[r] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(r);

            // Place in correct location
            if (r + 1 >= k) {
                ret[r] = nums[deque.peekFirst()];
            }
        }
        return Arrays.stream(ret, k-1, nums.length).toArray();
    }
}
