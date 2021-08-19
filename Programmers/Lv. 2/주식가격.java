/*
https://velog.io/@gonudayo/Java-큐-프로그래머스-주식가격/
*/
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            while(!st.isEmpty() && prices[i] < prices[st.peek()]) {
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            answer[st.peek()] = prices.length - st.peek() - 1;
            st.pop();
        }
        
        return answer;
    }
}