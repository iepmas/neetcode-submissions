class TimeMap {
    private static class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<TimeValue>> map = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<TimeValue> vals = map.get(key);
        int l = 0;
        int r = vals.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int currTimeStamp = vals.get(m).timestamp;
            if (timestamp >= currTimeStamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r >= 0 ? vals.get(r).value : "";

        // for (int i = vals.size() - 1; i >= 0; i--) {
        //     int currTimestamp = vals.get(i).timestamp;
        //     if (timestamp >= currTimestamp) {
        //         return vals.get(i).value;
        //     }
        // }
        // return "";
    }
}
