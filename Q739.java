class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int[] sol = new int[temperatures.length];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < temperatures.length; ++i) {
            while (st.size() > 0 && temperatures[st.peek()] < temperatures[i]) {
                int largerTempIndex = st.pop();
                sol[largerTempIndex] = i - largerTempIndex;
            }
            st.push(i);
        }
        return sol;
    }
}