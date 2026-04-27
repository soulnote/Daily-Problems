class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int asteroid = asteroids[i];
            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                int top = st.peek();

                if (Math.abs(top) > Math.abs(asteroid)) {
                    destroyed = true;
                    break;
                } else if (Math.abs(top) < Math.abs(asteroid)) {
                    st.pop();
                } else {
                    st.pop();
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }
        int[] ans = new int[st.size()];
        int idx = st.size() - 1;
        while (!st.isEmpty()) {
            ans[idx--] = st.pop();
        }
        return ans;

    }
}