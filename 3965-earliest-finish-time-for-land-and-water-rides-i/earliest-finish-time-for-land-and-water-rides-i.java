class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        
        // Case 1: Pehle Land Ride, fir Water Ride
        for (int i = 0; i < landStartTime.length; i++) {
            int landEndTime = landStartTime[i] + landDuration[i];
            
            for (int j = 0; j < waterStartTime.length; j++) {
                int waterStartTimeActual = Math.max(landEndTime, waterStartTime[j]);
                int totalTime = waterStartTimeActual + waterDuration[j];
                
                min = Math.min(min, totalTime);
            }
        }   
        
        // Case 2: Pehle Water Ride, fir Land Ride
        for (int i = 0; i < waterStartTime.length; i++) {
            int waterEndTime = waterStartTime[i] + waterDuration[i];
            
            for (int j = 0; j < landStartTime.length; j++) {
                int landStartTimeActual = Math.max(waterEndTime, landStartTime[j]);
                int totalTime = landStartTimeActual + landDuration[j];
                
                min = Math.min(min, totalTime);
            }
        } 
        
        return min;
    }
}