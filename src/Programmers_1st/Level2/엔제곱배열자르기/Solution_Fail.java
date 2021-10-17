package Programmers_1st.Level2.엔제곱배열자르기;

import java.util.ArrayList;
import java.util.List;

class Solution_Fail {
    public int[] solution(int n, long left, long right) {
        long ansCnt = right - left + 1;

        int mok = (int) (left / n) + 1 ;
        int rem = (int) (left % n ) + 1 ;

        List<Integer> arr = new ArrayList<>();

        for (int i = rem; i <= n; i++) {
            if(i <= mok) arr.add(mok);
            else arr.add(i);
        }

        for (int i = mok+1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if(cnt < i) {
                    arr.add(i);
                } else {
                    arr.add(j);
                }
                cnt++;
                if(ansCnt == arr.size()){
                    int[] answer = new int[arr.size()];
                    for (int k = 0; k < arr.size(); k++) {
                        answer[k] = arr.get(k);
                    }
                    return answer;
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        int[] solution = s.solution(3, 2, 5);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}