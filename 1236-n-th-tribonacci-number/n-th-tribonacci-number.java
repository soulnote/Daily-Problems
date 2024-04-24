class Solution {
    public int tribonacci(int n) {
        if(n==0|| n==1)return n;
        if(n==2)return 1;
        int Tprepre = 0, Tpre = 1, Tcurrent = 1;
        for(int i=3;i<=n;i++){
            int Tn = Tprepre + Tpre + Tcurrent;
            Tprepre = Tpre;
            Tpre = Tcurrent;
            Tcurrent = Tn;
        }
        return Tcurrent;
    }
}