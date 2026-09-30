class Solution {
    public static final char sep = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int n = str.length();
            sb.append(n);
            sb.append(sep);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ret = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }
            
            int len = Integer.parseInt(str.substring(i, j));
            j++;

            ret.add(str.substring(j, j + len));

            i = j + len;
        }
        return ret;
    }
}
