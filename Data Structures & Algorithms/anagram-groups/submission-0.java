class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> anagrams;
            if (map.containsKey(key)) {
                anagrams = map.get(key);
            } else {
                anagrams = new ArrayList<>();
            }
            anagrams.add(str);
            map.put(key, anagrams);
        }

        return new ArrayList<>(map.values());
    }
}
