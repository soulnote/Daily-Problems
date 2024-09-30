class CustomStack {
    int[] st;  // Ye array stack ke elements store karega
    int pos = 0;  // Yeh position track karega ki stack ka next element kahan insert hoga
    
    // Constructor: Stack ko maxSize ke size ke sath initialize karte hain
    public CustomStack(int maxSize) {
        st = new int[maxSize];  // Stack ki size maxSize ka array banti hai
    }
    
    // push method: Stack mein ek naya element top par add karta hai
    public void push(int x) {
        if(pos < st.length) {  // Agar stack full nahi hai (position max size se chhoti hai)
            st[pos] = x;  // Element ko current position par add karo
            pos++;  // Position ko aage badhao, taaki next element ke liye jagah mile
        }
    }
    
    // pop method: Stack ke top element ko nikalta hai aur return karta hai
    public int pop() {
        if(pos == 0) {  // Agar stack empty hai (position 0 hai)
            return -1;  // -1 return karo, kyunki koi element nikalne ke liye nahi hai
        }
        pos--;  // Position ko ek peeche karo, taaki top element ko access kar sako
        return st[pos];  // Stack se top element ko return karo
    }
    
    // increment method: Stack ke bottom ke k elements ko increment karta hai
    public void increment(int k, int val) {
        // limit nikalte hain: Kya k elements increment karne hain ya jitne current elements hain (pos)
        int limit = Math.min(k, pos);  // Stack ke current size ke hisaab se limit set karo
        for(int i = 0; i < limit; i++) {  // Bottom ke limit tak elements loop se increment karo
            st[i] += val;  // Element ko val se increment karo
        }
    }
}

