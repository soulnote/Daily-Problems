class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))return "0";

        StringBuilder sb = new StringBuilder(num1);
        num1 = sb.reverse().toString();

        sb = new StringBuilder(num2);
        num2 = sb.reverse().toString();

        int []multArr = new int[num1.length() + num2.length()];

        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                int digit = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                multArr[i+j] += digit;
                multArr[i+j+1] += multArr[i+j]/10;
                multArr[i+j] = multArr[i+j] % 10;
                System.out.print(multArr[i+j]);
            }
            System.out.println();
        }
        int i = multArr.length-1;
        while(i>=0 && multArr[i]==0){
            i--;
        }
        if (i == -1) return "0";
        
        StringBuilder ans = new StringBuilder();
        while(i>=0){
            ans.append(multArr[i]);
            i--;
        }
        return ans.toString();
    }
}