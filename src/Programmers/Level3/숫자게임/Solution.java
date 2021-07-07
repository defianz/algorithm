package Programmers.Level3.숫자게임;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = idx; j < B.length; j++) {
                if(A[i] < B[j]) {
                    idx = j+1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}