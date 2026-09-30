class Solution {
    public int trap(int[] height) {
        // precompute left max heights
        // precompute right max heights

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int currLMax = 0;
        int currRMax = 0;
        for (int i = 0; i < height.length; i++) {
            currLMax = Math.max(height[i], currLMax);
            currRMax = Math.max(height[height.length - 1 - i], currRMax);

            leftMax[i] = currLMax;
            rightMax[height.length - 1 - i] = currRMax;
        }

        int water = 0;

        for (int i = 0; i < height.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;

    }
}
