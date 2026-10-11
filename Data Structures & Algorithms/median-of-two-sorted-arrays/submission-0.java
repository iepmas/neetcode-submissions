class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = total / 2; // issue?

        if (A.length > B.length) {
            A = nums2;
            B = nums1;
        }

        int l = 0;
        int r = A.length;
        while (l <= r) {
            // element counts not indexes
            int i = l + (r - l) / 2;          // A
            int j = half - i; // B

            // Check if we correctly found the left partition
            int Aleft  = i <= 0              ? Integer.MIN_VALUE : A[i - 1];
            int Aright = i >= A.length  ? Integer.MAX_VALUE : A[i];
            int Bleft  = j <= 0              ? Integer.MIN_VALUE : B[j - 1];
            int Bright = j >= B.length  ? Integer.MAX_VALUE : B[j];
            
            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return (double) Math.min(Aright, Bright);
                } else {
                    return (double) (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1.0;
    }
}
