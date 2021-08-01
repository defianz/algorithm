package Programmers_1st.Level3.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int hap = 0;
        int idx = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (int i = 0;;) {
            while(idx < jobs.length && jobs[idx][0] <= i ){
                q.add(jobs[idx]);
                idx++;
            }
            if(idx == jobs.length && q.isEmpty()) break;
            if(!q.isEmpty()){
                int[] tmp = q.poll();
                i = i + tmp[1];
                hap += (i - tmp[0]);
                continue;
            }
            i++;
        }

        int answer = hap /jobs.length;
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{{0, 3}, {1, 9}, {2, 6}}) = " + s.solution(new int[][]{{0, 3}, {2, 6},{1, 9}}));
    }
}