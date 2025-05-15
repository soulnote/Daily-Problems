import java.util.*;

class TimeMap {

    // Inner class to store value and its corresponding timestamp
    class Entry {
        String value;
        int timestamp;

        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    // Map to store each key with a list of its values over time
    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    // Stores the key with the value and timestamp
    public void set(String key, String value, int timestamp) {
        // Create list if key is not already present
        map.putIfAbsent(key, new ArrayList<>());
        // Add the new entry
        map.get(key).add(new Entry(value, timestamp));
    }

    // Returns the value at the given timestamp or the closest earlier one
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> entries = map.get(key);

        // Binary search to find the latest timestamp ≤ given timestamp
        int left = 0, right = entries.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Entry current = entries.get(mid);

            if (current.timestamp == timestamp) {
                return current.value; // Exact match
            } else if (current.timestamp < timestamp) {
                result = current.value; // Potential result, keep searching right
                left = mid + 1;
            } else {
                right = mid - 1; // Search left
            }
        }

        return result;
    }
}
