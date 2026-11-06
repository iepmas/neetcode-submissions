class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, List<Character>> map = new HashMap<>();

    private void backtrack(String digits, int i) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }

        // recurse:
        char c = digits.charAt(i);
        List<Character> chars = map.get(c);
        for (Character letter : chars) {
            sb.append(letter);
            backtrack(digits, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        backtrack(digits, 0);
        return result;
    }
}
