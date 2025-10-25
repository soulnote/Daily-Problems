class Solution {
    public int totalMoney(int n) {
        int amount  =0;
        int weekly = 1;
        while(n>0){
            int newn = Math.min(n, 7);
            n-=newn;
            // int count = 0;
            int val = weekly;
            if(newn == 7)weekly++;
            for(int i=0;i<newn;i++){
                amount+=val;
                val++;
                // count++;
            }
        }
        return amount;
    }
}