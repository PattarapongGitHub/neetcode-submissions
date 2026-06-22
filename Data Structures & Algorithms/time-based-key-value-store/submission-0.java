class TimeMap {
 HashMap<String, ArrayList<Data>> store = new HashMap<>();

    //Object ที่ไว้เห็น time stamps and value

    class Data {
        String value;
        int timestamp;

        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        ArrayList<Data> list = store.get(key);

        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                // ขยับ left อย่างไรดี?
                left = mid + 1;
            } else {
                // ขยับ right อย่างไรดี?
                right = mid - 1;
            }
        }
        if (right == -1) {
            return "";
        }
        return list.get(right).value;
    }
}