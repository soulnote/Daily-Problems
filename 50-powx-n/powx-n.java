class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long newn = n;//here we are taking long in place of int to prevent the overflow condition
        if (n < 0) {
            newn *= -1;// this can cause the overflow
        }
        while(newn >0){
            if(newn%2 == 0){
                x = x*x;
                newn /=2;
            }
            else{
                ans = x*ans;
                newn -= 1;
            }
        }
        if(n<0) return (double)1.0/ans;
        return ans;
    }
}