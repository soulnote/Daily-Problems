class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int ans = -1, pre = arr[0],count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==pre ){
                count+=1;
                // System.out.print(count+"when equal to pre");
            }
            else{
                if(arr[i-1]==count){
                    ans = Math.max(ans, count);
                }
                count = 1;
                pre = arr[i];
            }
           
        }
        if(count == pre)ans = Math.max(ans, count);

        return ans;
    }
}