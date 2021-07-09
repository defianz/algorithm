package Programmers.Level3.풍선터트리기;

class Solution {


    public int solution(int[] a) {
        int answer = 2;

        int left = a[0];
        int[] right = new int[a.length];

        right[a.length-2] = a[a.length-1];

        for (int i = a.length-3; i>=0; i--){
            right[i] = Math.min(right[i+1],a[i+1]);
        }

        for (int i = 1; i < a.length-1; i++) {
            if(left < a[i] && right[i] < a[i]){

            }
            else {
                answer++;
            }
            left = Math.min(left,a[i]);
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{9,-1,5}) = " + s.solution(new int[]{9, -1, 5}));
        System.out.println("s.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}) = " + s.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
}