package Study.weeklychallenge.second;

class Solution {
    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int n = scores.length;

        for (int i = 0; i < n; i++) {
            boolean dup = false;

            int nowScore = scores[i][i];
            int checkMax = nowScore;
            int checkMin = nowScore;
            int hap = nowScore;
            int cnt = 1;

            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (nowScore == scores[j][i]) dup = true;
                checkMax = Math.max(checkMax, scores[j][i]);
                checkMin = Math.min(checkMin, scores[j][i]);
                hap += scores[j][i];
                cnt++;
            }

            if (dup == false && (checkMax == nowScore || checkMin == nowScore)) {
                hap -= nowScore;
                cnt--;
            }

            double score = (double) hap / (double) cnt;
            if (score >= 90) sb.append('A');
            else if (score >= 80) sb.append('B');
            else if (score >= 70) sb.append('C');
            else if (score >= 50) sb.append('D');
            else sb.append('F');

        }


        return sb.toString();
    }
}