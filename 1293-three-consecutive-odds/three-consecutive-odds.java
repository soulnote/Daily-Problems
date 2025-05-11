class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i =0;i<arr.length;i++){
            if(arr[i]%2!=0){
                int count = 0,idx = i;
                for(;idx<arr.length && idx<i+3;idx++){
                    if(arr[idx]%2!=0){
                        count++;
                    }
                }
                if(count==3)return true;
            }
        }
        return false;
    }
}