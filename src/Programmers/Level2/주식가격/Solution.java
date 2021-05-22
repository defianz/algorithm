package Programmers.Level2.주식가격;

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> st = new Stack<>();
        st.add(prices[0]);

        for (int i = 1; i < prices.length; i++) {
            int nxt = prices[i];
            if(st.empty() || st.peek() <= nxt ){
                st.add(nxt);
            } else {
                int time = 1;
                int idx = i-1;
                while(!st.empty() && st.peek() > nxt){
                    if(answer[idx] != 0 ) {
                        idx--;
                        time++;
                        continue;
                    }
                    answer[idx--] = time++;
                    st.pop();
                }
                st.add(nxt);
            }
        }

        for (int i = 0; i < answer.length-1; i++) {
            if(answer[i] == 0) answer[i] = answer.length-1-i;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution(new int[]{5, 8, 6, 2, 4, 1});
//        int[] tmp = s.solution(new int[]{2, 1, 2, 1, 2, 1});
        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}


//class Solution {
//    public int[] solution(int[] prices) {
//        int len = prices.length;
//        int[] answer = new int[len];
//        int i, j;
//        for (i = 0; i < len; i++) {
//            for (j = i + 1; j < len; j++) {
//                answer[i]++;
//                if (prices[i] > prices[j])
//                    break;
//            }
//        }
//        return answer;
//    }
//}