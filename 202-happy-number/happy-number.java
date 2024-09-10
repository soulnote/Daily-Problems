class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            int newn = n;
            if(set.contains(newn))return false;
            set.add(newn);
            int sum = 0;
            while(newn >0){
                sum+= (newn%10) * (newn%10);
                newn /=10;
            }
            n = sum;
        }
        if(n==1)return true;
        return false;
    }
}