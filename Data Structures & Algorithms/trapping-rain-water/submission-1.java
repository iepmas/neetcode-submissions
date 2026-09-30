class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                maxLeft = Math.max(maxLeft, height[l]);
                water += maxLeft - height[l];
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r]);
                water += maxRight - height[r];
                r--;
            }
        }
        return water;
    }
}
