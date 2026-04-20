class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
    
        for(int i=0;i<colors.length;i++){
            int count = 0;
            for(int j=i+1;j<colors.length;j++){
                if(colors[i]!=colors[j]){
                    count = Math.max(count, (j-i));
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}