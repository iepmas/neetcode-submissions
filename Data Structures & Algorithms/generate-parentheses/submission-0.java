class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int open = 0;
    int closed = 0;
    private void backtrack(int n) {
        if (open == n && closed == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            open++;
            
            backtrack(n);
            
            sb.setLength(sb.length() - 1);
            open--;
        }

        if (open > closed) {
            sb.append(")");
            closed++;
            
            backtrack(n);

            sb.setLength(sb.length() - 1);
            closed--;
        }       
    }

    public List<String> generateParenthesis(int n) {
        backtrack(n);
        return result;
    }
}
