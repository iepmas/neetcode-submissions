class Solution {
    private boolean validateEatingSpeed(int[] piles, int k, int h) {
        int timeTaken = 0;
        for (int pile : piles) {
            // timeTaken += (int) Math.ceil(pile / double(k));
            timeTaken += (pile + k - 1) / k;
            if (timeTaken > h) {
                return false;
            }
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int m = l + (r - l) / 2;
            if (validateEatingSpeed(piles, m, h)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
