class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows==s.length())return s;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }
        boolean dir  = true; //true for down false for up
        int count = 0;
        int idx =0;
        // int col =0;
        while(idx<s.length()){
            char ch = s.charAt(idx);
            if(count==numRows-1 && dir ==true){
                rows[count].add(ch);
                count-=1;
                dir=false;
                // col++;
            }
            else if(count==0 && dir==false){
                rows[count].add(ch);
                count+=1;
                dir=true;
                // col++;
            }
            else{
                if(dir==true){
                    rows[count].add(ch);
                    count++;
                }
                else{
                    rows[count].add(ch);
                    count--;
                }
            }
            idx++;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<numRows;i++){
            List row = rows[i];
            for(int j=0;j<row.size();j++){
                str.append(row.get(j));
            }
        }
        return str.toString();
        
    }
}