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
        for (int i = vals.size() - 1; i >= 0; i--) {
            int currTimestamp = vals.get(i).timestamp;
            if (timestamp >= currTimestamp) {
                return vals.get(i).value;
            }
        }
        return "";
    }
}
