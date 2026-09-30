class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int mostFreq = 0;
        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            // int windowSize = r - l + 1;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(s.charAt(r)));

            while (r - l + 1 - mostFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
