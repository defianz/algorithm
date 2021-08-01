package Programmers_1st.Level2.구명보트;

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int[] sortedPeople = new int[people.length];
        for (int i = 0; i < sortedPeople.length; i++) {
            sortedPeople[i]=people[people.length-1-i];
        }

        int idx = 0;
        int eidx = people.length-1;

        while(idx <= eidx){
            if(sortedPeople[idx] <= limit/2){
                answer += Math.ceil(((double)eidx-(double) idx+1)/2);
                break;
            }

           if(sortedPeople[idx] + sortedPeople[eidx] <= limit){
               idx++;
               eidx--;
           } else {
               idx++;
           }
           answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{70,50,80,50},100) = " + s.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println("s.solution(new int[]{70,80,50},100) = " + s.solution(new int[]{70, 80, 50}, 100));
    }
}