class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : banned){
            set.add(num);
        }
        int count =0;
        for(int i =1;i<=n;i++){
            if(!set.contains(i)){
                sum+=i;
                // System.out.println(i);
                if(sum>maxSum)break;
                count++;
            }
        }
        return count;
    }
}