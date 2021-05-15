package Programmers.Level1.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[] cal= new int[n];

        for (int i = 0; i < n; i++) {
            cal[i] = arr1[i] | arr2[i];

            String tmp = "";
            for(int j=n-1; j>=0; j--){
                if(cal[i] - Math.pow(2,j) >= 0){
                    tmp += "#";
                    cal[i] -= Math.pow(2,j);
                } else {
                    tmp += " ";
                }
            }
            answer[i] = tmp;
        }

        return answer;
    }
}