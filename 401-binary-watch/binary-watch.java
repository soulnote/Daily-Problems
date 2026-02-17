class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                int totalBits = countSetBits(hour) + countSetBits(minute);
                if (totalBits == turnedOn) {
                    String time = hour + ":" + String.format("%02d", minute);
                    result.add(time);
                }
            }
        }
        
        return result;
    }
    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}