class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd = 0;
        int sumeven = 0;
        int num = 1;
        int count = 1;
        while(count<=n){
            sumodd += num;
            num+=2;
            count++;
        }
        count = 1;
        num = 2;
        while(count<=n){
            sumeven += num;
            num+=2;
            count++;
        }
        while(sumeven%sumodd>0){
            int rem = sumeven%sumodd;
            sumeven = sumodd;
            sumodd= rem;
        }
        return sumodd;
    }
}