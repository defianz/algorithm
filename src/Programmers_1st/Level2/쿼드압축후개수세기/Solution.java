package Programmers_1st.Level2.쿼드압축후개수세기;

class Solution {

    int[] answer = new int[2];

    void foo(int sr, int sc, int sizeR, int[][] arr){
        boolean flag = true;
        int start = arr[sr][sc];
        for (int i = sr; i < sr+sizeR; i++) {
            for (int j = sc; j < sc+sizeR; j++) {
                if(arr[i][j] != start) {
                    flag = false;
                    break;
                }
            }
            if(flag==false) break;
        }

        if(flag == false){
            foo(sr,sc,sizeR/2,arr);
            foo(sr+sizeR/2,sc,sizeR/2,arr);
            foo(sr,sc+sizeR/2,sizeR/2,arr);
            foo(sr+sizeR/2,sc+sizeR/2,sizeR/2,arr);
        } else {
            answer[start] += 1;
            return;
        }
    }

    public int[] solution(int[][] arr) {

        foo(0, 0, arr.length, arr);

        return answer;
    }
}