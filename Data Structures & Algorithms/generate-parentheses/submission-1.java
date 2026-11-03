class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int open = 0;
    int closed = 0;

    private void backtrack(int n, int i) {
        if (i == n && open == closed) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            open++;
            backtrack(n, i + 1);
            open--;
            sb.deleteCharAt(sb.length() - 1);
        }        

        if (open > closed) {
            sb.append(")");
            closed++;
            backtrack(n, i);
            closed--;
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0);
        return result;
    }
}
