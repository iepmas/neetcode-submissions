class Solution {
    private boolean validate(int[] piles, int h, int k) {
        int timeTaken = 0;
        for (int i = 0; i < piles.length; i++) {
            timeTaken += ((piles[i] + k - 1) / k);
            if (timeTaken > h) {
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // solution space is between 1 and maxiumum of each pile. should perform binary search on each. verifying is O(1)?
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ret = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (validate(piles, h, m)) {
                ret = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ret;
    }
}
