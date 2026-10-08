class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int targetRow = 0;

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                targetRow = i;
            }
        }

        int l = 0;
        int r = cols - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[targetRow][m] == target) {
                return true;
            }

            if (matrix[targetRow][m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }
        return false;
    }
}
