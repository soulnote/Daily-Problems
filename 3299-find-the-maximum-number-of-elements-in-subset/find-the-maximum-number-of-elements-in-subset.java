class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for(int num: nums) freq.put((long)num, freq.getOrDefault((long)num, 0) + 1);
        int res = 1;
        for(long key: freq.keySet()) {
            int cur = 0;
            if(key == 1) {
                int val = freq.get(key);
                cur = val % 2 != 0 ? val : val - 1;
            } else {
                while(freq.getOrDefault(key, 0) >= 2) {
                    cur += 2;
                    key = key * key;
                }
                cur = (freq.getOrDefault(key, 0) == 1) ? cur + 1 : cur - 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}