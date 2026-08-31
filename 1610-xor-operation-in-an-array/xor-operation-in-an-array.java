class Solution {
    public int xorOperation(int n, int start) {
        int count = 1;
        int xor = 0;
        int i =1;
        int num = start;
        while(count<=n){
            xor^=num;
            num = start + 2*i;
            i++;
            count++;
        }
        return xor;
    }
}