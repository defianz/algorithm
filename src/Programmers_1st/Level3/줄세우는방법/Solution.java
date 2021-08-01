package Programmers_1st.Level3.줄세우는방법;

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> arl = new ArrayList<>();

        long fn = 1;
        for (int i = 1; i <= n; i++) {
            fn *= i;
            arl.add(i);
        }

        int idx = 0;
        for (int i = n; i >= 1; i--) {
            fn /= i;
            for (int j = 0; j < arl.size(); j++) {
                if (k > fn) k -= fn;
                else {
                    answer[idx++] = arl.get(j);
                    arl.remove(j);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution(3, 6);
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
    }
}