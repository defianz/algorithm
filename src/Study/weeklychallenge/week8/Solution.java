package Study.weeklychallenge.week8;

class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int garo = sizes[i][0];
            int sero = sizes[i][1];
            arr[i][0] = Math.max(garo,sero);
            arr[i][1] = Math.min(garo,sero);
        }

        int ansL = 0;
        int ansR = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i][0] > ansL) ansL = arr[i][0];
            if(arr[i][1] > ansR) ansR = arr[i][1];
        }

        int answer = ansL * ansR;

        return answer;
    }
}